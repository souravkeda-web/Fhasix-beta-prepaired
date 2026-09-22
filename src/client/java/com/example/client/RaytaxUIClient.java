package com.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;

public class RaytaxUIClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HudElementRegistry.attachElementBefore(
                VanillaHudElements.CHAT,
                ExampleMod.id("raytax_text"),
                RaytaxUIClient::render
        );
    }

    private static void render(
            GuiGraphicsExtractor graphics,
            DeltaTracker deltaTracker
    ) {
        String text = "HI IT RAYTAX HERE";

        int x = graphics.guiWidth() - graphics.textWidth(text) - 10;
        int y = 10;

        graphics.text(
                Minecraft.getInstance().font,
                text,
                x,
                y,
                0xFFFFFFFF,
                true
        );
    }
}
