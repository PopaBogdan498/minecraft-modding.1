package com.makingrandoms.datagen;

import com.makingrandoms.Makingrandoms;
import com.makingrandoms.block.ModBlocks;
import com.makingrandoms.util.Modtags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Makingrandoms.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.OBAMIUM_PRISM.get())
                .add(ModBlocks.OBAMIUM_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.OBAMIUM_ORE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.OBAMIUM_PRISM.get());
        tag(BlockTags.FENCES).add(ModBlocks.OBAMIUM_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.OBAMIUM_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.OBAMIUM_WALL.get());
        tag(Modtags.Blocks.NEEDS_OBAMIUM_TOOL)
                .add(ModBlocks.MAGIC_BLOCK.get())
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(Modtags.Blocks.INCORRECT_FOR_OBAMIUM_TOOL)
            .addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
    }
}
