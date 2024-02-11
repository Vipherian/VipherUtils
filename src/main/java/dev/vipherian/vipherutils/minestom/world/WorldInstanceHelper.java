package dev.vipherian.vipherutils.minestom.world;

import net.minestom.server.MinecraftServer;
import net.minestom.server.instance.AnvilLoader;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.generator.Generator;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WorldInstanceHelper {
    private static final Map<String, InstanceContainer> instances = new HashMap<>();

    public WorldInstanceHelper(){
        var instanceFolder = new File("worlds");

        if(!instanceFolder.exists())instanceFolder.mkdirs();
    }

    public static InstanceContainer getInstance(@NotNull String startInstanceName){
        if(!instances.containsKey(startInstanceName)){
            var container = MinecraftServer.getInstanceManager().createInstanceContainer(new AnvilLoader("worlds/" + startInstanceName));
            container.setChunkGenerator(new StoneGenerator());
            instances.put(startInstanceName,container);
        }
        return instances.get(startInstanceName);
    }
}
