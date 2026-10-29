package dev.drewrat.deltarunemusicdiscs;

import dev.drewrat.deltarunemusicdiscs.discgen.MusicDiscs;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(DeltaruneMusicDiscs.MODID)
public class DeltaruneMusicDiscs {
    public static final String MODID = "deltarunemusicdiscs";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register("deltarune_music_discs_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.deltarunemusicdiscs"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.PROPHECY_LOG_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModItems.PROPHECY_LOG_ITEM.get());
                output.accept(ModItems.PROPHECY_PLANKS_ITEM.get());
                output.accept(ModItems.PROPHECY_LEAVES_RED_ITEM.get());
                output.accept(ModItems.PROPHECY_LEAVES_PURPLE_ITEM.get());
                output.accept(ModItems.PROPHECY_LEAVES_MAGENTA_ITEM.get());

                for (var disc : MusicDiscs.musicDiscs) {
                    output.accept(disc.getItem());
                }
            }).build());

    public DeltaruneMusicDiscs(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        MusicDiscs.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(DataGenerators::onGatherData);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }
}
