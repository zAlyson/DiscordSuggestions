package alysonsantos.sugerir.entites;

public class PlayerDiscord {

    private String player;
    private String discordId;

    public PlayerDiscord(String player, String discordId) {
        this.player = player;
        this.discordId = discordId;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getDiscordId() {
        return discordId;
    }

    public void setDiscordId(String discordId) {
        this.discordId = discordId;
    }
}
