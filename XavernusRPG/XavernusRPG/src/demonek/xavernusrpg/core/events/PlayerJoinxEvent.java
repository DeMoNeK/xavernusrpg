package demonek.xavernusrpg.core.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinxEvent implements Listener
{
  @EventHandler
  public void PlayerJoin(PlayerJoinEvent e)
  {
	if (!e.getPlayer().hasPlayedBefore())
	{
      Player p = e.getPlayer();
      double i = 20.0D;
      
      p.teleport(loc(p.getWorld()));
      p.setHealth((int)i);
      p.setFoodLevel((int)i);
    	
      e.setJoinMessage(null);
      for (Player online : Bukkit.getOnlinePlayers())
      {
    	send("&4&lNowy przybysz, &4&l- &7" + p.getName(), online);
    	send("&6Odwiedzil wlasnie swiat XavernusRPG!", online);
      }
    }
  }
  
  @EventHandler
  public void PlayerQuit(PlayerQuitEvent e)
  {
	e.setQuitMessage(null); 
  }
  
  @EventHandler
  public void PlayerKick(PlayerKickEvent e)
  {
	e.setLeaveMessage(null);
  }
  
  void send (String msg, Player p) {
	p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
  }
  
  public static Location loc(World world)
  {
	double x = 0.0D;
	double y = 0.0D;
	double z = 0.0D;

	return new Location(world, x, y, z);
  }
}
