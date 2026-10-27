package dev.drewrat.deltarunemusicdiscs;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DeltaruneMusicDiscs.MODID);

    public static final DeferredItem<BlockItem> PROPHECY_LOG_ITEM = ITEMS.registerSimpleBlockItem("prophecy_log", ModBlocks.PROPHECY_LOG);

    public static final DeferredItem<BlockItem> PROPHECY_PLANKS_ITEM = ITEMS.registerSimpleBlockItem("prophecy_planks", ModBlocks.PROPHECY_PLANKS);

    public static final DeferredItem<BlockItem> PROPHECY_LEAVES_RED_ITEM = ITEMS.registerSimpleBlockItem("prophecy_leaves_red", ModBlocks.PROPHECY_LEAVES_RED);
    public static final DeferredItem<BlockItem> PROPHECY_LEAVES_PURPLE_ITEM = ITEMS.registerSimpleBlockItem("prophecy_leaves_purple", ModBlocks.PROPHECY_LEAVES_PURPLE);
    public static final DeferredItem<BlockItem> PROPHECY_LEAVES_MAGENTA_ITEM = ITEMS.registerSimpleBlockItem("prophecy_leaves_magenta", ModBlocks.PROPHECY_LEAVES_MAGENTA);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
