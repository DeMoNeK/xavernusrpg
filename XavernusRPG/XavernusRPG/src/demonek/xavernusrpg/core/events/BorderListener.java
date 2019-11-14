package demonek.xavernusrpg.core.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class BorderListener implements Listener
{
  @EventHandler(priority=EventPriority.HIGH)
  public void BorderMap(PlayerMoveEvent e)
  {
	//Player player = e.getPlayer();
	//if ((e.getTo().getBlockX() > 5000) || (e.getTo().getBlockX() < 60536) || (e.getTo().getBlockZ() > 2000) || (e.getTo().getBlockZ() < 60536))
	//{
	 // player.teleport(e.getFrom());
	 // player.sendMessage(ChatUtil.fixColor("&cNiestey, nie mozesz pojsc dalej! Oto granica tego swiata."));
	  //player.playSound(e.getPlayer().getLocation(), Sound.ENDERMAN_TELEPORT, 10.0F, 1.0F);
	//}
  }
}
