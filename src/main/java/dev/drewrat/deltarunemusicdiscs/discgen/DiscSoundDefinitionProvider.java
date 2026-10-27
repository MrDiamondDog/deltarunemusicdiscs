package dev.drewrat.deltarunemusicdiscs.discgen;

import dev.drewrat.deltarunemusicdiscs.DeltaruneMusicDiscs;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class DiscSoundDefinitionProvider extends SoundDefinitionsProvider {
    public DiscSoundDefinitionProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, DeltaruneMusicDiscs.MODID, helper);
    }

    @Override
    public void registerSounds() {
        for (var disc : MusicDiscs.musicDiscs) {
            add(disc.getSoundEvent(), SoundDefinition.definition()
                    .with(
                            sound("deltarunemusicdiscs:records/" + disc.getKey(), SoundDefinition.SoundType.SOUND)
                                    .stream(true)
                    )
            );
        }
    }
}
