package com.baconkami.infernalexp.mixin;

import com.baconkami.infernalexp.InfernalExpansion;
import net.minecraft.Bootstrap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Bootstrap.class)
public class MixinBootstrap {

    @Inject(at = @At("TAIL"), method = "initialize()V")
    private static void addBiomeIDsServerSide(CallbackInfo ci) {
        InfernalExpansion.bootStrap();
    }
}