package org.dani_adbg.modtutorial;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.dani_adbg.modtutorial.block.ModBlocks;
import org.dani_adbg.modtutorial.item.ModCreativeModTabs;
import org.dani_adbg.modtutorial.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Mod_tutorial.MOD_ID)
public class Mod_tutorial {

    public static final String MOD_ID = "mod_tutorial";
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public Mod_tutorial() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    
        // LLAMA LA FUNCIÓN PARA REGISTRAR LA NUEVA TAB
        ModCreativeModTabs.register(modEventBus);
        // LLAMA LA FUNCIÓN PARA REGISTRAR LOS ITEMS
        ModItems.register(modEventBus);
        // LLAMA LA FUNCIÓN PARA REGISTRAR LOS BLOQUES
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // AGREGA EL ITEM A LA PESTAÑA DE INGREDIENTES
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SILVER);
            event.accept(ModItems.SILVER_NUGGET);
        }
        // AGREGA EL ITEM A LA PESTAÑA DE BLOQUES
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.SILVER_BLOCK);
            event.accept(ModBlocks.SILVER_ORE);
        }
    }
}
