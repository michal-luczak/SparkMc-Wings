package pl.sparkmc.sparkmcwings.wings.impl;

import net.minecraft.server.v1_16_R3.EntityArmorStand;
import net.minecraft.server.v1_16_R3.EnumHand;
import net.minecraft.server.v1_16_R3.Vector3f;
import net.minecraft.server.v1_16_R3.World;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import pl.sparkmc.sparkmcwings.packet.PacketSenderTask;
import pl.sparkmc.sparkmcwings.user.User;
import pl.sparkmc.sparkmcwings.utils.items.ItemBuilder;
import pl.sparkmc.sparkmcwings.wings.Wings;
import pl.sparkmc.sparkmcwings.wings.WingsType;

public class WingsImpl extends EntityArmorStand implements Wings {

    private final WingsType wingsType;
    private final User owner;

    public WingsImpl(User owner, String name, World world, double d0, double d1, double d2) {
        super(world, d0, d1, d2);

        this.owner = owner;
        this.wingsType = WingsType.fromString(name).orElseThrow();

        ItemStack leftWing = new ItemBuilder(Material.AIR)
                .setCustomModelData(wingsType.getLeftCustomModelData())
                .toItemStack();

        ItemStack rightWing = new ItemBuilder(Material.AIR)
                .setCustomModelData(wingsType.getRightCustomModelData())
                .toItemStack();

        this.a(EnumHand.MAIN_HAND, CraftItemStack.asNMSCopy(leftWing));
        this.a(EnumHand.OFF_HAND, CraftItemStack.asNMSCopy(rightWing));
        this.setSmall(true);
        this.setLeftArmPose(new Vector3f(0, 0, 0));
        this.setRightArmPose(new Vector3f(0, 0, 0));
        this.setInvisible(true);
        this.setMarker(true);
        this.setInvulnerable(true);
        this.setNoGravity(true);
        this.disabledSlots = 2096896;
    }

    public WingsType getWingsType() {
        return wingsType;
    }

    @Override
    public String getName() {
        return this.wingsType.name();
    }

    @Override
    public User getOwner() {
        return this.owner;
    }

    @Override
    public EntityArmorStand getArmorStand() {
        return this;
    }

    @Override
    public void show() {
        this.owner.getTimer().scheduleAtFixedRate(new PacketSenderTask(this), 0L, 16L);
    }

    @Override
    public void disappear() {
        this.owner.getTimer().cancel();
    }
}
