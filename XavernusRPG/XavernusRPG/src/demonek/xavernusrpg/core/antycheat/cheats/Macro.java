package demonek.xavernusrpg.core.antycheat.cheats;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import demonek.xavernusrpg.core.utils.ChatUtil;

public class Macro implements Listener
{
	  @SuppressWarnings("unlikely-arg-type")
	@EventHandler
	  public static void onDamage(EntityDamageByEntityEvent event)
	  {
	    if (((event.getEntity() instanceof Player)) && ((event.getDamager() instanceof Player)))
	    {
	      Player dmger = (Player)event.getDamager();
	      if ((!dmger.getItemInHand().equals(Material.BOW)) && 
	        (event.getEntity().getLocation().distance(dmger.getLocation()) == 5.0D)) {
	    	  for (Player admini : Bukkit.getOnlinePlayers())
	    	  {
	    		if ((admini.hasPermission("xavernusrpg.antycheat")) || (admini.isOp()))
	    		{
	    		  admini.playSound(admini.getLocation(), Sound.ANVIL_BREAK, 1.0F, 1.0F);
	    		  admini.sendMessage(ChatUtil.fixColor("&6XavernusRPG &7|&eAC&7|: &6" + dmger.getDisplayName() + "&6Wykryto: &7Macro (1ms)"));
	    		}
	    	  }
	      }
	    }
	  }
	}