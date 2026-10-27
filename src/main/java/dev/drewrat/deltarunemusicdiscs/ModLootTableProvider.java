package dev.drewrat.deltarunemusicdiscs;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Collections;
import java.util.Set;

public class ModLootTableProvider extends BlockLootSubProvider {
    protected ModLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries()
                .stream()
                .map(e -> (Block) e.value())
                .toList();
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.PROPHECY_LOG.get());
        this.dropSelf(ModBlocks.PROPHECY_PLANKS.get());
        this.add(ModBlocks.PROPHECY_LEAVES_RED.get(), silkTouchOrShearsBuilder(ModBlocks.PROPHECY_LEAVES_RED.get(), ModItems.PROPHECY_LEAVES_RED_ITEM.get()));
        this.add(ModBlocks.PROPHECY_LEAVES_PURPLE.get(), silkTouchOrShearsBuilder(ModBlocks.PROPHECY_LEAVES_PURPLE.get(), ModItems.PROPHECY_LEAVES_PURPLE_ITEM.get()));
        this.add(ModBlocks.PROPHECY_LEAVES_MAGENTA.get(), silkTouchOrShearsBuilder(ModBlocks.PROPHECY_LEAVES_MAGENTA.get(), ModItems.PROPHECY_LEAVES_MAGENTA_ITEM.get()));
    }

    private LootTable.Builder silkTouchOrShearsBuilder(Block block, Item item) {
        return this.createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(item).when(HAS_SHEARS.or(this.hasSilkTouch())));
    }
}