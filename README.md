# Deltarune Music Discs

A Neoforge mod for Minecraft 1.21.1 that adds 127 music discs from DELTARUNE! All the discs can be found under special rare trees found in forests.

<img width="2560" height="1440" alt="2026-10-27_15 45 58" src="https://github.com/user-attachments/assets/7bd2e688-ce26-4a65-a7b6-6a495fb59822" />

All rights reserved to Toby Fox for DELTARUNE, as well as Materia Collective for music.
No music files are hosted on this repository, but there is a helper script to get the music from your DELTARUNE installation.

## Installation

Download from [Modrinth] (TODO: add link when I upload it) or download the jar from the releases page and put it in your mod folder.

## Building

>[!NOTE]
> To properly build this mod yourself, you need a copy of DELTARUNE. This is because the song files are not included in this
> repository, and you must run a script to fetch them from your copy of DELTARUNE.

Once you've cloned the repo, you'll need to pull all the music files from DELTARUNE for the mod to play music.
To pull the music, there is a `fetch_songs.js` Node.js script that reads the `song_list.json` file, which is a map of the disc keys to the filename in DELTARUNE's files. (Tricky Tony doesn't name the files very well)

> [!NOTE]
> The script requires ffmpeg, as it needs to convert all the files from stereo to mono audio. 
> Make sure it is installed on your PATH.

To use the script, simply run `node fetch_songs.js --deltarune_path full/path/to/your/DELTARUNE/`
It will pull all the files it can. Look through the logs to make sure they are all successful.

All files are placed in `src/main/resources/assets/deltarunemusicdiscs/sounds/records`.

There are a subset of files it cannot fetch, as they do not exist in the game's code or require additional processing.

> [!WARNING]
> Minecraft requires the files to be in .OGG format, and also requires that the file is mono audio, not stereo.
> The simplest way to make any file work is to open it in Audacity, select the track, and from the menubar `Tracks > Mix > Mix Stereo Down to Mono`,
> then export as a .OGG file.
> If you use a different audio processing software, it should be about the same process.

Here are the instructions for those files:
- Ripple: This song is in a million pieces in the game files, so I downloaded it from Spotify. Use whatever method you see fit.
- Garden of Hopes and Dreams: In two pieces in the game files, you need to combine them yourself.
  - Open an audio processing software such as Audacity and place `field_of_hopes_insaneintherain_intro.ogg` in front of `field_of_hopes_insaneintherain_loop.ogg`.
  - Make sure you export it correctly as described above.
- The Sunset of 7 Suns: This is the early version of Sunset of Seven Suns that Toby posted on his Twitter/Bluesky.
  - You can download it from the [DELTARUNE Wiki](https://deltarune.wiki/images/The_Sunset_of_7_Suns_music.mp3?cb=4j9b8f&h=thumb.php&f=The_Sunset_of_7_Suns_music.mp3).
  - Make sure you follow the steps above to make it the correct format.

After you've added all of these songs, the mod should be ready!

### Adding a song

> [!NOTE]
> This requires *some* basic programming knowledge, and assumes you already used the steps above to set up the project.

To add a song (or sound effect or whatever), do the following:
- Open your IDE of choice (This project was made with IntelliJ IDEA)
- Open `src/main/dev/drewrat/deltarunemusicdiscs/discgen/MusicDiscs.java`
- Add a new entry in the `musicDiscs` array, following the format of all the other ones
  - `new MusicDisc(key, description, length, chapter)`
    - Key should be in the format of `disc_(song name in all lowercase, underscores instead of spaces, no special characters)`
    - Description follows this format: `Name of song - Artists separated by commas`
      - For example, `Garden of Hopes and Dreams - Toby Fox, insaneintherainmusic`
    - Length is simply the length of the song in minutes and seconds, separated by a colon, as follows: `1:23`
    - Chapter is the chapter the song comes from! Use the first chapter it appears in if it's in multiple.
      - If a chapter number isn't applicable for one reason or another, use 0.
  - Please keep the entries grouped by chapter, and sorted by placement in the soundtrack!
- Place the song in `src/main/resources/assets/deltarunemusicdiscs/sounds/records`, following all the steps above.
- Run the `runData` Gradle task.
- If this runs without error, you are done!

## AI Note

This project uses **NO AI**! All code and documentation is handwritten, all images and sprites are handmade.
