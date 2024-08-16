package com.funnyenchantment.generator.lang;

import com.funnyenchantment.registry.EnchantmentRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/7/24
 * @description 国际化____英文
 */
public class EnglishLangProvider extends FabricLanguageProvider {


    public EnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_sh");

    }

    @Override
    public void generateTranslations(TranslationBuilder tb) {
        tb.add(EnchantmentRegister.KINDNESS, "Kindness");
        tb.add(EnchantmentRegister.TETANUS, "Tetanus");
        tb.add(EnchantmentRegister.MORE_EXP, "More Exp");
        tb.add(EnchantmentRegister.SUPER_JUMP, "Super Jump");

    }
}
