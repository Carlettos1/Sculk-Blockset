package me.carlettos.sculk_blockset;

import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public final class SculkBlockset {
    public static final String MOD_ID = "sculk_blockset";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registries.ITEM);

    public static ResourceLocation named(String name) {
        return ResourceLocation.tryBuild(MOD_ID, name.toLowerCase());
    }

    public static RegistrySupplier<Block> registerBlock(String name, Supplier<Block> block) {
        return BLOCKS.register(named(name), block);
    }

    public static RegistrySupplier<Item> registerItem(String name, Supplier<Item> item) {
        return ITEMS.register(named(name), item);
    }

    public static BlockBehaviour.Properties getDefaultProperties() {
        return BlockBehaviour.Properties.copy(Blocks.SCULK);
    }

    public static final RegistrySupplier<Block> SCULK_STAIRS = registerBlock("SCULK_STAIRS", () -> new StairBlock(Blocks.SCULK.defaultBlockState(), getDefaultProperties()) {
        @Override
        public void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack, boolean dropExperience) {
            super.spawnAfterBreak(state, level, pos, stack, dropExperience);
            if (dropExperience && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
                this.popExperience(level, pos, 1);
            }
        }

        public int getExpDrop(BlockState state, LevelReader world, RandomSource randomSource, BlockPos pos, int fortune, int silktouch) {
            return silktouch == 0 ? 1 : 0;
        }
    });
    public static final RegistrySupplier<Block> SCULK_SLAB = registerBlock("SCULK_SLAB", () -> new SlabBlock(getDefaultProperties()) {
        @Override
        public void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack, boolean dropExperience) {
            super.spawnAfterBreak(state, level, pos, stack, dropExperience);
            if (dropExperience && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
                this.popExperience(level, pos, 1);
            }
        }

        public int getExpDrop(BlockState state, LevelReader world, RandomSource randomSource, BlockPos pos, int fortune, int silktouch) {
            return silktouch == 0 ? 1 : 0;
        }
    });
    public static final RegistrySupplier<Block> SCULK_WALL = registerBlock("SCULK_WALL", () -> new WallBlock(getDefaultProperties()) {
        @Override
        public void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack, boolean dropExperience) {
            super.spawnAfterBreak(state, level, pos, stack, dropExperience);
            if (dropExperience && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
                this.popExperience(level, pos, 1);
            }
        }

        public int getExpDrop(BlockState state, LevelReader world, RandomSource randomSource, BlockPos pos, int fortune, int silktouch) {
            return silktouch == 0 ? 1 : 0;
        }
    });
    public static final RegistrySupplier<Block> SCULK_FENCE = registerBlock("SCULK_FENCE", () -> new FenceBlock(getDefaultProperties()) {
        @Override
        public void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack, boolean dropExperience) {
            super.spawnAfterBreak(state, level, pos, stack, dropExperience);
            if (dropExperience && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
                this.popExperience(level, pos, 1);
            }
        }

        public int getExpDrop(BlockState state, LevelReader world, RandomSource randomSource, BlockPos pos, int fortune, int silktouch) {
            return silktouch == 0 ? 1 : 0;
        }
    });
    public static final RegistrySupplier<Block> SCULK_FENCE_GATE = registerBlock("SCULK_FENCE_GATE", () -> new SculkFenceGate(getDefaultProperties()) {
        @Override
        public void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack, boolean dropExperience) {
            super.spawnAfterBreak(state, level, pos, stack, dropExperience);
            if (dropExperience && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
                this.popExperience(level, pos, 1);
            }
        }

        public int getExpDrop(BlockState state, LevelReader world, RandomSource randomSource, BlockPos pos, int fortune, int silktouch) {
            return silktouch == 0 ? 1 : 0;
        }
    });


    public static final RegistrySupplier<Item> SCULK_STAIRS_ITEM = registerItem("SCULK_STAIRS", () -> new BlockItem(SCULK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.NATURAL_BLOCKS)));
    public static final RegistrySupplier<Item> SCULK_SLAB_ITEM = registerItem("SCULK_SLAB", () -> new BlockItem(SCULK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.NATURAL_BLOCKS)));
    public static final RegistrySupplier<Item> SCULK_WALL_ITEM = registerItem("SCULK_WALL", () -> new BlockItem(SCULK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.NATURAL_BLOCKS)));
    public static final RegistrySupplier<Item> SCULK_FENCE_ITEM = registerItem("SCULK_FENCE", () -> new BlockItem(SCULK_FENCE.get(), new Item.Properties().arch$tab(CreativeModeTabs.NATURAL_BLOCKS)));
    public static final RegistrySupplier<Item> SCULK_FENCE_GATE_ITEM = registerItem("SCULK_FENCE_GATE", () -> new BlockItem(SCULK_FENCE_GATE.get(), new Item.Properties().arch$tab(CreativeModeTabs.NATURAL_BLOCKS)));

    public static void init() {
        BLOCKS.register();
        ITEMS.register();
    }
}
