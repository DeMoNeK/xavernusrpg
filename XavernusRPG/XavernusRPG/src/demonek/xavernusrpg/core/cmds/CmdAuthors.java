package demonek.xavernusrpg.core.cmds;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import demonek.xavernusrpg.core.utils.ChatUtil;

public class CmdAuthors implements CommandExecutor 
{
	
  public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args)
  {
	if ((cmd.getName().equalsIgnoreCase("autorzy") || (cmd.getName().equalsIgnoreCase("ver")) || (cmd.getName().equalsIgnoreCase("version"))))
	{
		if (!(sender instanceof Player)) { return false; }
	  gui((Player)sender);
	}
	return false;
  }
  
  private void gui(Player p)
  {
	Inventory inv = Bukkit.createInventory(p, 9, ChatUtil.fixColor("&f&l- &4&lTworcy &f&l-"));
	
	ItemStack demonek = new ItemStack(Material.BEDROCK, 1);
	ItemMeta dem = demonek.getItemMeta();
	
	ItemStack szklo = new ItemStack(Material.STAINED_GLASS_PANE, 1);
	ItemMeta szkl = szklo.getItemMeta();
	
	szkl.setDisplayName(ChatUtil.fixColor("&0&l&m"));
	szklo.setDurability((short)15);
	
	dem.setDisplayName(ChatUtil.fixColor("&4&lDeMoNeK_"));
	
	szklo.setItemMeta(szkl);
	
	ArrayList<String> lore = new ArrayList<String>();
	lore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	lore.add(ChatUtil.fixColor(""));
	lore.add(ChatUtil.fixColor("&4Jest to glowny tworca i pomyslodawca serwera."));
	lore.add(ChatUtil.fixColor("&4Oprocz tego, jest rowniez programista i wspolwlascicielem sieci WESTMC.NET."));
	lore.add(ChatUtil.fixColor(""));
	lore.add(ChatUtil.fixColor("&4Jesli znalazles jakis &4&lblad &4lub jesli masz jakas sprawe to koniecznie napisz do mnie!"));
	lore.add(ChatUtil.fixColor("&4Kontakt poprzez discord: &f&lhttps://discord.gg/rb97X3T"));
	lore.add(ChatUtil.fixColor(""));
	lore.add(ChatUtil.fixColor("&4W sprawie sieci WESTMC.NET zwracaj sie do &f&lmnie &4i do &f&lsesssowsky'iego&4."));
	lore.add(ChatUtil.fixColor(""));
	lore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	
	dem.setLore(lore);
	demonek.setItemMeta(dem);
	inv.setItem(4, demonek);
	
	inv.setItem(0, szklo);
	inv.setItem(1, szklo);
	inv.setItem(2, szklo);
	inv.setItem(3, szklo);
	inv.setItem(5, szklo);
	inv.setItem(6, szklo);
	inv.setItem(7, szklo);
	inv.setItem(8, szklo);
	
	p.openInventory(inv);
  }
}
