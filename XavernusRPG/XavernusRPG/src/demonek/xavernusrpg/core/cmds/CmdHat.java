package demonek.xavernusrpg.core.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import demonek.xavernusrpg.core.utils.ChatUtil;

public class CmdHat implements CommandExecutor
{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	  if (cmd.getName().equalsIgnoreCase("czapka")) {
		Player p = (Player) sender;
	    if ((sender instanceof Player))
	    {
	      Player player = (Player)sender;
	      ItemStack item = player.getItemInHand();
	      if (player.hasPermission("xavernusrpg.czapka"))
	      {
	        player.setItemInHand(null);
	        if (player.getInventory().getHelmet() != null)
	        {
	          ItemStack helmet = player.getInventory().getHelmet();
	          player.setItemInHand(helmet);
	        }
	        player.getInventory().setHelmet(item);
	        sender.sendMessage(ChatUtil.fixColor("&4&lOtrzymales nowa czapke!"));
	      }
	      else
	      {
	    	  p.sendMessage(ChatUtil.fixColor("&4&lNie masz uprawnien, &4musisz posiadac permisje &4&l- &8<xavernusrpg.czapka>"));
	      }
	    }
	    else
	    {
	    	sender.sendMessage(ChatUtil.fixColor("&7Musisz byc na serwerze!"));
	    }
	    return false;
	  }
	return false;
	}
}
