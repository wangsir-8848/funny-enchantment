package com.funnyenchantment.generator.lang;

import com.funnyenchantment.registry.EffectRegister;
import com.funnyenchantment.registry.EnchantmentRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/7/24
 * @description 国际化____中文
 */
public class ChineseLangProvider extends FabricLanguageProvider {


    public ChineseLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "zh_cn");

    }

    @Override
    public void generateTranslations(TranslationBuilder tb) {
        tb.add(EnchantmentRegister.KINDNESS, "仁慈的");
        tb.add(EnchantmentRegister.TETANUS, "破伤风");
        tb.add(EnchantmentRegister.MORE_EXP, "更多经验值");
        tb.add(EnchantmentRegister.SUPER_JUMP, "超级跳跃");
        tb.add(EnchantmentRegister.VAMPIRISM, "吸血");
        tb.add(EnchantmentRegister.LAVA_WALKER, "岩浆行走");
        tb.add(EffectRegister.TETANUS, "流血");
    }
}

