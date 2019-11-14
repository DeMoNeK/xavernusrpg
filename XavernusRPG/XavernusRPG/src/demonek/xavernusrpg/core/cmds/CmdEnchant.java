package demonek.xavernusrpg.core.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import demonek.xavernusrpg.core.utils.ChatUtil;
import demonek.xavernusrpg.core.utils.EnchantUtil;

public class CmdEnchant implements CommandExecutor 
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
	if (cmd.getName().equalsIgnoreCase("enchant"))
	{
	  Player p = (Player) sender;
	  
	  if (!(sender instanceof Player))
	  {
		sender.sendMessage(ChatUtil.fixColor("&7Musisz byc na serwerze!"));
		return false;
	  }
	  
	  if (!(p.hasPermission("xavernusrpg.enchant")))
	  {
		p.sendMessage(ChatUtil.fixColor("&4&lNie masz uprawnien, &4musisz posiadac permisje &4&l- &8<xavernusrpg.enchant>"));
	  }
	  
	  if (args.length == 0)
	  {
		p.sendMessage(ChatUtil.fixColor("&4&lZle, &4napisz &4&l- &8/enchant <zaklecie>"));
	  }
	  else
	  {
		if(args.length >= 2)
		{
	      String enchantName = args[0];	
	      ItemStack item = p.getItemInHand();
	      Enchantment enchant = EnchantUtil.get(enchantName);
	      
	      if (enchant == null)
	      {
	    	p.sendMessage(ChatUtil.fixColor("&4&lPodane zaklecie nie istnieje!"));
	    	return false;
	      }
	      
	      int level = enchant.getMaxLevel();
	      
	      if (EnchantUtil.isInteger(args[1]))
	      {
	    	level = Integer.parseInt(args[1]);
	      }
	      else
	      {
	    	p.sendMessage(ChatUtil.fixColor("&4&lPoziom zaklecia musi byc liczba!"));
	    	return false;
	      }
	      
	      item.addUnsafeEnchantment(enchant, level);
	      ChatUtil.sendActionBar(p, "&6&lPomyslnie zenchantowales " + item.getType().toString() + "&6&lna " + enchant.getName() + " &8(&7" + level + "&7");
		}
	  }
	}
	return false;
  }
}
