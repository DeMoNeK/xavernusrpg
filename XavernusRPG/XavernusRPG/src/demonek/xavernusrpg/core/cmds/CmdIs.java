package demonek.xavernusrpg.core.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import demonek.xavernusrpg.core.utils.ChatUtil;

public class CmdIs
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
	if (cmd.getName().equalsIgnoreCase("is"))
	{
    Player p = (Player)sender;
    if (!p.hasPermission("xavernusrpg.is"))
    {
      p.sendMessage(ChatUtil.fixColor("&4&lNie masz uprawnien, &4musisz posiadac permisje &4&l- &8<xavernusrpg.is>"));
      return true;
    }
    if (args.length <= 1)
    {
      p.sendMessage(ChatUtil.fixColor("&4&lZle, &4napisz &4&l- &8/is <ranga> <nick>"));
    }
    else
    {
      if (Bukkit.getPlayerExact(args[1]) == null)
      {
    	p.sendMessage(ChatUtil.fixColor("&4&lNie odnaleziono podanego gracza!"));
        return true;
      }
      if (args[0].equalsIgnoreCase("vip"))
      {
        for (Player online : Bukkit.getOnlinePlayers())
        {
          online.sendMessage(ChatUtil.fixColor("&6Gracz &7" + args[1] + " &6zakupil range &7VIP! &4Dziekujemy!"));
        }
      }
      else if (args[0].equalsIgnoreCase("svip"))
      {
    	for (Player online : Bukkit.getOnlinePlayers())
    	{
    		online.sendMessage(ChatUtil.fixColor("&6Gracz &7" + args[1] + " &6zakupil range &7SVIP! &4Dziekujemy!"));
    	}
      }
      else
      {
    	  p.sendMessage(ChatUtil.fixColor("&4&lDostepne rangi: &4VIP, SVIP"));
      }
    }
    return false;
  }
	return false;
  }
}
