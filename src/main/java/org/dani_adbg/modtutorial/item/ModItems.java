package org.dani_adbg.modtutorial.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.dani_adbg.modtutorial.Mod_tutorial;

public class ModItems {

  // OBTIENE LA LISTA DE ITEMS Y CREA UN ITEM NUEVO
  public static final DeferredRegister<Item> ITEMS =
          DeferredRegister.create(ForgeRegistries.ITEMS, Mod_tutorial.MOD_ID);

  // CREA EL OBJETO SILVER
  public static final RegistryObject<Item> SILVER = ITEMS.register("silver",
          () -> new Item(new Item.Properties()));

  // CREA LA FUNCIÓN REGISTER
  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }

}
