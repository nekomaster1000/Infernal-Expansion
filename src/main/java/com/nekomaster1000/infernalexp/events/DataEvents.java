package com.nekomaster1000.infernalexp.events;

import com.nekomaster1000.infernalexp.InfernalExpansion;
import com.nekomaster1000.infernalexp.data.SpawnrateManager;
import com.nekomaster1000.infernalexp.data.VolineEatTable;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import java.util.Map;

@Mod.EventBusSubscriber(modid = InfernalExpansion.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataEvents {

    private static VolineEatTable volineEatTable;
    private static SpawnrateManager spawnrateManager;

    @SubscribeEvent
    public void onResourceReload(AddReloadListenerEvent event) {
        volineEatTable = new VolineEatTable();
        spawnrateManager = new SpawnrateManager();

        event.addListener(volineEatTable);
    }

    public static Map<Item, Map<Item, Integer>> getVolineEatTable() {
        if (volineEatTable == null) {
            throw new IllegalStateException("Can not retrieve VolineEatTable until resources have loaded once.");
        }

        return volineEatTable.getVolineEatTable();
    }

    public static Map<String, Map<String, SpawnrateManager.SpawnInfo>> getSpawnrateManager() {
        if (spawnrateManager == null) {
            spawnrateManager = new SpawnrateManager();
        }

        return spawnrateManager.getSpawnrates();
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
    }

}
