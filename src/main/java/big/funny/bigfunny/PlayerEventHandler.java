package big.funny.bigfunny;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class PlayerEventHandler implements Listener {
    @EventHandler
    public void onBlockBreak(BlockDamageEvent event) {
        if (BigFunni.isRunning()) {
            UUID player = event.getPlayer().getUniqueId();
            if(BigFunni.getPlayers().contains(player)) {
                int delay = 1; //# of ticks
                Location blockLocal = event.getBlock().getLocation();
                World world = blockLocal.getWorld();

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (event.getBlock().getType().equals(Material.DIAMOND_ORE)) {
                            world.getBlockAt(blockLocal).setType(Material.STONE);
                        }
                    }
                }.runTaskLater(Bigfunny.getPlugin(), delay);
            }
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if (BigFunni.isRunning()) {
            UUID player = event.getWhoClicked().getUniqueId();
            if(BigFunni.getPlayers().contains(player)) {
            ItemStack item = event.getCurrentItem();
                if(item != null) {
                    ItemStack replace = new ItemStack(Material.AIR, item.getAmount());
                    ItemStack check = new ItemStack(Material.DIAMOND, item.getAmount());

                    if (item.equals(check)) {
                        event.setCurrentItem(replace);
                    }
                }
            }
        }
    }
}
