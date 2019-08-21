package alysonsantos.sugerir.commands;

import alysonsantos.sugerir.entity.PlayerDiscord;
import net.dv8tion.jda.core.entities.User;
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
            p.sendMessage(new String[]{"", "§eComando incorreto! Digite /sugerir (id do discord).", "§7 (O ID é opcional, caso queira que seu avatar apareça.)"});
            return true;
        }

        // Aqui iremos verificar se o ID do discord que o jogador citou, é válido!

        if (args.length == 1) {
            User user = plugin.jda.getUserById(args[1]);

            if (user.isFake()) {
                p.sendMessage("§cO ID é invalido.");
                return true;
            }

            PlayerDiscord player = getPlayerManager().getPlayer(p.getName());
            player.setDiscordId(args[1]);
                return true;
            }

            if (getPlayerManager().getPlayer(p.getName()) != null && getPlayerManager().getPlayer(p.getName()).isSugerindo()) {
                p.sendMessage(new String[]{"", "§c Você não pode executar este comando agora.", ""});
                return true;
            }

            getPlayerManager().getPlayer(p.getName()).setPlayer(p.getName());
            getPlayerManager().getPlayer(p.getName()).setSugerindo(true);
            p.sendMessage(new String[]{"", "§b Digite no chat a sua sugestão!", "§7 Para cancelar a ação, digite ´§fcancelar§7´.", ""});
            return false;
        }
    }
