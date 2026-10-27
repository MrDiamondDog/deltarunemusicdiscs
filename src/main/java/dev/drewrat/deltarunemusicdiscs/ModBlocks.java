package dev.drewrat.deltarunemusicdiscs;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DeltaruneMusicDiscs.MODID);

    public static final DeferredBlock<Block> PROPHECY_LOG = BLOCKS.register("prophecy_log", registryName -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final DeferredBlock<Block> PROPHECY_PLANKS = BLOCKS.register("prophecy_planks", registryName -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));

    public static final DeferredBlock<Block> PROPHECY_LEAVES_RED = BLOCKS.register("prophecy_leaves_red", registryName -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> PROPHECY_LEAVES_PURPLE = BLOCKS.register("prophecy_leaves_purple", registryName -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
    public static final DeferredBlock<Block> PROPHECY_LEAVES_MAGENTA = BLOCKS.register("prophecy_leaves_magenta", registryName -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
