package dev.drewrat.deltarunemusicdiscs.discgen;

import dev.drewrat.deltarunemusicdiscs.DeltaruneMusicDiscs;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MusicDisc {
    private final String key;
    private final String description;
    private final int lengthInSeconds;
    // Would be an int but 7b will exist...
    private final String chapter;

    private final ResourceLocation location;

    private DeferredItem<Item> item;
    private DeferredHolder<JukeboxSong, JukeboxSong> jukeboxSong;
    private DeferredHolder<SoundEvent, SoundEvent> soundEvent;

    public MusicDisc(String key, String description, String length, String chapter) {
        this.key = key;
        this.description = description;
        this.chapter = chapter;

        String[] lengthSplit = length.split(":");
        lengthInSeconds = Integer.parseInt(lengthSplit[0]) * 60 + Integer.parseInt(lengthSplit[1]);

        this.location = ResourceLocation.fromNamespaceAndPath(DeltaruneMusicDiscs.MODID, key);
    }

    public void register(DeferredRegister.Items itemRegister, DeferredRegister<SoundEvent> soundEventRegister, DeferredRegister<JukeboxSong> songRegister) {
        DeltaruneMusicDiscs.LOGGER.debug("Registering music disc -> {}", key);
        this.soundEvent = soundEventRegister.register(key, () -> SoundEvent.createVariableRangeEvent(location));
        this.jukeboxSong = songRegister.register(key, this::generateSong);
        this.item = itemRegister.registerItem(key, registryKey -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(jukeboxSong.getKey())));
    }

    public JukeboxSong generateSong() {
        return new JukeboxSong(soundEvent, Component.literal(description), (float) lengthInSeconds, 6);
    }


    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getChapter() {
        return chapter;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public DeferredItem<Item> getItem() {
        return item;
    }

    public DeferredHolder<JukeboxSong, JukeboxSong> getJukeboxSong() {
        return jukeboxSong;
    }

    public DeferredHolder<SoundEvent, SoundEvent> getSoundEvent() {
        return soundEvent;
    }
}
