package pl.sparkmc.sparkmcwings.user;

import org.bukkit.entity.Player;
import pl.sparkmc.sparkmcwings.wings.impl.Wings;

import java.util.Timer;

public interface User {

    Player getPlayer();

    Timer getTimer();

    Wings getWings();
}
