package demonek.xavernusrpg.core.quests;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import demonek.xavernusrpg.core.utils.ChatUtil;

public class Quest 
implements Listener 
{
  int nagroda = 1;
	
  public void QuestInteraction(PlayerInteractEvent e)
  {
	Player p = e.getPlayer();
	Location loc = p.getLocation();
	
	if ((e.getAction() == Action.LEFT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
	{
	  if (e.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE)
	  {
		p.playSound(loc, Sound.FIREWORK_BLAST, 1.0F, 1.0F);
		
		QuestGui(p);
	  }
	}
  }
  
  private void QuestGui(Player p)
  {
	Inventory inv = Bukkit.createInventory(p, 9, ChatUtil.fixColor("&6XAVERNUSRPG - &eQUESTY"));
	
	ItemStack quest1 = new ItemStack(Material.ENCHANTED_BOOK);
	ItemMeta quest1Meta = quest1.getItemMeta();
	
	ItemStack szklo = new ItemStack(Material.STAINED_GLASS_PANE, 1);
	szklo.setDurability((short)15);
	ItemMeta szkloMeta = szklo.getItemMeta();
	
	quest1Meta.setDisplayName(ChatUtil.fixColor("&eZadanie pierwsze"));
	quest1Meta.addEnchant(Enchantment.DURABILITY, 5, true);
	
	szkloMeta.setDisplayName(ChatUtil.fixColor(" "));
	
	ArrayList<String> quest1Lore = new ArrayList<String>();
	quest1Lore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	quest1Lore.add(ChatUtil.fixColor(""));
	quest1Lore.add(ChatUtil.fixColor("&8-= &7Polecenie: &8=-"));
	quest1Lore.add(ChatUtil.fixColor("&8-= &7- Zabic 10 krow. &8=-"));
	quest1Lore.add(ChatUtil.fixColor("&8-= &7- Przyniesc 5 miesa krowy do Rzeznika. &8=-"));
	quest1Lore.add(ChatUtil.fixColor(""));
	quest1Lore.add(ChatUtil.fixColor("&8-= &7Wynagrodzenie: &8=-"));
	quest1Lore.add(ChatUtil.fixColor(""));
	quest1Lore.add(ChatUtil.fixColor("&8-= &7- &e" + (int)nagroda + " &7zlotych monet. &8=-"));
	quest1Lore.add(ChatUtil.fixColor(""));
	quest1Lore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	
	quest1Meta.setLore(quest1Lore);
	quest1.setItemMeta(quest1Meta);
	
	szklo.setItemMeta(szkloMeta);
	
	inv.setItem(0, quest1);
	inv.setItem(1, szklo);
	inv.setItem(2, szklo);
	inv.setItem(3, szklo);
	inv.setItem(4, szklo);
	inv.setItem(5, szklo);
	inv.setItem(6, szklo);
	inv.setItem(7, szklo);
	inv.setItem(8, szklo);
	
	p.openInventory(inv);
  }
}