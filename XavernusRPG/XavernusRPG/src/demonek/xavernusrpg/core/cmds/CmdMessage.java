package demonek.xavernusrpg.core.cmds;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import demonek.xavernusrpg.core.utils.ChatUtil;

public class CmdMessage implements CommandExecutor 
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashMap<Player, Player> lastMessageSender = new HashMap();
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	  if (cmd.getName().equalsIgnoreCase("czapka")) {
		if ((sender instanceof Player))
	    {
	      Player player = (Player)sender;
	      if (args.length > 1)
	      {
	        Player other = Bukkit.getPlayer(args[0]);
	        if (other != null)
	        {
	          if ((!other.hasPermission("xavernusrpg.msg")) || ((other.hasPermission("tools.tell.nomessage")) && (player.hasPermission("tools.tell.nomessage"))))
	          {
	            lastMessageSender.put(other, player);
	            lastMessageSender.put(player, other);
	            StringBuilder sb = new StringBuilder();
	            for (int i = 1; i < args.length; i++) {
	              sb.append(args[i]).append(" ");
	            }
	            String message = sb.toString();
	            other.sendMessage(ChatUtil.fixColor("&e[&6" + player.getDisplayName() + "&6 -> Ty&e]: &7" + message));
	            player.sendMessage(ChatUtil.fixColor("&e[&6Ty -> " + other.getDisplayName() + "&e]: &7" + message));
	            return true;
	          }
	          player.sendMessage(ChatUtil.fixColor("&4&lNie masz uprawnien, &4musisz posiadac permisje &4&l- &8<xavernusrpg.msg>"));
	        }
	        else
	        {
	          player.sendMessage(ChatUtil.fixColor("&4&lGracz o nicku: &4" + args[0] + " &4&ljest offline."));
	        }
	      }
	      else
	      {
	        player.sendMessage(ChatUtil.fixColor("&4&lZle, &4napisz &4&l- &8/msg <gracz> <tresc>"));
	      }
	    }
	    else
	    {
	      sender.sendMessage(ChatUtil.fixColor("&7Musisz byc na serwerze."));
	    }
	    return false;
	  }
	return false;
    }
}
