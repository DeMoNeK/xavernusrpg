package demonek.xavernusrpg.core.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CmdChat
  implements CommandExecutor, Listener
{
  public static Boolean chat;
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onChat(AsyncPlayerChatEvent e)
  {
    Player p = e.getPlayer();
    if ((!chat.booleanValue()) && 
      (p.hasPermission("xavernusrpg.chat.allow")))
    {
      send("&4&lPrzykro nam, &4chat jest aktualnie wylaczony!", p);
      e.setCancelled(true);
    }
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("chat")) {
    	Player p = (Player) sender;
    	if (!(sender instanceof Player)) { return false; }
      if (!p.hasPermission("xavernusrpg.chat"))
      {
        send("&4&lNie masz uprawnien, &4musisz posiadac permisje &4&l- &8<xavernusrpg.chat>", p);
      }
      else if (args.length == 0)
      {
        send("&4&lZle, &4napisz &4&l- &8/chat <wlacz/wylacz/wyczysc>", p);
      }
      else
      {
        if (args[0].equalsIgnoreCase("wlacz"))
        {
          if (chat.booleanValue())
          {
            for (Player online : Bukkit.getOnlinePlayers())
            {
              send("&4&lUwaga, &4chat zostal wlaczony! &4&l- &8Mozesz teraz pisac!", online);
            }
            return true;
          }
          chat = Boolean.valueOf(true);
        }
        if (args[0].equalsIgnoreCase("wylacz"))
        {
          if (chat.booleanValue())
          {
            for (Player online : Bukkit.getOnlinePlayers())
            {
              send("&4&lUwaga, &4chat zostal wylaczony! &4&l- &8Nie mozesz teraz pisac!", online);
            }
            return true;
          }
          chat = Boolean.valueOf(true);
        }
        if (args[0].equalsIgnoreCase("wyczysc"))
        {
          int i = 0;
          while (i < 101)
          {
            for (Player online : Bukkit.getOnlinePlayers())
            {
              send(" ", online);
            }
            i++;
          }
          for (Player online : Bukkit.getOnlinePlayers())
          {
            send("&4&lUwaga, &4chat zostal wyczysczony &4&l- &8przez &7" + p.getName(), online);
          }
        }
      }
    }
    return false;
  }
  
  void send (String msg, Player p) {
	p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
  }
}