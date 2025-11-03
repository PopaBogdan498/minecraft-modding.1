package com.makingrandoms.item;

import com.makingrandoms.Makingrandoms;
import com.makingrandoms.item.custom.FuelItem;
import com.makingrandoms.item.custom.MagicWandItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, Makingrandoms.MOD_ID);

    public static final RegistryObject<Item> OBAMIUM = ITEMS.register("obamium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_OBAMIUM = ITEMS.register("raw_obamium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGIC_WAND = ITEMS.register("magic_wand", () -> new MagicWandItem(new Item.Properties().durability(6)));
    public static final RegistryObject<Item> HOTDOG = ITEMS.register("hotdog", () -> new Item(new Item.Properties().food(ModFoodProperties.HOTDOG)){
        @Override
        public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
            pTooltipComponents.add(Component.translatable("tooltip.makingrandoms.hotdog"));
            super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        }
    });
    public static final RegistryObject<Item> JET_FUEL = ITEMS.register("jet_fuel", () -> new FuelItem(new Item.Properties(), 1200));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
