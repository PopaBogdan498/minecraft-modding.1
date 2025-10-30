package com.makingrandoms.item;

import com.makingrandoms.Makingrandoms;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, Makingrandoms.MOD_ID);

    public static final RegistryObject<Item> OBAMIUM = ITEMS.register("obamium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_OBAMIUM = ITEMS.register("raw_obamium", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
