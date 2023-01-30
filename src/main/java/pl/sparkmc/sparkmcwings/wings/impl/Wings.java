package pl.sparkmc.sparkmcwings.wings.impl;

import net.minecraft.server.v1_16_R3.EntityArmorStand;
import net.minecraft.server.v1_16_R3.EnumHand;
import net.minecraft.server.v1_16_R3.World;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import pl.sparkmc.sparkmcwings.utils.items.ItemBuilder;
import pl.sparkmc.sparkmcwings.wings.WingsType;

public class Wings extends EntityArmorStand {

    private final WingsType wingsType;

    public Wings(String name, World world, double d0, double d1, double d2) {
        super(world, d0, d1, d2);

        this.wingsType = WingsType.fromString(name).orElseThrow();

        ItemStack leftWing = new ItemBuilder(Material.AIR)
                .setCustomModelData(wingsType.getLeftCustomModelData())
                .toItemStack();

        ItemStack rightWing = new ItemBuilder(Material.AIR)
                .setCustomModelData(wingsType.getRightCustomModelData())
                .toItemStack();

        this.a(EnumHand.MAIN_HAND, CraftItemStack.asNMSCopy(leftWing));
        this.a(EnumHand.OFF_HAND, CraftItemStack.asNMSCopy(rightWing));
    }

    public WingsType getWingsType() {
        return wingsType;
    }
}
