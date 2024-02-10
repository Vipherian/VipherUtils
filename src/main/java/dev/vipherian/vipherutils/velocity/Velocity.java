package dev.vipherian.vipherutils.velocity;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.minestom.server.entity.Player;
import net.minestom.server.network.packet.server.common.PluginMessagePacket;

public final class Velocity {
    public static void connect(Player player,String server){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);
        player.sendPacket(new PluginMessagePacket("BungeeCord", out.toByteArray()));
    }
}
