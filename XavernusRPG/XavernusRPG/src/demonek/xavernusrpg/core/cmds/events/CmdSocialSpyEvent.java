package demonek.xavernusrpg.core.cmds.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import demonek.xavernusrpg.core.utils.ChatUtil;

public class CmdSocialSpyEvent implements Listener 
{
  public static boolean containsIgnoreCase(String[] pluginCommands, String string)
  {
	return false;
  }
  @EventHandler(priority=EventPriority.LOWEST, ignoreCancelled=true)
  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
  {
	String cmd = event.getMessage().split(" ")[0].substring(1);
	String[] spyCmds = { "/msg", "whisper" };
	if (containsIgnoreCase(spyCmds, cmd))
	{
	  String social = ChatUtil.fixColor("&6AvernusRPG &7|&eSpy&7| &6" + event.getPlayer().getName() + ": &7" + event.getMessage());
	  for (Player player : Bukkit.getOnlinePlayers())
	  {
	    if ((player.hasPermission("xavernusrpg.spy")) || (player.isOp())) {
	      player.sendMessage(social);
	  }
	}
  }
 }
  
}