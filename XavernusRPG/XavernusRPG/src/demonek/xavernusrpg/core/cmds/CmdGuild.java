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

public class CmdGuild implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args)
  {
	if (!(sender instanceof Player)) { return false; }
    if (cmd.getName().equalsIgnoreCase("gildia"))
	{
      gui((Player)sender);
	}
  return false;
  }
  
  private void gui(Player p)
  {
	  Inventory inv = Bukkit.createInventory(p, 54, ChatUtil.fixColor("&6XAVERNUSRPG - &eGILDIE"));
	  
	  ItemStack stworz = new ItemStack(Material.IRON_PICKAXE, 1);
	  ItemStack dodaj = new ItemStack(Material.GOLD_AXE, 1);
	  ItemStack usun = new ItemStack(Material.BARRIER, 1);
	  ItemStack ulepsz = new ItemStack(Material.ANVIL, 1);
	  
	  ItemStack resp = new ItemStack(Material.COMPASS, 1);
	  ItemStack skarbiec = new ItemStack(Material.CHEST, 1);
	  
	  ItemStack informacje = new ItemStack(Material.PAPER, 1);
	  ItemStack czlonkowie = new ItemStack(Material.IRON_HELMET, 1);
	  
	  ItemStack szklo = new ItemStack(Material.STAINED_GLASS_PANE, 1);
	  szklo.setDurability((short)15);
	  
	  ItemMeta stworzMeta = stworz.getItemMeta();
	  ItemMeta dodajMeta = dodaj.getItemMeta();
	  ItemMeta usunMeta = usun.getItemMeta();
	  ItemMeta ulepszMeta = ulepsz.getItemMeta();
	  ItemMeta respMeta = resp.getItemMeta();
	  ItemMeta skarbiecMeta = skarbiec.getItemMeta();
	  ItemMeta informacjeMeta = informacje.getItemMeta();
	  ItemMeta czlonkowieMeta = czlonkowie.getItemMeta();
	  
	  ItemMeta szkloMeta = szklo.getItemMeta();
	  
	  stworzMeta.setDisplayName(ChatUtil.fixColor("&eStworz gildie"));
	  usunMeta.setDisplayName(ChatUtil.fixColor("&cRozwiaz gildie"));
	  dodajMeta.setDisplayName(ChatUtil.fixColor("&eDodaj czlonka gildii"));
	  ulepszMeta.setDisplayName(ChatUtil.fixColor("&eUlepsz gildie"));
	  respMeta.setDisplayName(ChatUtil.fixColor("&eUstaw resp gildii"));
	  skarbiecMeta.setDisplayName(ChatUtil.fixColor("&eOtworz skarbiec gildii"));
	  informacjeMeta.setDisplayName(ChatUtil.fixColor("&eInformacje o gildii"));
	  czlonkowieMeta.setDisplayName(ChatUtil.fixColor("&eCzlonkowie gildii"));
	  
	  szkloMeta.setDisplayName(" ");
	  
	  ArrayList<String> stworzLore = new ArrayList<String>();
	  stworzLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  stworzLore.add(ChatUtil.fixColor(""));
	  stworzLore.add(ChatUtil.fixColor("&8-= &7Kliknij aby stworzyc gildie! &8=-"));
	  stworzLore.add(ChatUtil.fixColor("&8=- &7Stworzenie gildii doda ci: &8=-"));
	  stworzLore.add(ChatUtil.fixColor("&8=- &7+ Range lidera gildii &8=-"));
	  stworzLore.add(ChatUtil.fixColor("&8=- &7+ Nad twoja glowa pokaze sie znak oznaczajacy"));
	  stworzLore.add(ChatUtil.fixColor("&8=- &7ze posiadasz swoja gildie &8=-"));
	  stworzLore.add(ChatUtil.fixColor(""));
	  stworzLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  
	  ArrayList<String> usunLore = new ArrayList<String>();
	  usunLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  usunLore.add(ChatUtil.fixColor(""));
	  usunLore.add(ChatUtil.fixColor("&8=- &7Kliknij aby usunac swoja gildie. &8=-"));
	  usunLore.add(ChatUtil.fixColor("&8=- &7Pamietaj, tej operacji nie mozna cofnac! &8=-"));
	  usunLore.add(ChatUtil.fixColor(""));
	  usunLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  
	  ArrayList<String> dodajLore = new ArrayList<String>();
	  dodajLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  dodajLore.add(ChatUtil.fixColor(""));
	  dodajLore.add(ChatUtil.fixColor("&8=- &7Kliknij tutaj i wybierz z listy gracza &8=-"));
	  dodajLore.add(ChatUtil.fixColor("&8=- &7Aby dodac go do twojej gildii &8=-"));
	  dodajLore.add(ChatUtil.fixColor(""));
	  dodajLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  
	  ArrayList<String> ulepszLore = new ArrayList<String>();
	  ulepszLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  ulepszLore.add(ChatUtil.fixColor(""));
	  ulepszLore.add(ChatUtil.fixColor("&8= &7Kliknij tutaj aby ulepszyc gildie &8=-"));
	  ulepszLore.add(ChatUtil.fixColor(""));
	  ulepszLore.add(ChatUtil.fixColor("&8=- &7Ulepszanie gildii to: &8=-"));
	  ulepszLore.add(ChatUtil.fixColor("&8=- &7+ Zwiekszanie maksymalnej ilosci czlonkow &8=-"));
	  ulepszLore.add(ChatUtil.fixColor("&8=- &7+ Zmniejszenie czasu teleportacji na resp &8=-"));
	  ulepszLore.add(ChatUtil.fixColor("&8=- &7+ Zwiekszenie otrzymywanej ilosci EXP za zabicie potworow &8=-"));
	  ulepszLore.add(ChatUtil.fixColor(""));
	  ulepszLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  
	  ArrayList<String> respLore = new ArrayList<String>();
	  respLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  respLore.add(ChatUtil.fixColor(""));
	  respLore.add(ChatUtil.fixColor("&8=- &7Kliknij tutaj aby ustawic pozycje respawnu &8=-"));
	  respLore.add(ChatUtil.fixColor(""));
	  respLore.add(ChatUtil.fixColor("&8=- &7W miejscu w ktorym stoisz zostanie ustawiony punkt respawnu. &8=-"));
	  respLore.add(ChatUtil.fixColor(""));
	  respLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  
	  ArrayList<String> skarbiecLore = new ArrayList<String>();
	  skarbiecLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  skarbiecLore.add(ChatUtil.fixColor(""));
	  skarbiecLore.add(ChatUtil.fixColor("&8=- &7Kliknij tutaj aby otworzyc skarbiec gildii &8=-"));
	  skarbiecLore.add(ChatUtil.fixColor(""));
	  skarbiecLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  
	  ArrayList<String> informacjeLore = new ArrayList<String>();
	  informacjeLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  informacjeLore.add(ChatUtil.fixColor(""));
	  informacjeLore.add(ChatUtil.fixColor("&8=- &7Informacje o twojej gildii: &8=-"));
	  informacjeLore.add(ChatUtil.fixColor("&8=- &7Gildia: &e- &8=-"));
	  informacjeLore.add(ChatUtil.fixColor("&8=- &7Poziom: &e- &8=-"));
	  informacjeLore.add(ChatUtil.fixColor("&8=- &7Maksymalna ilosc czlonkow: &e- &8=-"));
	  informacjeLore.add(ChatUtil.fixColor("&8=- &7Opis gildii: &e- &8=-"));
	  informacjeLore.add(ChatUtil.fixColor(""));
	  informacjeLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  
	  ArrayList<String> czlonkowieLore = new ArrayList<String>();
	  czlonkowieLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  czlonkowieLore.add(ChatUtil.fixColor(""));
	  czlonkowieLore.add(ChatUtil.fixColor("&8=- &7Lista czlonkow twojej gildii &8=-"));
	  czlonkowieLore.add(ChatUtil.fixColor(""));
	  czlonkowieLore.add(ChatUtil.fixColor("&8=- &cNie posiadasz gildii &8=-"));
	  czlonkowieLore.add(ChatUtil.fixColor(""));
	  czlonkowieLore.add(ChatUtil.fixColor("&8&l[+] -=-=-=&ax&8&l=-=-=- [+]"));
	  
	  stworzMeta.setLore(stworzLore);
	  usunMeta.setLore(usunLore);
	  dodajMeta.setLore(dodajLore);
	  ulepszMeta.setLore(ulepszLore);
	  respMeta.setLore(respLore);
	  skarbiecMeta.setLore(skarbiecLore);
	  informacjeMeta.setLore(informacjeLore);
	  czlonkowieMeta.setLore(czlonkowieLore);
	  
	  stworz.setItemMeta(stworzMeta);
	  usun.setItemMeta(usunMeta);
	  dodaj.setItemMeta(dodajMeta);
	  ulepsz.setItemMeta(ulepszMeta);
	  resp.setItemMeta(respMeta);
	  skarbiec.setItemMeta(skarbiecMeta);
	  informacje.setItemMeta(informacjeMeta);
	  czlonkowie.setItemMeta(czlonkowieMeta);
	  
	  szklo.setItemMeta(szkloMeta);
	  
	  
	  inv.setItem(0, szklo);
	  inv.setItem(1, szklo);
	  inv.setItem(2, szklo);
	  inv.setItem(3, szklo);
	  inv.setItem(4, szklo);
	  inv.setItem(5, szklo);
	  inv.setItem(6, szklo);
	  inv.setItem(7, szklo);
	  inv.setItem(8, szklo);
	  inv.setItem(9, szklo);
	  inv.setItem(11, szklo);
	  inv.setItem(13, szklo);
	  inv.setItem(15, szklo);
	  inv.setItem(17, szklo);
	  inv.setItem(18, szklo);
	  inv.setItem(19, szklo);
	  inv.setItem(20, szklo);
	  inv.setItem(21, szklo);
	  inv.setItem(22, szklo);
	  inv.setItem(23, szklo);
	  inv.setItem(24, szklo);
	  inv.setItem(25, szklo);
	  inv.setItem(26, szklo);
	  inv.setItem(27, szklo);
	  inv.setItem(28, szklo);
	  inv.setItem(29, szklo);
	  inv.setItem(30, szklo);
	  inv.setItem(31, szklo);
	  inv.setItem(32, szklo);
	  inv.setItem(33, szklo);
	  inv.setItem(34, szklo);
	  inv.setItem(35, szklo);
	  inv.setItem(36, szklo);
	  inv.setItem(38, szklo);
	  inv.setItem(40, szklo);
	  inv.setItem(42, szklo);
	  inv.setItem(44, szklo);
	  inv.setItem(45, szklo);
	  inv.setItem(46, szklo);
	  inv.setItem(47, szklo);
	  inv.setItem(48, szklo);
	  inv.setItem(49, szklo);
	  inv.setItem(50, szklo);
	  inv.setItem(51, szklo);
	  inv.setItem(52, szklo);
	  inv.setItem(53, szklo);
	  
	  inv.setItem(10, stworz); 	  
	  inv.setItem(12, dodaj); 	  
	  inv.setItem(14, usun); 	  
	  inv.setItem(16, ulepsz); 	  
	  inv.setItem(37, resp); 	  
	  inv.setItem(39, skarbiec); 	  
	  inv.setItem(41, informacje); 
	  inv.setItem(43, czlonkowie);
	  
	  p.openInventory(inv);
  }
}
