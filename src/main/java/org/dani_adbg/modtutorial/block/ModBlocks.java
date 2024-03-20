package org.dani_adbg.modtutorial.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.dani_adbg.modtutorial.Mod_tutorial;
import org.dani_adbg.modtutorial.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
  public static final DeferredRegister<Block> BLOCKS =
          DeferredRegister.create(ForgeRegistries.BLOCKS, Mod_tutorial.MOD_ID);

  // CREA EL OBJETO SILVER
  public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
          () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.GRASS)));

  public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn);
    return toReturn;
  }

  public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
    return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
  }

  // CREA LA FUNCIÓN REGISTER
  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
