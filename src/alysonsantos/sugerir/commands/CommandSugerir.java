package alysonsantos.sugerir.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static alysonsantos.sugerir.Main.*;

public class CommandSugerir implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String lb, String[] args) {

        if (!(s instanceof Player)) {
            return true;
        }

        Player p = (Player) s;
        if (args.length == 0) {
            p.sendMessage(new String[] {"", "§eComando incorreto! Digite /sugerir (id do discord).", ""});
            return true;
        }






        return false;
    }
}
