package com.makingrandoms.datagen;

import com.makingrandoms.Makingrandoms;
import com.makingrandoms.block.ModBlocks;
import com.makingrandoms.block.custom.PaperLantern;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Makingrandoms.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.OBAMIUM_PRISM);
        blockWithItem(ModBlocks.OBAMIUM_ORE);
        blockWithItem(ModBlocks.MAGIC_BLOCK);
        stairsBlock(ModBlocks.OBAMIUM_STAIRS.get(), blockTexture(ModBlocks.OBAMIUM_PRISM.get()));
        slabBlock(ModBlocks.OBAMIUM_SLAB.get(), blockTexture(ModBlocks.OBAMIUM_PRISM.get()), blockTexture(ModBlocks.OBAMIUM_PRISM.get()));
        buttonBlock(ModBlocks.OBAMIUM_BUTTON.get(), blockTexture(ModBlocks.OBAMIUM_PRISM.get()));
        pressurePlateBlock(ModBlocks.OBAMIUM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.OBAMIUM_PRISM.get()));
        fenceBlock(ModBlocks.OBAMIUM_FENCE.get(), blockTexture(ModBlocks.OBAMIUM_PRISM.get()));
        fenceGateBlock(ModBlocks.OBAMIUM_GATE.get(), blockTexture(ModBlocks.OBAMIUM_PRISM.get()));
        wallBlock(ModBlocks.OBAMIUM_WALL.get(), blockTexture(ModBlocks.OBAMIUM_PRISM.get()));
        doorBlockWithRenderType(ModBlocks.OBAMIUM_DOOR.get(), modLoc("block/obamium_prism"), modLoc("block/obamium_prism"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.OBAMIUM_TRAPDOOR.get(), modLoc("block/obamium_prism"), true, "cutout");

        blockItem(ModBlocks.OBAMIUM_STAIRS);
        blockItem(ModBlocks.OBAMIUM_SLAB);
        blockItem(ModBlocks.OBAMIUM_PRESSURE_PLATE);
        blockItem(ModBlocks.OBAMIUM_GATE);
        blockItem(ModBlocks.OBAMIUM_TRAPDOOR, "_bottom");

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.PAPER_LANTERN.get()).forAllStates(state -> {
            if(state.getValue(PaperLantern.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("paper_lantern_on",
                        ResourceLocation.fromNamespaceAndPath(Makingrandoms.MOD_ID, "block/" + "paper_lantern_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("paper_lantern_off",
                        ResourceLocation.fromNamespaceAndPath(Makingrandoms.MOD_ID, "block/" + "paper_lantern_off")))};
            }
        });
        simpleBlockItem(ModBlocks.PAPER_LANTERN.get(), models().cubeAll("paper_lantern_on",
                ResourceLocation.fromNamespaceAndPath(Makingrandoms.MOD_ID, "block/" + "paper_lantern_on")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}