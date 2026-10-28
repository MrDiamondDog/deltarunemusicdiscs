package dev.drewrat.deltarunemusicdiscs;

import dev.drewrat.deltarunemusicdiscs.discgen.MusicDisc;
import dev.drewrat.deltarunemusicdiscs.discgen.MusicDiscs;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntry;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class ProphecyTreeLootTableSubProvider implements LootTableSubProvider {
    private HolderLookup.Provider lookupProvider;

    public ProphecyTreeLootTableSubProvider(HolderLookup.Provider lookupProvider) {
        this.lookupProvider = lookupProvider;
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        String[] chapters = {"1", "2", "3", "4", "5"};

        LootTable.Builder lootTable = LootTable.lootTable();

        for (int i = 0; i < chapters.length; i++) {
            int finalI = i;
            LootPool.Builder pool = LootPool.lootPool();

            Stream<MusicDisc> discs = Arrays.stream(MusicDiscs.musicDiscs).filter(disc -> disc.getChapter().equals(chapters[finalI]));
            for (MusicDisc disc : discs.toList()) {
                pool.add(LootItem.lootTableItem(disc.getItem()));
            }

            pool.setRolls(UniformGenerator.between(1, 2)).setBonusRolls(UniformGenerator.between(1, 2));
            lootTable.withPool(pool);
        }

        biConsumer.accept(
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(DeltaruneMusicDiscs.MODID, "prophecy_tree_chest")),
                lootTable
        );
    }
}
