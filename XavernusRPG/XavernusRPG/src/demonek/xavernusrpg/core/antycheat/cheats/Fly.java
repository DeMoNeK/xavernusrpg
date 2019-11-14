package demonek.xavernusrpg.core.antycheat.cheats;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import demonek.xavernusrpg.core.utils.ChatUtil;

public class Fly
  implements Listener
{
  @EventHandler
  public static void onMove(PlayerMoveEvent event)
  {
    if ((event.getPlayer().isFlying()) && (!event.getPlayer().hasPermission("xavernusrpg.menu"))) {
      event.getPlayer().teleport(event.getFrom());
      for (Player admini : Bukkit.getOnlinePlayers())
      {
  		if ((admini.hasPermission("xavernusrpg.antycheat")) || (admini.isOp()))
  		{
  		  admini.playSound(admini.getLocation(), Sound.ANVIL_BREAK, 1.0F, 1.0F);
  		  admini.sendMessage(ChatUtil.fixColor("&6XavernusRPG &7|&eAC&7|: &6" + event.getPlayer().getDisplayName() + "&6Wykryto: &7Fly'a"));
  		}
      }
    }
  }
}
