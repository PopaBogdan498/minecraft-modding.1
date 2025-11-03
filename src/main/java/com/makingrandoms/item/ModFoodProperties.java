package com.makingrandoms.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties HOTDOG = new FoodProperties.Builder().nutrition(3).saturationModifier(1.0F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100), 0.90f).build();

}
