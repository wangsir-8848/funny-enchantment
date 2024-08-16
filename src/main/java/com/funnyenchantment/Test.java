package com.funnyenchantment;

import net.minecraft.util.math.random.Random;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/15
 * @description TDDD
 */
public class Test {
//    public static final StatusEffect JUMP_BOOST = StatusEffects.register("jump_boost", new StatusEffect(StatusEffectCategory.BENEFICIAL, 16646020));
    public static void main(String[] args) {
          Random random = Random.create();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(10));
        }

    }

}
