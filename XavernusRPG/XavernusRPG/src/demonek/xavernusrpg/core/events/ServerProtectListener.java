package demonek.xavernusrpg.core.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import demonek.xavernusrpg.core.utils.ChatUtil;

public class ServerProtectListener implements Listener
{
  public static boolean containsIgnoreCase(String[] pluginCommands, String string)
  {
	return false;
  }
  @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
  {
	Player player = event.getPlayer();
	if (!player.hasPermission("tools.plugins"))
	{
	  String message = event.getMessage();
	  String[] splittedMessage = message.split(" ");
	  String[] pluginCommands = { "/pl", "/plugins", "/?", "/help", "/bukkit:?", "/bukkit:pl", "/ver", "/bukkit:ver", "/bukkit:plugins" };
	  if (containsIgnoreCase(pluginCommands, splittedMessage[0]))
	  {
	    event.setCancelled(true);
	    player.sendMessage(ChatUtil.fixColor("&fPlugins (1): &aXavernusRPG"));
	  }
	}
  }
}
