package big.funny.bigfunny.commands;
import big.funny.bigfunny.BigFunni;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class BigFunniCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (label.equalsIgnoreCase("funni") && args.length == 0) {
            if (BigFunni.isRunning()) {
                player.sendMessage(ChatColor.GOLD + "Stopped the big funny");
            } else player.sendMessage(ChatColor.GOLD + "Started the big funny");
            BigFunni.toggle();
            return true;
        }

        if(label.equalsIgnoreCase("funni") && Bukkit.getServer().getPlayer(args[0]) != null) {
            if(Bukkit.getServer().getOnlinePlayers().contains(Bukkit.getServer().getPlayer(args[0]))) {
                UUID curPlayer = Bukkit.getServer().getPlayer(args[0]).getUniqueId();
                if (!BigFunni.getPlayers().contains(curPlayer)) {
                    BigFunni.addPlayer(curPlayer);
                    player.sendMessage(ChatColor.GOLD + "Added: " + ChatColor.RESET + args[0]);
                } else {
                    BigFunni.removePlayer(curPlayer);
                    player.sendMessage(ChatColor.RED + "Removed: " + ChatColor.RESET + args[0]);
                }
            } else player.sendMessage(ChatColor.DARK_RED + "Player not online or does not exist");
        }
        return true;
    }
}
