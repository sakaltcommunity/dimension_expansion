package com.sakalti.dimensionexpansion.client.render;

import com.sakalti.dimensionexpansion.entities.AncientSpider;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.util.ResourceLocation;

public class AncientSpiderRenderer extends MobRenderer<AncientSpider, SpiderModel<AncientSpider>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("dimensionexpansion:textures/entity/ancient_spider.png");

    public AncientSpiderRenderer(EntityRendererManager renderManager) {
        super(renderManager, new SpiderModel<>(), 0.8F);
    }

    @Override
    public ResourceLocation getEntityTexture(AncientSpider entity) {
        return TEXTURE;
    }
}
