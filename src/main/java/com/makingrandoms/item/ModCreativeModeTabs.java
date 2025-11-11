package com.makingrandoms.item;

import com.makingrandoms.Makingrandoms;
import com.makingrandoms.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Makingrandoms.MOD_ID);

    public static final RegistryObject<CreativeModeTab> OBAMIUM_ITEMS_TAB = CREATIVE_MODE_TAB.register(
            "obamium_items_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.OBAMIUM.get()))
                    .title(Component.translatable("creativetab.makingrandoms.obamium_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.OBAMIUM.get());
                        output.accept(ModItems.RAW_OBAMIUM.get());
                        output.accept(ModItems.MAGIC_WAND.get());
                        output.accept(ModItems.HOTDOG.get());
                        output.accept(ModItems.JET_FUEL.get());
                        output.accept(ModItems.OBAMIUM_SWORD.get());
                        output.accept(ModItems.OBAMIUM_PICKAXE.get());
                        output.accept(ModItems.OBAMIUM_SHOVEL.get());
                        output.accept(ModItems.OBAMIUM_AXE.get());
                        output.accept(ModItems.OBAMIUM_HOE.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> OBAMIUM_BLOCKS_TAB = CREATIVE_MODE_TAB.register(
            "obamium_blocks_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.OBAMIUM_PRISM.get()))
                    .withTabsBefore(OBAMIUM_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.makingrandoms.obamium_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.OBAMIUM_PRISM.get());
                        output.accept(ModBlocks.OBAMIUM_ORE.get());
                        output.accept(ModBlocks.OBAMIUM_STAIRS.get());
                        output.accept(ModBlocks.OBAMIUM_SLAB.get());
                        output.accept(ModBlocks.OBAMIUM_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.OBAMIUM_BUTTON.get());
                        output.accept(ModBlocks.OBAMIUM_FENCE.get());
                        output.accept(ModBlocks.OBAMIUM_GATE.get());
                        output.accept(ModBlocks.OBAMIUM_WALL.get());
                        output.accept(ModBlocks.OBAMIUM_DOOR.get());
                        output.accept(ModBlocks.OBAMIUM_TRAPDOOR.get());
                        output.accept(ModBlocks.MAGIC_BLOCK.get());
                        output.accept(ModBlocks.PAPER_LANTERN.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
