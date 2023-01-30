package pl.sparkmc.sparkmcwings.user.impl;

import org.bukkit.entity.Player;
import pl.sparkmc.sparkmcwings.user.User;
import pl.sparkmc.sparkmcwings.wings.impl.Wings;

import java.util.Timer;

public class UserImpl implements User {

    private final Player player;

    private Wings wings;

    private final Timer timer;


    public UserImpl(Player player) {
        this.player = player;
        this.timer = new Timer();
    }


    public void giveWings(Wings wings) {
        this.wings = wings;
        //TODO task to flutter wings and set player passenger
    }


    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public Timer getTimer() {
        return this.timer;
    }

    @Override
    public Wings getWings() {
        return this.wings;
    }
}
