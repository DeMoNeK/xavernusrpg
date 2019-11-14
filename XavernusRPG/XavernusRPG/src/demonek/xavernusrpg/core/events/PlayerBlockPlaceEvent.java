package demonek.xavernusrpg.core.events;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import demonek.xavernusrpg.core.utils.ChatUtil;

public class PlayerBlockPlaceEvent implements Listener
{
  @EventHandler
  public void onPlayerBlockPlace(BlockPlaceEvent e)
  {
	Material m = e.getBlockPlaced().getType();
	Player p = e.getPlayer();
	
	if (m == Material.TNT)
	{
	  e.setCancelled(true);
	  p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
	  p.sendMessage(ChatUtil.fixColor("&7Stawianie &6TNT &7zostalo zablokowane!"));
	}
	else if (m == Material.BEDROCK)
	{
	  e.setCancelled(true);
	  p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1.0F, 1.0F);
	  p.sendMessage(ChatUtil.fixColor("&7Stawianie &6BEDROCK'a &7zostalo zablokowane!"));
	}
	else if (m == Material.EXPLOSIVE_MINECART)
	{
	  e.setCancelled(true);
	  p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
	  p.sendMessage(ChatUtil.fixColor("&7Stawianie &6WAGONIKA Z TNT &7zostalo zablokowane!"));
	}
	else if (m == Material.FIREBALL)
	{
	  e.setCancelled(true);
	  p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1.0F, 1.0F);
	  p.sendMessage(ChatUtil.fixColor("&7Stawianie &6FIREBALL'a &7zostalo zablokowane!"));
	}
  }
}
