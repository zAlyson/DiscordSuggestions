package alysonsantos.sugerir;

import alysonsantos.sugerir.entites.PlayerManager;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public class Main extends JavaPlugin {
    public static Main plugin;
    public static PlayerManager playerManager;
    public JDA jda;

    public void onEnable() {
        plugin = this;
        startBot();
        playerManager = new PlayerManager();
    }

    /*
     * Iniciando o bot...
     * Defina o token do bot que está no discord de seu servidor, no ´setToken("")´"
     */
    private void startBot() {
        try {
            jda = new JDABuilder(AccountType.BOT).setToken("").build();
            cs.sendMessage(new String[]{"", "§bStoreAssociar: §fServidor vinculado com o discord §f'§eStoreNetwork - Equipe§f'§f!", ""});
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public ConsoleCommandSender cs = Bukkit.getConsoleSender();
    public PluginManager pm = Bukkit.getPluginManager();

}
