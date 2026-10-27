import { exec } from "node:child_process";
import { copyFileSync, existsSync, readFileSync } from "node:fs";
import path from "node:path";

const songList = "./song_list.json";
const outputFolder = "./src/main/resources/assets/deltarunemusicdiscs/sounds/records";
const deltarunePath = process.argv[process.argv.indexOf("--deltarune_path") + 1];

let total = 0;
let success = 0;
let alreadyExists = 0;
let requiresManual = 0;
let failed = 0;

if (!deltarunePath)
    throw "Deltarune path not specified";

function copySoundFile(modKey, filename) {
	const filePath = path.join(deltarunePath, "mus", filename.includes(".") ? filename : filename + ".ogg");
	const outputPath = path.join(outputFolder, modKey + ".ogg");

	if (existsSync(outputPath)) {
		console.log(`${outputPath} already exists, skipping`);
		alreadyExists++;
		return;
	}

	if (!existsSync(filePath)) {
		failed++;
		throw `Deltarune sound file ${filePath} does not exist`;
	}

	console.log(`Converting ${filePath} -> ${outputPath}`);
	const process = exec(`ffmpeg -i ${filePath} -ac 1 ${outputPath}`)
	process.on("error", e => { console.error(e); failed++; });
	process.on("exit", () => success++);
}

const songListData = JSON.parse(readFileSync(songList, { encoding: "utf-8" }));
total = Object.keys(songListData).length;
console.log(`Converting ${total} songs`)
for (const modKey in songListData) {
	if (songListData[modKey] === null) {
		console.log(`Skipping ${modKey} with no Deltarune music file`)
		requiresManual++;
		continue;
	}
	copySoundFile(modKey, songListData[modKey]);
}

console.log(`Success: ${success}/${total}`);
console.log(`Failed: ${failed}/${total}`);
console.log(`Already Exists: ${alreadyExists}/${total}`);
console.log(`Requires Manual Addition: ${requiresManual}/${total}`);
