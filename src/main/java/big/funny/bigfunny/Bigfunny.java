package big.funny.bigfunny;

import big.funny.bigfunny.commands.BigFunniCommand;
import big.funny.bigfunny.commands.BigFunniTabCompleter;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bigfunny extends JavaPlugin {
    /* TODO
    *
    * Add config that contains list of players and if the plugin is enabled
    *
    * */
    public static Bigfunny plugin;

    public static Bigfunny getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        System.out.println(ChatColor.DARK_RED + "24Kings Plugin: " + ChatColor.RESET + "Here for the big funny");
        RegisterCommandsAndEvents();
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.DARK_RED + "24Kings Plugin: " + ChatColor.RESET + "Not very funny dude!");
    }

    private void RegisterCommandsAndEvents () {
        getServer().getPluginManager().registerEvents(new PlayerEventHandler(), this);

        getCommand("funni").setExecutor(new BigFunniCommand());
        getCommand("funni").setTabCompleter(new BigFunniTabCompleter());
    }
}
