package com.funnyenchantment.enchantment;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionTypes;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/19
 * @description 岩浆上行走
 */
public class LavaWalkerEnchantment extends Enchantment {
    public LavaWalkerEnchantment(Enchantment.Properties properties) {
        super(properties);
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.FROST_WALKER;
    }
    //这个是只能通过战利品或者交易获取
//    @Override
//    public boolean isTreasure() {
//        return true;
//    }

    public static void changeBlockLavaToNetherrack(LivingEntity entity, World world, BlockPos blockPos,boolean isJumping) {
//        Fluids.FLOWING_LAVA
//        Fluids.LAVA
//        Items.NETHERRACK
        if (!entity.isOnGround()) {
            return;
        }
        //只在下届生成
        if (!world.getDimensionEntry().matchesKey(DimensionTypes.THE_NETHER)) {
            return;
        }
        //只替换当前脚下。如果需要替换周围方块 根据FrostWalkerEnchantment 这个去修改
        //但是这里解决下路了。是否会和解解跳跃冲突。有待测试
        if (entity.isInLava() || entity.fallDistance > 0.5F  ) {
            // 检测玩家下方的多个位置（处理下落过程）
            for (int y = 0; y < 1; y++) {
                BlockPos checkPos = entity.getBlockPos().down(y + 1);
                changeBlock(checkPos,world);
            }
        }
        //解决跳跃
        if (isJumping && entity.fallDistance > 0f){
            BlockPos checkPos = entity.getBlockPos().down();
            changeBlock(checkPos,world);
        }

        BlockPos changePos = blockPos.down();
        changeBlock(changePos,world);
    }

    private static void changeBlock(BlockPos changePos, World world){
        BlockPos topPos = changePos.up();
        BlockState blockState = world.getBlockState(topPos);
        if (blockState.isAir()){
            if (world.getFluidState(changePos).getFluid() == Fluids.FLOWING_LAVA || world.getFluidState(changePos).getFluid() == Fluids.LAVA) {
                world.setBlockState(changePos, Blocks.NETHERRACK.getDefaultState());
            }
        }
    }
}
