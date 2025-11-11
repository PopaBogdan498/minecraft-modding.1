package com.makingrandoms.item;

import com.makingrandoms.util.Modtags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier OBAMIUM = new ForgeTier(2800, 7, 9f, 25,
            Modtags.Blocks.NEEDS_OBAMIUM_TOOL, () -> Ingredient.of(ModItems.OBAMIUM.get()),
            Modtags.Blocks.INCORRECT_FOR_OBAMIUM_TOOL);
}
