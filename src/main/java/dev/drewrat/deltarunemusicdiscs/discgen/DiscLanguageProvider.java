package dev.drewrat.deltarunemusicdiscs.discgen;

import dev.drewrat.deltarunemusicdiscs.DeltaruneMusicDiscs;
import dev.drewrat.deltarunemusicdiscs.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class DiscLanguageProvider extends LanguageProvider {
    public DiscLanguageProvider(PackOutput output) {
        super(output, DeltaruneMusicDiscs.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.deltarunemusicdiscs", "Deltarune Music Discs");
        add("deltarunemusicdiscs.configuration.title", "Deltarune Music Discs Configs");
        add("deltarunemusicdiscs.configuration.section.deltarunemusicdiscs.common.toml", "Deltarune Music Discs Configs");
        add("deltarunemusicdiscs.configuration.section.deltarunemusicdiscs.common.toml.title", "Deltarune Music Discs Configs");

        add(ModItems.PROPHECY_LOG_ITEM.get(), "Prophecy Log");
        add(ModItems.PROPHECY_PLANKS_ITEM.get(), "Prophecy Planks");
        add(ModItems.PROPHECY_LEAVES_RED_ITEM.get(), "Red Prophecy Leaves");
        add(ModItems.PROPHECY_LEAVES_PURPLE_ITEM.get(), "Purple Prophecy Leaves");
        add(ModItems.PROPHECY_LEAVES_MAGENTA_ITEM.get(), "Magenta Prophecy Leaves");

        for (var disc : MusicDiscs.musicDiscs) {
            add(disc.getItem().get(), "Deltarune Chapter " + disc.getChapter() + " Music Disc");
        }
    }
}
