package pl.sparkmc.sparkmcwings;

import me.taison.CommandAPI;
import org.bukkit.plugin.java.JavaPlugin;
import pl.sparkmc.sparkmcwings.data.factory.UserFactory;
import pl.sparkmc.sparkmcwings.data.factory.impl.UserFactoryImpl;

public final class SparkMcWings extends JavaPlugin {

    private static SparkMcWings singleton;
    private UserFactory userFactory;


    public static SparkMcWings getInstance() {
        return singleton;
    }


    @Override
    public void onLoad() {
        singleton = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        CommandAPI.getInstance(this)
                .addPackageName(".commands")
                .registerCommands();

        this.userFactory = new UserFactoryImpl();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public UserFactory getUserFactory() {
        return this.userFactory;
    }
}
