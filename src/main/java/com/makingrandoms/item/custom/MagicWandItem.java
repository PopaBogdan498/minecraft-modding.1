package com.makingrandoms.item.custom;

import com.google.common.collect.Maps;
import com.makingrandoms.Makingrandoms;
import com.makingrandoms.block.ModBlocks;
import com.makingrandoms.sound.ModSounds;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;

public class MagicWandItem extends Item {
    private static final Map<Block, Block> MAGIC_MAP = Map.of(
            Blocks.CRYING_OBSIDIAN, ModBlocks.OBAMIUM_ORE.get(),
            Blocks.NETHERITE_BLOCK, ModBlocks.OBAMIUM_PRISM.get()
    );

    public MagicWandItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();
        if(MAGIC_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), MAGIC_MAP.get(clickedBlock).defaultBlockState());
                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                level.playSound(null, pContext.getClickedPos(), ModSounds.MAGIC_WAND_USE.get(), SoundSource.BLOCKS);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.makingrandoms.magic_wand.shift_down"));
        }
        else{
            pTooltipComponents.add(Component.translatable("tooltip.makingrandoms.magic_wand"));
        }
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
