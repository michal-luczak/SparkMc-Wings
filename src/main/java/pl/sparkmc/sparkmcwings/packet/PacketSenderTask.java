package pl.sparkmc.sparkmcwings.packet;

import net.minecraft.server.v1_16_R3.DataWatcher;
import net.minecraft.server.v1_16_R3.PacketPlayOutEntityMetadata;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import pl.sparkmc.sparkmcwings.wings.Wings;

import java.util.TimerTask;

public class PacketSenderTask extends TimerTask {

    private final Wings wings;

    public PacketSenderTask(Wings wings) {
        this.wings = wings;
    }

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            DataWatcher dataWatcher = this.wings.getArmorStand().getDataWatcher();
            PacketPlayOutEntityMetadata packet = new PacketPlayOutEntityMetadata(this.wings.getArmorStand().getId(), dataWatcher, false);
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
        });
    }
}
