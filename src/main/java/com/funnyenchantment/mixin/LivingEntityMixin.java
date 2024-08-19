package com.funnyenchantment.mixin;

import com.funnyenchantment.enchantment.LavaWalkerEnchantment;
import com.funnyenchantment.registry.EnchantmentRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.FrostWalkerEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/19
 * @description TDDD
 */
@Mixin(LivingEntity.class)
public  abstract class LivingEntityMixin extends Entity{


    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Inject(method = "applyMovementEffects", at = @At("HEAD") )
        public void applyMovementEffects(BlockPos pos, CallbackInfo ci) {
        ItemStack feetStack = getEquippedStack(EquipmentSlot.FEET);
        if (EnchantmentHelper.getLevel(EnchantmentRegister.LAVA_WALKER, feetStack) > 0){
            LavaWalkerEnchantment.changeBlockLavaToNetherrack((LivingEntity) (Object)this, this.getWorld(), pos);
        }
    }
}
