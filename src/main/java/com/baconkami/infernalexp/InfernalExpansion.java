package com.baconkami.infernalexp;

import com.baconkami.infernalexp.registries.ModBlocks;
import com.baconkami.infernalexp.registries.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class InfernalExpansion  implements ModInitializer {
    public static final String MOD_ID = "infernalexp";

    @Override
    public void onInitialize() {
        ModBlocks.registerAll();
        ModItems.registerAll();
    }

    public static final ItemGroup TAB = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "infernaltab"))
            .icon(() -> new ItemStack(Items.GLOWSTONE))
            .build();
}
