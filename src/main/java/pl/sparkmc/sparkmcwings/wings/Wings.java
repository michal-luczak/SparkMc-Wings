package pl.sparkmc.sparkmcwings.wings;

import net.minecraft.server.v1_16_R3.EntityArmorStand;
import pl.sparkmc.sparkmcwings.user.User;

public interface Wings {

    String getName();

    User getOwner();

    EntityArmorStand getArmorStand();

    void show();

    void disappear();
}
