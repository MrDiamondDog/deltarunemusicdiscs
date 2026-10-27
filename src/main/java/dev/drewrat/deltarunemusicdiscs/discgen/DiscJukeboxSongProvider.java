package dev.drewrat.deltarunemusicdiscs.discgen;

import dev.drewrat.deltarunemusicdiscs.DeltaruneMusicDiscs;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DiscJukeboxSongProvider extends DatapackBuiltinEntriesProvider {
    public DiscJukeboxSongProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registryProvider) {
        super(output,
                registryProvider,
                new RegistrySetBuilder()
                    .add(Registries.JUKEBOX_SONG, bootstrap -> {
                        for (var song : MusicDiscs.musicDiscs) {
                            bootstrap.register(ResourceKey.create(Registries.JUKEBOX_SONG, song.getLocation()), song.generateSong());
                        }
                    }),
                Collections.singleton(DeltaruneMusicDiscs.MODID)
        );
    }
}
