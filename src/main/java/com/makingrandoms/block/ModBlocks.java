package com.makingrandoms.block;

import com.makingrandoms.Makingrandoms;
import com.makingrandoms.block.custom.MagicBlock;
import com.makingrandoms.block.custom.PaperLantern;
import com.makingrandoms.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;



public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Makingrandoms.MOD_ID);

    public static final RegistryObject<Block> OBAMIUM_PRISM = registerBlock("obamium_prism", () -> new Block(
            BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.FROGLIGHT)));

    public static final RegistryObject<Block> OBAMIUM_ORE = registerBlock("obamium_ore", () -> new DropExperienceBlock(
            UniformInt.of(2,4),
            BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block", () -> new MagicBlock(
            BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.BAMBOO)));

    public static final RegistryObject<StairBlock> OBAMIUM_STAIRS = registerBlock("obamium_stairs",
            () -> new StairBlock(ModBlocks.OBAMIUM_PRISM.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> OBAMIUM_SLAB = registerBlock("obamium_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<PressurePlateBlock> OBAMIUM_PRESSURE_PLATE = registerBlock("obamium_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> OBAMIUM_BUTTON = registerBlock("obamium_button",
            () -> new ButtonBlock(BlockSetType.IRON,1, BlockBehaviour.Properties.of().strength(4f)
                    .requiresCorrectToolForDrops().noCollission()));

    public static final RegistryObject<FenceBlock> OBAMIUM_FENCE = registerBlock("obamium_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> OBAMIUM_GATE = registerBlock("obamium_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<WallBlock> OBAMIUM_WALL = registerBlock("obamium_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<DoorBlock> OBAMIUM_DOOR = registerBlock("obamium_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> OBAMIUM_TRAPDOOR = registerBlock("obamium_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> PAPER_LANTERN = registerBlock("paper_lantern",
            () -> new PaperLantern(BlockBehaviour.Properties.of().strength(1f)
                    .lightLevel(state -> state.getValue(PaperLantern.CLICKED) ? 15 : 0)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
