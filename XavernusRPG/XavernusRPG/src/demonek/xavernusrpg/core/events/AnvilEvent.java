package demonek.xavernusrpg.core.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class AnvilEvent implements Listener {
	@SuppressWarnings("unused")
	@EventHandler
	public void OnClick (PlayerInteractEvent e) {
			Player p = e.getPlayer();
			Location l = p.getLocation();
			if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) {
				if (e.getClickedBlock().getType() == Material.ANVIL) {
					e.setCancelled(true);
					p.closeInventory();
					p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);
					send("&cUlepszanie przedmiotow jest niedostepne!", p);
				} 
			}
	}
	void send (String msg, Player p) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
}
