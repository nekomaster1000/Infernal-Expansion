package com.nekomaster1000.Infernal.client.entity.render;

import com.nekomaster1000.Infernal.InfernalExpansion;
import com.nekomaster1000.Infernal.client.entity.model.EmbodyModel;
import com.nekomaster1000.Infernal.entities.EmbodyEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EmbodyGlowLayer<T extends EmbodyEntity, M extends EntityModel<T>> extends AbstractEyesLayer<T, M> {
    private static final RenderType RENDER_TYPE = RenderType.getEyes(new ResourceLocation(InfernalExpansion.MOD_ID, "textures/entity/embody_glow.png"));

    public EmbodyGlowLayer(IEntityRenderer<T, M> rendererIn) {
        super(rendererIn);
    }

    @Override
    public RenderType getRenderType() {
        return RENDER_TYPE;
    }
}