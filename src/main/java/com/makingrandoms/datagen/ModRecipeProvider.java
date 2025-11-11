package com.makingrandoms.datagen;

import com.makingrandoms.block.ModBlocks;
import com.makingrandoms.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> SMELTABLES = List.of(ModItems.RAW_OBAMIUM.get(), ModBlocks.OBAMIUM_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OBAMIUM_PRISM.get())
                .pattern("OOO")
                .pattern("OOO")
                .pattern("OOO")
                .define('O', ModItems.OBAMIUM.get())
                .unlockedBy(getHasName(ModItems.OBAMIUM.get()), has(ModItems.OBAMIUM.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OBAMIUM.get(), 9)
                .requires(ModBlocks.OBAMIUM_PRISM.get())
                .unlockedBy(getHasName(ModBlocks.OBAMIUM_PRISM.get()), has(ModBlocks.OBAMIUM_PRISM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MAGIC_WAND.get())
                .pattern(" OO")
                .pattern(" SO")
                .pattern("S  ")
                .define('O', ModItems.OBAMIUM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBAMIUM.get()), has(ModItems.OBAMIUM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK.get())
                .pattern("GIN")
                .pattern("DSO")
                .pattern("RLC")
                .define('O', ModItems.OBAMIUM.get())
                .define('G', Items.GOLD_INGOT)
                .define('I', Items.IRON_INGOT)
                .define('R', Items.REDSTONE)
                .define('D', Items.DIAMOND)
                .define('S', Items.NETHER_STAR)
                .define('N', Items.NETHERITE_INGOT)
                .define('L', Items.LAPIS_LAZULI)
                .define('C', Items.COPPER_INGOT)
                .unlockedBy(getHasName(ModItems.OBAMIUM.get()), has(ModItems.OBAMIUM.get())).save(pRecipeOutput);

        stairBuilder(ModBlocks.OBAMIUM_STAIRS.get(), Ingredient.of(ModItems.OBAMIUM.get())).group("obamium")
                        .unlockedBy(getHasName(ModItems.OBAMIUM.get()), has(ModItems.OBAMIUM.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBAMIUM_SLAB.get(), ModItems.OBAMIUM.get());

        buttonBuilder(ModBlocks.OBAMIUM_BUTTON.get(), Ingredient.of(ModItems.OBAMIUM.get())).group("obamium")
                .unlockedBy(getHasName(ModItems.OBAMIUM.get()), has(ModItems.OBAMIUM.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.OBAMIUM_PRESSURE_PLATE.get(), ModItems.OBAMIUM.get());

        fenceBuilder(ModBlocks.OBAMIUM_FENCE.get(), Ingredient.of(ModItems.OBAMIUM.get())).group("obamium")
                .unlockedBy(getHasName(ModItems.OBAMIUM.get()), has(ModItems.OBAMIUM.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.OBAMIUM_GATE.get(), Ingredient.of(ModItems.OBAMIUM.get())).group("obamium")
                .unlockedBy(getHasName(ModItems.OBAMIUM.get()), has(ModItems.OBAMIUM.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBAMIUM_WALL.get(), ModItems.OBAMIUM.get());

        doorBuilder(ModBlocks.OBAMIUM_DOOR.get(), Ingredient.of(ModItems.OBAMIUM.get())).group("obamium")
                .unlockedBy(getHasName(ModItems.OBAMIUM.get()), has(ModItems.OBAMIUM.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.OBAMIUM_TRAPDOOR.get(), Ingredient.of(ModItems.OBAMIUM.get())).group("obamium")
                .unlockedBy(getHasName(ModItems.OBAMIUM.get()), has(ModItems.OBAMIUM.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PAPER_LANTERN.get())
                .pattern("PPP")
                .pattern("P P")
                .pattern("PTP")
                .define('P', Items.PAPER)
                .define('T', Items.TORCH)
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OBAMIUM_PICKAXE.get())
                .pattern("OOO")
                .pattern(" S ")
                .pattern(" S ")
                .define('O', ModItems.OBAMIUM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBAMIUM.get()), has(ModItems.OBAMIUM.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OBAMIUM_SWORD.get())
                .pattern(" O ")
                .pattern(" O ")
                .pattern(" S ")
                .define('O', ModItems.OBAMIUM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBAMIUM.get()), has(ModItems.OBAMIUM.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OBAMIUM_AXE.get())
                .pattern("OO ")
                .pattern("OS ")
                .pattern(" S ")
                .define('O', ModItems.OBAMIUM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBAMIUM.get()), has(ModItems.OBAMIUM.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OBAMIUM_SHOVEL.get())
                .pattern(" O ")
                .pattern(" S ")
                .pattern(" S ")
                .define('O', ModItems.OBAMIUM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBAMIUM.get()), has(ModItems.OBAMIUM.get())).save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OBAMIUM_HOE.get())
                .pattern("OO ")
                .pattern(" S ")
                .pattern(" S ")
                .define('O', ModItems.OBAMIUM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBAMIUM.get()), has(ModItems.OBAMIUM.get())).save(pRecipeOutput);



        oreSmelting(pRecipeOutput, SMELTABLES, RecipeCategory.MISC, ModItems.OBAMIUM.get(), 0.25f, 200, "obamium");
        oreBlasting(pRecipeOutput, SMELTABLES, RecipeCategory.MISC, ModItems.OBAMIUM.get(), 0.25f, 100, "obamium");

    }
}
