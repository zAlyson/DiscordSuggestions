package alysonsantos.sugerir.events;

import alysonsantos.sugerir.entity.PlayerDiscord;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import static alysonsantos.sugerir.Main.*;

import java.awt.*;

public class EventPlayerChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String mensagem = e.getMessage();
        String playerName = p.getName();

        if (getPlayerManager().getPlayer(p.getName()) != null && getPlayerManager().getPlayer(p.getName()).isSugerindo()) {
            if (mensagem.equals("cancelar")) {
                e.setCancelled(true);

                getPlayerManager().getPlayer(playerName).setSugerindo(false);
                p.sendMessage(new String[]{"", "§c Pronto, ação cancelada!", ""});
                return;
            }
            e.setCancelled(true);
            PlayerDiscord user = getPlayerManager().getPlayer(playerName);

            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle(" <:bell:> | **NOVA SUGESTÃO**:");
            embed.setColor(Color.ORANGE);
            embed.setThumbnail(jda.getUserById(user.getDiscordId()).getAvatarUrl());
            embed.addField(" Author:", playerName, true);
            embed.addField(" Sugestão:", mensagem, true);
            embed.setFooter("Agradecemos pela sugestão!", jda.getGuilds().get(0).getIconUrl());

            TextChannel channel = jda.getTextChannelById("610812244753907713");
            channel.sendMessage(embed.build()).queue();
            p.sendMessage("\n §aSugestão enviada com sucesso! \n ");
        }
    }
}
