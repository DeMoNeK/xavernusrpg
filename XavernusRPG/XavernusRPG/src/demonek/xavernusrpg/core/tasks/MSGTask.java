package demonek.xavernusrpg.core.tasks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import demonek.xavernusrpg.core.Main;

public class MSGTask extends BukkitRunnable
{
  int i;
	  
  public void run()
  {
	Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', (String)Main.getInst().msgs.get(this.i)));
    this.i += 1;
	if (this.i >= Main.getInst().msgs.size()) {
	  this.i = 0;
	}
  }
}
