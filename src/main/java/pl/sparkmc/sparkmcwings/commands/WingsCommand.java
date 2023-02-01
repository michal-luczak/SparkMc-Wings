package pl.sparkmc.sparkmcwings.commands;

import me.taison.AbstractCommand;
import me.taison.adnotations.Aliases;
import me.taison.adnotations.Command;
import me.taison.adnotations.Permission;
import me.taison.adnotations.argumentsmap.Arguments;
import me.taison.adnotations.argumentsmap.ArgumentsMap;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.sparkmc.sparkmcwings.commands.handlers.CommandHandler;
import pl.sparkmc.sparkmcwings.commands.handlers.admin.GiveWings;
import pl.sparkmc.sparkmcwings.commands.handlers.admin.TakeAwayWings;
import pl.sparkmc.sparkmcwings.commands.handlers.users.MenuWings;
import pl.sparkmc.sparkmcwings.commands.handlers.users.OffWings;
import pl.sparkmc.sparkmcwings.commands.handlers.users.OnWings;
import pl.sparkmc.sparkmcwings.utils.chat.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Command(name = "skrzydła")
@Permission(permission = "sparkmc.wings")
@Aliases(aliases = {"wings"})
@ArgumentsMap(arguments = {
        @Arguments(arguments = {"off", "on"})
})
public class WingsCommand extends AbstractCommand {

    private final Map<HandlerType, CommandHandler> handlerMap;

    public WingsCommand() {
        this.handlerMap = new ConcurrentHashMap<>();

        this.handlerMap.put(HandlerType.ON, new OnWings());
        this.handlerMap.put(HandlerType.OFF, new OffWings());
        this.handlerMap.put(HandlerType.MENU, new MenuWings());
        this.handlerMap.put(HandlerType.GIVE, new GiveWings());
        this.handlerMap.put(HandlerType.TAKE_AWAY, new TakeAwayWings());
    }


    @Override
    public void execute(CommandSender sender, String commandLabel, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            this.handlerMap.get(HandlerType.MENU).handle(player);
            return;
        }

        //Admin case
        if (args[0].equals("nadaj")) {
            this.handlerMap.get(HandlerType.GIVE).handle(player);
            return;
        } else if (args[0].equals("zabierz")) {
            this.handlerMap.get(HandlerType.TAKE_AWAY).handle(player);
            return;
        }

        //User case
        switch (args[0]) {
            case "on" -> this.handlerMap.get(HandlerType.ON).handle(player);
            case "off" -> this.handlerMap.get(HandlerType.OFF).handle(player);
            default -> player.sendMessage(StringUtils.color("&cNiepoprawny argument!"));
        }
    }

    private enum HandlerType {
        ON, OFF, MENU, GIVE, TAKE_AWAY
    }
}
