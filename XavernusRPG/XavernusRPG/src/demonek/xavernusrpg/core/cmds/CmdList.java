package demonek.xavernusrpg.core.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import demonek.xavernusrpg.core.utils.ChatUtil;

public class CmdList implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args)
  {
	if (!(sender instanceof Player)) { return false; }
	if (cmd.getName().equalsIgnoreCase("list"))
	{
	    int onlineplayers = Bukkit.getOnlinePlayers().size();
	    int maxplayers = Bukkit.getMaxPlayers();
	    sender.sendMessage(ChatUtil.fixColor("&6Na serwerze jest: &7" + onlineplayers + " &6graczy online na: &7" + maxplayers + " &6mozliwych."));
	}
  return false;
  }
}
