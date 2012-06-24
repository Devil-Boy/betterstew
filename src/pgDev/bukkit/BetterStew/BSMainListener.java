package pgDev.bukkit.BetterStew;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BSMainListener implements Listener {
	final BetterStew plugin;
	
	public BSMainListener(final BetterStew plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		if (!event.isCancelled() && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			ItemStack item = event.getItem();
			if (item != null && item.getType() == Material.MUSHROOM_SOUP) {
				Player player = event.getPlayer();
				if (player.getHealth() != player.getMaxHealth()) {
					player.setHealth(player.getMaxHealth());
					item.setType(Material.BOWL);
				} else if (player.getFoodLevel() < 20) {
					player.setFoodLevel(20);
					item.setType(Material.BOWL);
				}
			}
		}
	}
}
