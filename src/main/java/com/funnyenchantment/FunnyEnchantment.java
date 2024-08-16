package com.funnyenchantment;

import com.funnyenchantment.config.ModBaseInfo;
import com.funnyenchantment.registry.EffectRegister;
import com.funnyenchantment.registry.EnchantmentRegister;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/8/15
 * @description TDDD
 */
public class FunnyEnchantment implements ModInitializer {
    /**
     * Runs the mod initializer.
     */

    public static final Logger LOGGER = LoggerFactory.getLogger(ModBaseInfo.MOD_ID);
    @Override
    public void onInitialize() {

        EnchantmentRegister.register();
        EffectRegister.register();
    }
}
