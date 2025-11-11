package com.makingrandoms.datagen;

import com.makingrandoms.Makingrandoms;
import com.makingrandoms.block.ModBlocks;
import com.makingrandoms.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Makingrandoms.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.OBAMIUM.get());
        basicItem(ModItems.RAW_OBAMIUM.get());

        basicItem(ModItems.MAGIC_WAND.get());
        basicItem(ModItems.HOTDOG.get());
        basicItem(ModItems.JET_FUEL.get());

        basicItem(ModItems.OBAMIUM_SHOVEL.get());
        basicItem(ModItems.OBAMIUM_AXE.get());
        basicItem(ModItems.OBAMIUM_HOE.get());
        basicItem(ModItems.OBAMIUM_SWORD.get());
        basicItem(ModItems.OBAMIUM_PICKAXE.get());

        buttonItem(ModBlocks.OBAMIUM_BUTTON, ModBlocks.OBAMIUM_PRISM);
        fenceItem(ModBlocks.OBAMIUM_FENCE, ModBlocks.OBAMIUM_PRISM);
        wallItem(ModBlocks.OBAMIUM_WALL, ModBlocks.OBAMIUM_PRISM);
        pressurePlateItem(ModBlocks.OBAMIUM_PRESSURE_PLATE, ModBlocks.OBAMIUM_PRISM);
        stairItem(ModBlocks.OBAMIUM_STAIRS, ModBlocks.OBAMIUM_PRISM);
        blockItem(ModBlocks.OBAMIUM_TRAPDOOR, "obamium_prism");
        blockItem(ModBlocks.OBAMIUM_DOOR, "obamium_prism");
        fenceGateItem(ModBlocks.OBAMIUM_GATE, ModBlocks.OBAMIUM_PRISM);
        slabItem(ModBlocks.OBAMIUM_SLAB, ModBlocks.OBAMIUM_PRISM);


    }

    public void blockItem(RegistryObject<? extends Block> block, String baseBlockTextureName) {
        this.withExistingParent(
                block.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(Makingrandoms.MOD_ID,
                "block/" + baseBlockTextureName));
    }


    public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Makingrandoms.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Makingrandoms.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Makingrandoms.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void pressurePlateItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/pressure_plate_up"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(Makingrandoms.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void stairItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        String baseTexture = ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath();
        this.withExistingParent(
                        ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                        mcLoc("block/stairs")
                )
                .texture("bottom", ResourceLocation.fromNamespaceAndPath(Makingrandoms.MOD_ID, "block/" + baseTexture))
                .texture("top", ResourceLocation.fromNamespaceAndPath(Makingrandoms.MOD_ID, "block/" + baseTexture))
                .texture("side", ResourceLocation.fromNamespaceAndPath(Makingrandoms.MOD_ID, "block/" + baseTexture));
    }

    public void slabItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        String baseTexture = ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath();
        this.withExistingParent(
                        ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                        mcLoc("block/slab")
                )
                .texture("bottom", ResourceLocation.fromNamespaceAndPath(Makingrandoms.MOD_ID, "block/" + baseTexture))
                .texture("top", ResourceLocation.fromNamespaceAndPath(Makingrandoms.MOD_ID, "block/" + baseTexture))
                .texture("side", ResourceLocation.fromNamespaceAndPath(Makingrandoms.MOD_ID, "block/" + baseTexture));
    }



    public void fenceGateItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/template_fence_gate"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(Makingrandoms.MOD_ID,
                "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}