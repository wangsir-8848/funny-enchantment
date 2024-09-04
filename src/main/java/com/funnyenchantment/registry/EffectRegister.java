package com.funnyenchantment.registry;

import com.funnyenchantment.effect.TetanusStatusEffect;
import com.funnyenchantment.util.Utils;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/15
 * @description TDDD
 */
public class EffectRegister {

    public static RegistryEntry<StatusEffect> TETANUS;

//    = new TetanusStatusEffect(StatusEffectCategory.HARMFUL, 15978425);

    public static void register() {
        TETANUS = register("tetanus", new TetanusStatusEffect(StatusEffectCategory.HARMFUL, 15978425));
    }

    private static RegistryEntry.Reference<StatusEffect> register(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Utils.getIdentifier(name), statusEffect);
    }
}
