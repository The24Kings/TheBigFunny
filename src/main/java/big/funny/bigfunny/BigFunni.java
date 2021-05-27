package big.funny.bigfunny;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class BigFunni {
    public static boolean running;
    public static ArrayList<UUID> players = new ArrayList<UUID>();

    public static void toggle() {
        running = !running;
    }

    public static boolean isRunning() {
        return running;
    }

    public static void addPlayer(UUID player) {
        players.add(player);
    }

    public static void removePlayer(UUID player) {
        players.remove(player);
    }

    public static ArrayList<UUID> getPlayers() {
        return players;
    }

}
