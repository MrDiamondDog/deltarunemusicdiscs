package dev.drewrat.deltarunemusicdiscs;

import dev.drewrat.deltarunemusicdiscs.discgen.DiscJukeboxSongProvider;
import dev.drewrat.deltarunemusicdiscs.discgen.DiscLanguageProvider;
import dev.drewrat.deltarunemusicdiscs.discgen.DiscModelProvider;
import dev.drewrat.deltarunemusicdiscs.discgen.DiscSoundDefinitionProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DataGenerators {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(
                        new LootTableProvider.SubProviderEntry(ModLootTableProvider::new, LootContextParamSets.BLOCK),
                        new LootTableProvider.SubProviderEntry(ProphecyTreeLootTableSubProvider::new, LootContextParamSets.CHEST)
                ), lookupProvider));

        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookupProvider);
        generator.addProvider(event.includeServer(), blockTagsProvider);

        generator.addProvider(event.includeClient(), new DiscModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new DiscJukeboxSongProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeClient(), new DiscSoundDefinitionProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new DiscLanguageProvider(packOutput));
    }
}