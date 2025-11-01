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
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
