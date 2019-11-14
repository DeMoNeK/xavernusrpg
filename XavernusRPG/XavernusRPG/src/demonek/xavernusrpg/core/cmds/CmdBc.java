package demonek.xavernusrpg.core.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdBc
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    StringBuilder str = new StringBuilder();
    if (cmd.getName().equalsIgnoreCase("bc")) {
      Player p = (Player) sender;
      if (!p.hasPermission("xavernusrpg.bc"))
      {
          send("&4&lNie masz uprawnien, &4musisz posiadac permisje &4&l- &8<xavernusrpg.bc>", p);
      }
      else if (args.length == 0)
      {
          send("&4&lZle, &4napisz &4&l- &8/bc <wiadomosc>", p);
      }
      else
      {
        for (int i = 0; i < args.length; i++) {
          str.append(args[i] + " ");
        }
        String msg = str.toString();
        for (Player online : Bukkit.getOnlinePlayers())
        {
          send("&f&l- &4&lOGLOSZENIE SERWEROWE &f&l-", online);
          send("&8&l[", online);
          send("&8&l[ ", online);
          send("&4&l" + p.getName() + " &4&l- &7" + msg, online);
        }
      }
    }
    return false;
  }
  
  void send (String msg, Player p) {
	p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
  }
}
