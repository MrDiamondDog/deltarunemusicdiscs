package dev.drewrat.deltarunemusicdiscs.discgen;

import dev.drewrat.deltarunemusicdiscs.DeltaruneMusicDiscs;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.ItemModelGenerators;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DiscModelProvider extends ItemModelProvider {
    public DiscModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DeltaruneMusicDiscs.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (var disc : MusicDiscs.musicDiscs) {
            this.withExistingParent(disc.getKey(), modLoc("item/disc_chapter_" + disc.getChapter()));
        }
    }
}
