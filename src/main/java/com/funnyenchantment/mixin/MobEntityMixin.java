package com.funnyenchantment.mixin;

import com.funnyenchantment.registry.EnchantmentRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/16
 * @description TDDD
 */
@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {

    protected MobEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "getXpToDrop", at = @At("RETURN"), cancellable = true)
    public void getXpToDrop(CallbackInfoReturnable<Integer> cir) {
        DamageSource lastDamageSource = getRecentDamageSource();
        assert lastDamageSource != null;
        LivingEntity attacker = (LivingEntity) lastDamageSource.getAttacker();
        assert attacker != null;
        ItemStack mainHandStack = attacker.getMainHandStack();
        int level;
        if ((level = EnchantmentHelper.getLevel(EnchantmentRegister.MORE_EXP, mainHandStack)) > 0) {
            cir.setReturnValue(cir.getReturnValue() * level);
        }
    }
}
