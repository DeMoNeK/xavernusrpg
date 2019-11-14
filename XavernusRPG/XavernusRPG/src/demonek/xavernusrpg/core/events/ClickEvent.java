package demonek.xavernusrpg.core.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import demonek.xavernusrpg.core.utils.ChatUtil;

public class ClickEvent implements Listener
{
  @EventHandler(priority=EventPriority.MONITOR)
  public void onClick(InventoryClickEvent e)
  {
    if (!ChatUtil.fixColor("&f&l- &4&lTworcy &f&l-").equalsIgnoreCase(e.getInventory().getName())) {
	  return;
	}
    
    if (!ChatUtil.fixColor("&6XAVERNUSRPG - &eGILDIE").equalsIgnoreCase(e.getInventory().getName())) {
	  return;
	}
    e.setCancelled(true);
  }
}
