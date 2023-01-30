package pl.sparkmc.sparkmcwings.listeners;

import io.netty.channel.*;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitHandler implements Listener {

    @EventHandler
    public void handle(PlayerJoinEvent event) {
        event.getPlayer().
    }

    @EventHandler
    public void handle(PlayerQuitEvent event) {

    }

//    private void injectPlayer(Player player) {
//        ChannelDuplexHandler channelDuplexHandler = new ChannelDuplexHandler() {
//
//            @Override
//            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//                player.sendMessage(msg.toString());
//                super.channelRead(ctx, msg);
//            }
//
//            @Override
//            public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
//                player.sendMessage(msg.toString());
//                super.write(ctx, msg, promise);
//            }
//        };
//
//        ChannelPipeline pipeline = ((CraftPlayer) player).getHandle().playerConnection.networkManager.channel.pipeline();
//        pipeline.addBefore("PacketListener", player.getName(), channelDuplexHandler);
//    }
//
//    private void removePlayer(Player player) {
//        Channel channel = ((CraftPlayer) player).getHandle().playerConnection.networkManager.channel;
//        channel.eventLoop().submit(() -> {
//            channel.pipeline().remove(player.getName());
//            return null;
//        });
//    }
}
