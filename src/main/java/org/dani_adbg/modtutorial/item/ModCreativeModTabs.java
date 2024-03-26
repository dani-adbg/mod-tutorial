package org.dani_adbg.modtutorial.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.dani_adbg.modtutorial.Mod_tutorial;
import org.dani_adbg.modtutorial.block.ModBlocks;

public class ModCreativeModTabs {
  // OBTIENE LA LISTA DE TABS DEL INVENTARIO DE CREATIVO Y CREA UNO NUEVO
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
          DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Mod_tutorial.MOD_ID);

  // CREA EL NUEVO TAB CON LAS PROPIEDADES ESPECIFICADAS
  public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("modtutorial_tab",
          () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SILVER.get()))
                  .title(Component.translatable("creativetab.modtutorial_tab"))
                  .displayItems((pParameters, pOutput) -> {
                    pOutput.accept(ModItems.SILVER.get());
                    pOutput.accept(ModItems.SILVER_NUGGET.get());
                    // pOutput.accept(ModItems.PLATINUM.get());

                    pOutput.accept((ModBlocks.SILVER_BLOCK.get()));
                    pOutput.accept((ModBlocks.SILVER_ORE.get()));
                    pOutput.accept((ModBlocks.NETHER_SILVER_ORE.get()));
                  })
                  .build()
  );

  // CREA LA FUNCIÓN REGISTER
  public static void register(IEventBus eventBus) {
    CREATIVE_MODE_TABS.register(eventBus);
  }
}
