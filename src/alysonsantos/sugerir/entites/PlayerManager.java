package alysonsantos.sugerir.entites;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private List<PlayerDiscord> playerManagerList;

    public PlayerManager() {
        playerManagerList = new ArrayList<>();
    }

    public List<PlayerDiscord> getPlayerDiscordList() {
        return playerManagerList;
    }

    public PlayerDiscord getPlayer(String nome) {
        for (PlayerDiscord playerManager : playerManagerList) {
            if (playerManager.getPlayer().equalsIgnoreCase(nome)) return playerManager;
        }
        return null;
    }

}
