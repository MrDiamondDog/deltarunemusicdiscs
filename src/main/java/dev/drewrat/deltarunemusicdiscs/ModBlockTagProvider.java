package dev.drewrat.deltarunemusicdiscs;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, DeltaruneMusicDiscs.MODID, null);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.PROPHECY_LOG.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.PROPHECY_PLANKS.get());

        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.PROPHECY_LEAVES_RED.get())
                .add(ModBlocks.PROPHECY_LEAVES_PURPLE.get())
                .add(ModBlocks.PROPHECY_LEAVES_MAGENTA.get());
    }
}