import { exec, spawn } from "node:child_process";
import { copyFileSync, existsSync, readFileSync, rmSync } from "node:fs";
import path from "node:path";
import { cwd } from "node:process";

const songList = "./song_list.json";
const outputFolder = "./src/main/resources/assets/deltarunemusicdiscs/sounds/records";
const deltarunePath = process.argv[process.argv.indexOf("--deltarune_path") + 1];

const removeOld = process.argv.includes("--remove");

let total = 0;
let success = 0;
let alreadyExists = 0;
let requiresManual = 0;
let failedValidation = 0;
let failed = 0;

if (!deltarunePath)
    throw "Deltarune path not specified";

async function copySoundFile(modKey, filename) {
	const filePath = path.join(deltarunePath, "mus", filename.endsWith(".mp4") ? filename : filename + ".ogg");
	const outputPath = path.join(outputFolder, modKey + ".ogg");

	if (!existsSync(filePath)) {
		failed++;
		console.error(`Deltarune sound file ${filePath} does not exist`);
		return;
	}

	if (existsSync(outputPath)) {
		if (removeOld) {
			console.log(`${outputPath} already exists, removing`);
			rmSync(outputPath);
		} else {
			console.log(`${outputPath} already exists, skipping`);
			return;
		}
	}

	console.log(`Converting ${filePath} -> ${outputPath}`);
	await new Promise(resolve => {
		const process = exec(`ffmpeg -i ${filePath} -ac 1 ${outputPath}`)
		process.on("error", e => {
			console.error(e);
			failed++;
			resolve();
		});
		process.on("exit", () => {
			success++;
			resolve();
		});
	});
}

async function validateSoundLength(modKey, filename, length) {
	const lengthInSec = parseInt(length.split(":")[0]) * 60 + parseInt(length.split(":")[1]);
	const filePath = path.join(cwd(), outputFolder, modKey + ".ogg");

	if (!existsSync(filePath)) {
		failedValidation++;
		throw `Copied sound file ${filePath} does not exist`;
	}

	console.log(`Verifying length of ${modKey} (${length})`);
	await new Promise(resolve => {
		const process = exec(`ffprobe -i \"${filePath}\" -show_entries format=duration -of csv="p=0" -v quiet`);

		process.stdout.on("data", data => {
			const outputLengthSec = parseInt(data.trim());
			if (Math.abs(outputLengthSec - lengthInSec) < 5) {
				console.log(`Validation passed for ${modKey}`);
				resolve();
			} else {
				console.log(`Validation FAILED for ${modKey} (expected ${lengthInSec}, got ${outputLengthSec})`);
				failedValidation++;
			}
		});

		process.on("exit", () => {
			resolve();
		});
		process.on("error", e => {
			console.error(e);
			failedValidation++;
			resolve();
		});
	});
}

const songListData = JSON.parse(readFileSync(songList, { encoding: "utf-8" }));
total = Object.keys(songListData).length;
console.log(`Converting ${total} songs`);
for (const modKey in songListData) {
	if (songListData[modKey].filename === null) {
		console.log(`Skipping ${modKey} with no Deltarune music file`);
		requiresManual++;
		continue;
	}
	await copySoundFile(modKey, songListData[modKey].filename);
	await validateSoundLength(modKey, songListData[modKey].filename, songListData[modKey].length);
}

console.log("-----------------------------------------------------------------");

console.log(`Success: ${success}/${total - requiresManual}`);
console.log(`Failed: ${failed}/${total - requiresManual}`);
console.log(`Already Exists: ${alreadyExists}/${total}`);
console.log(`Failed Validation: ${failedValidation}/${total - requiresManual}`);
console.log(`Requires Manual Addition: ${requiresManual} (See README)`);
