package com.funnyenchantment.registry;

import com.funnyenchantment.effect.TetanusStatusEffect;
import com.funnyenchantment.util.Utils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/15
 * @description TDDD
 */
public class EffectRegister {

    public static final TetanusStatusEffect TETANUS = new TetanusStatusEffect(StatusEffectCategory.HARMFUL, 15978425);

    public static void register(){
        register("tetanus", TETANUS);
    }
    private static void register(String name, StatusEffect statusEffect) {
        Registry.register(Registries.STATUS_EFFECT, Utils.getIdentifier(name), statusEffect);
    }
}
