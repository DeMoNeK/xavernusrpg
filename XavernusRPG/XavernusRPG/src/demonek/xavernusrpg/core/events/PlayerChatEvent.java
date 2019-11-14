package demonek.xavernusrpg.core.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatEvent implements Listener {

	@EventHandler
	public void OnPlayerChat(AsyncPlayerChatEvent e)
	{
	  Player p = e.getPlayer();
	  
	  if (e.getMessage().toLowerCase().startsWith("kurwa")){
		e.setCancelled(true);
	  	for (Player admin : Bukkit.getOnlinePlayers()){
	      if (admin.hasPermission("xavernusrpg.spy")){
	      	admin.sendMessage(ChatColor.GRAY + p.getName() + ChatColor.GOLD + " probowal napisam zakazane slowo!");
	  	  }
	  	}
	  	p.sendMessage(ChatColor.GOLD + "Otrzymales ostrzezenie! Powod: " + ChatColor.GRAY + "Przeklinanie");
	  }
	  
	  if (p.isOp())
	  {
	    e.setFormat(ChatColor.GOLD + "Krol " + ChatColor.DARK_GRAY + "|P: 1 " + ChatColor.GOLD + p.getName() + ": " + ChatColor.GRAY + e.getMessage());
	  }
	  else
	  {
	    e.setFormat(ChatColor.GOLD + "Przybysz " + ChatColor.DARK_GRAY + "|P: 1 " + ChatColor.GOLD + p.getName() + ": " + ChatColor.GRAY + e.getMessage());
	  }
	  // rangi
	  if (p.hasPermission("xavernusrpg.szlachta"))
	  {
		e.setFormat(ChatColor.GOLD + "Szlachta " + ChatColor.DARK_GRAY + "|P: 1 " + ChatColor.GOLD + p.getName() + ": " + ChatColor.GRAY + e.getMessage());
	  }
	}
}