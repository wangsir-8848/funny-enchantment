package com.funnyenchantment.enchantment;

import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionTypes;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/19
 * @description 岩浆上行走
 */
public class LavaWalkerEnchantment extends Enchantment {
    public LavaWalkerEnchantment(Rarity rarity, EquipmentSlot... slotTypes) {
        super(rarity, EnchantmentTarget.ARMOR_FEET, slotTypes);
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.FROST_WALKER;
    }

    public static void changeBlockLavaToNetherrack(LivingEntity entity, World world, BlockPos blockPos) {
//        Fluids.FLOWING_LAVA
//        Fluids.LAVA
//        Items.NETHERRACK
        if (!entity.isOnGround()) {
            return;
        }
        //只在下届生成
        if (world.getDimensionEntry() != DimensionTypes.THE_NETHER) {
            return;
        }
        //只替换当前脚下。如果需要替换周围方块 根据FrostWalkerEnchantment 这个去修改
//        BlockPos changePos = blockPos.down();
        BlockPos pos = new BlockPos(blockPos.getX(), blockPos.getY() - 1, blockPos.getZ());
        if (world.getFluidState(pos).getFluid() == Fluids.FLOWING_LAVA || world.getFluidState(pos).getFluid() == Fluids.LAVA) {
            world.setBlockState(pos, Blocks.NETHERRACK.getDefaultState());
        }
    }
}
