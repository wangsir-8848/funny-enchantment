package com.funnyenchantment.generator.lang;

import com.funnyenchantment.registry.EffectRegister;
import com.funnyenchantment.registry.EnchantmentRegister;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

/**
 * @author wanggq
 * @version 1.0.0
 * @date 2024/7/24
 * @description 国际化____英文
 */
public class EnglishLangProvider extends FabricLanguageProvider {


    public EnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_sh", registryLookup);

    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder tb) {
        tb.add(EnchantmentRegister.KINDNESS, "Kindness");
        tb.add(EnchantmentRegister.TETANUS, "Tetanus");
        tb.add(EnchantmentRegister.MORE_EXP, "More Exp");
        tb.add(EnchantmentRegister.SUPER_JUMP, "Super Jump");
        tb.add(EnchantmentRegister.VAMPIRISM, "Vampirism");
        tb.add(EnchantmentRegister.LAVA_WALKER, "Lava Walker");
        tb.add(EnchantmentRegister.DOUBLE_JUMP, "double jump");
        tb.add(EffectRegister.TETANUS.value(), "Bleed");
    }
}
