package demonek.xavernusrpg.core;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import demonek.xavernusrpg.core.antycheat.AntyCheat;
import demonek.xavernusrpg.core.antycheat.cheats.Fly;
import demonek.xavernusrpg.core.antycheat.cheats.KillAura;
import demonek.xavernusrpg.core.antycheat.cheats.Macro;
import demonek.xavernusrpg.core.antycheat.cheats.Sneak;
import demonek.xavernusrpg.core.cmds.CmdAuthors;
import demonek.xavernusrpg.core.cmds.CmdBc;
import demonek.xavernusrpg.core.cmds.CmdChat;
import demonek.xavernusrpg.core.cmds.CmdEnchant;
import demonek.xavernusrpg.core.cmds.CmdGuild;
import demonek.xavernusrpg.core.cmds.CmdHat;
import demonek.xavernusrpg.core.cmds.CmdIs;
import demonek.xavernusrpg.core.cmds.CmdList;
import demonek.xavernusrpg.core.cmds.CmdMessage;
import demonek.xavernusrpg.core.cmds.events.CmdSocialSpyEvent;
import demonek.xavernusrpg.core.events.AnvilEvent;
import demonek.xavernusrpg.core.events.BorderListener;
import demonek.xavernusrpg.core.events.ClickEvent;
import demonek.xavernusrpg.core.events.EntityEvent;
import demonek.xavernusrpg.core.events.PlayerBlockBreakEvent;
import demonek.xavernusrpg.core.events.PlayerBlockPlaceEvent;
import demonek.xavernusrpg.core.events.PlayerChatEvent;
import demonek.xavernusrpg.core.events.ServerProtectListener;
import demonek.xavernusrpg.core.events.WeatherEvent;
import demonek.xavernusrpg.core.events.mobs.MobLvl1;
import demonek.xavernusrpg.core.quests.Quest;
import demonek.xavernusrpg.core.tasks.MSGTask;
import demonek.xavernusrpg.core.utils.ChatUtil;

public class Main
  extends JavaPlugin
  implements Listener
{
	
  private static Main instance;
  public List<String> msgs;
  
  @SuppressWarnings("deprecation")
private void runAutoMsg(int delay)
  {
    Bukkit.getScheduler().runTaskTimer(this, new MSGTask(), 0L, delay * 20);
  }
  
  public static Main getInst()
  {
    return instance;
  }
  
  public void onEnable()
  {
	instance = this;
    saveDefaultConfig();
    PluginManager pm = Bukkit.getPluginManager();
    pm.registerEvents(new AnvilEvent(), this);
    pm.registerEvents(new PlayerChatEvent(), this);
    pm.registerEvents(new MobLvl1(), this);
    pm.registerEvents(new ClickEvent(), this);
    pm.registerEvents(new WeatherEvent(), this);
    pm.registerEvents(new EntityEvent(), this);
    pm.registerEvents(new PlayerBlockPlaceEvent(), this);
    pm.registerEvents(new PlayerBlockBreakEvent(), this);
    pm.registerEvents(new ServerProtectListener(), this);
    pm.registerEvents(new BorderListener(), this);
    pm.registerEvents(new CmdSocialSpyEvent(), this);
    
    pm.registerEvents(new AntyCheat(), this);
    pm.registerEvents(new Fly(), this);
    pm.registerEvents(new KillAura(), this);
    pm.registerEvents(new Sneak(), this);
    pm.registerEvents(new Macro(), this);
    
    pm.registerEvents(new Quest(), this);
    
    pm.registerEvents(this, this);
    
    this.msgs = getConfig().getStringList("automsg");
    
    runAutoMsg(60);
    
    System.out.println("-=-=-=-=-=-=-=-=-=-=-");
    System.out.println(".");
    System.out.println(".");
    System.out.println(".");
    System.out.println("     AvernusRPG     ");
    System.out.println("   Glowny plug-in  ");
    System.out.println("  zostal uruchomiony ");
    System.out.println("");
    System.out.println("  Autor: DeMoNeK_  ");
    System.out.println(" Aktualna wersja: 0.1 ");
    System.out.println("Czas ladowania: 9.014ms");
    System.out.println("");
    System.out.println("Zakaz kopiowania na inne serwery!");
    System.out.println(".");
    System.out.println(".");
    System.out.println(".");
    System.out.println("-=-=-=-=-=-=-=-=-=-=-");
    
    getCommand("chat").setExecutor(new CmdChat());
    getCommand("bc").setExecutor(new CmdBc());
    getCommand("autorzy").setExecutor(new CmdAuthors());
    getCommand("enchant").setExecutor(new CmdEnchant());
    getCommand("is").setExecutor(new CmdIs());
    getCommand("gildia").setExecutor(new CmdGuild());
    getCommand("list").setExecutor(new CmdList());
    getCommand("msg").setExecutor(new CmdMessage());
    getCommand("czapka").setExecutor(new CmdHat());
    
    Bukkit.getPluginManager().registerEvents(new Listener()
    
    
    
    {
      @SuppressWarnings("deprecation")
	@EventHandler
      public void GuiShortCut(PlayerDropItemEvent eve)
      {
        if (eve.getItemDrop().getItemStack().getTypeId() == Main.this.getConfig().getInt("customshortcutitem"))
        {
          Player p = eve.getPlayer();
          if (p.hasPermission("xaverusrpg.menu"))
          {
            ItemStack slot0 = new ItemStack(Material.IRON_SWORD, 1);
            ItemStack slot1 = new ItemStack(Material.DIAMOND_BOOTS, 1);
            ItemStack slot2 = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
            ItemStack slot3 = new ItemStack(Material.REDSTONE, 1);
            ItemStack slot4 = new ItemStack(Material.BARRIER, 1);
            ItemStack slot5 = new ItemStack(Material.BARRIER, 1);
            ItemStack slot6 = new ItemStack(Material.PAPER, 1);
            ItemStack slot7 = new ItemStack(Material.BARRIER, 1);
            ItemStack slot8 = new ItemStack(Material.BOOK, 1);
            
        
            
            ItemMeta meta0 = slot0.getItemMeta();
            
            ItemMeta meta1 = slot1.getItemMeta();
            ItemMeta meta2 = slot2.getItemMeta();
            ItemMeta meta3 = slot3.getItemMeta();
            ItemMeta meta4 = slot4.getItemMeta();
            ItemMeta meta5 = slot5.getItemMeta();
            ItemMeta meta6 = slot6.getItemMeta();
            
            ItemMeta meta7 = slot7.getItemMeta();
            ItemMeta meta8 = slot8.getItemMeta();
            
            meta0.setDisplayName(ChatColor.GOLD + Main.this.getConfig().getString("postac.one.title"));
            meta1.setDisplayName(ChatColor.GOLD + Main.this.getConfig().getString("postac.two.title"));
            meta2.setDisplayName(ChatColor.GOLD + Main.this.getConfig().getString("postac.three.title"));
            meta3.setDisplayName(ChatColor.GOLD + Main.this.getConfig().getString("postac.four.title"));
            meta4.setDisplayName(ChatColor.GOLD + Main.this.getConfig().getString("postac.five.title"));
            meta5.setDisplayName(ChatColor.GOLD + Main.this.getConfig().getString("postac.six.title"));
            meta6.setDisplayName(ChatColor.GOLD + Main.this.getConfig().getString("postac.seven.title"));
            meta7.setDisplayName(ChatColor.GOLD + Main.this.getConfig().getString("postac.eight.title"));
            meta8.setDisplayName(ChatColor.GOLD + Main.this.getConfig().getString("postac.nine.title"));
            
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(" ");
            lore.add(ChatColor.GOLD + "Zabitych potworow: " + ChatColor.GRAY + "0");
            lore.add(ChatColor.GOLD + "Zabitych bossow: " + ChatColor.GRAY + "0");
            lore.add(ChatColor.GOLD + "Zabitych ludzi: " + ChatColor.GRAY + "0");
            lore.add(ChatColor.GOLD + "Wykonanych zadan: " + ChatColor.GRAY + "0");
            lore.add(ChatColor.GOLD + "Otrzymanych talonow: " + ChatColor.GRAY + "0");
            
            ArrayList<String> zadania = new ArrayList<String>();
            zadania.add(" ");
            zadania.add(ChatColor.GOLD + "Aktualne zadanie: " + ChatColor.GRAY + "Porozmawiaj z Tomaszem w karczmie");
            zadania.add(ChatColor.GOLD + "Postep: " + ChatColor.GRAY + "0%");
            zadania.add(ChatColor.GOLD + "Nagroda: " + ChatColor.GRAY + "10 exp");
            zadania.add(ChatColor.GOLD + "Trudnosc: " + ChatColor.GREEN + "latwe");
            zadania.add(ChatColor.GOLD + "Nastepne zadanie: " + ChatColor.GRAY + "-");

            ArrayList<String> sila = new ArrayList<String>();
            sila.add(" ");
            sila.add(ChatColor.GOLD + "Aktualny poziom sily: " + ChatColor.GRAY + "1/15");

            ArrayList<String> zwinnosc = new ArrayList<String>();
            zwinnosc.add(" ");
            zwinnosc.add(ChatColor.GOLD + "Aktualny poziom zwinnosci: " + ChatColor.GRAY + "1/15");

            ArrayList<String> obrona = new ArrayList<String>();
            obrona.add(" ");
            obrona.add(ChatColor.GOLD + "Aktualny poziom obrony: " + ChatColor.GRAY + "1/15");

            ArrayList<String> zdrowie = new ArrayList<String>();
            zdrowie.add(" ");
            zdrowie.add(ChatColor.GOLD + "Aktualny poziom zdrowia: " + ChatColor.GRAY + "1/20");
            zdrowie.add(" ");
            zdrowie.add(ChatColor.RED + "â– " + ChatColor.GRAY + "â– â– â– â– â– â– â– â– â– â– â– â– â– â– â– â– â– â– â– ");
            zdrowie.add(ChatColor.DARK_GRAY + "Chcialbys zwiekszyc poziom zdrowia? Zdobadz amulet zdrowia.");

            meta0.setLore(sila);
            meta1.setLore(zwinnosc);
            meta2.setLore(obrona);
            meta3.setLore(zdrowie);
            
            meta8.setLore(lore);
            meta6.setLore(zadania);
            
            slot0.setItemMeta(meta0);
            slot1.setItemMeta(meta1);
            slot2.setItemMeta(meta2);
            slot3.setItemMeta(meta3);
            slot4.setItemMeta(meta4);
            slot5.setItemMeta(meta5);
            slot6.setItemMeta(meta6);
            slot7.setItemMeta(meta7);
            slot8.setItemMeta(meta8);
            
            Inventory x104 = Bukkit.createInventory(null, 9, "Twoja postac");
            
            x104.setItem(0, slot0);
            x104.setItem(1, slot1);
            x104.setItem(2, slot2);
            x104.setItem(3, slot3);
            //x104.setItem(4, slot4);
            x104.setItem(5, slot5);
            x104.setItem(6, slot6);
            x104.setItem(7, slot7);
            x104.setItem(8, slot8);
            
            p.openInventory(x104);
            eve.setCancelled(true);
          }
        }
        if (eve.getItemDrop().getItemStack().getTypeId() == Main.this.getConfig().getInt("mainshortcutitem"))
        {
          Player p = eve.getPlayer();
          if (p.hasPermission("xavernusrpg.menu"))
          {
            ItemStack slot0 = new ItemStack(Material.IRON_PICKAXE, 1);
            ItemStack slot1 = new ItemStack(Material.WOOD_PICKAXE, 1);
            ItemStack slot2 = new ItemStack(Material.GOLDEN_APPLE, 1);
            ItemStack slot3 = new ItemStack(Material.BLAZE_ROD, 1);
            ItemStack slot4 = new ItemStack(Material.HAY_BLOCK, 1);
            ItemStack slot5 = new ItemStack(Material.COAL_BLOCK, 1);
            ItemStack slot6 = new ItemStack(Material.GLOWSTONE_DUST, 1);
            ItemStack slot7 = new ItemStack(Material.GOLD_INGOT, 1);
            ItemStack slot8 = new ItemStack(Material.BARRIER, 1);
            
         
            
            ItemMeta meta0 = slot0.getItemMeta();
            
            ItemMeta meta1 = slot1.getItemMeta();
            ItemMeta meta2 = slot2.getItemMeta();
            ItemMeta meta3 = slot3.getItemMeta();
            ItemMeta meta4 = slot4.getItemMeta();
            ItemMeta meta5 = slot5.getItemMeta();
            ItemMeta meta6 = slot6.getItemMeta();
            
            ItemMeta meta7 = slot7.getItemMeta();
            ItemMeta meta8 = slot8.getItemMeta();
            
            meta0.setDisplayName(ChatColor.GOLD + "Tryb gry: Kreatywny");
            meta1.setDisplayName(ChatColor.GOLD + "Tryb gry: Survivalowy");
            meta2.setDisplayName(ChatColor.GOLD + "Ulecz wszystkich graczy");
            meta3.setDisplayName(ChatColor.GOLD + "BAN HAMMER");
            meta4.setDisplayName(ChatColor.GOLD + "Ustaw godzine: 6 rano.");
            meta5.setDisplayName(ChatColor.GOLD + "Ustaw godzine: 22 wieczorem.");
            meta6.setDisplayName(ChatColor.GOLD + "Ustaw pogode: Sloneczna");
            meta7.setDisplayName(ChatColor.GOLD + "Rozdaj wszystkim 1 talon.");
            meta8.setDisplayName(ChatColor.GOLD + "Przeladuj serwer.");

            ArrayList<String> osiem = new ArrayList<String>();
       		osiem.add(" ");
        	osiem.add(ChatColor.GOLD + "Ta opcja wykona ponizsze czynnosci:");
        	osiem.add(ChatColor.GOLD + "-" + ChatColor.GRAY + " odswiezy ustawienia serwera, plug-inow.");
        	osiem.add(ChatColor.GOLD + "-" + ChatColor.GRAY + " zresetuje chunki oraz ewentualne lagi serwera.");
        	osiem.add(ChatColor.GOLD + "-" + ChatColor.GRAY + " usunie bugi wykonane przez serwer.");
        	osiem.add(ChatColor.GOLD + "-" + ChatColor.GRAY + " odswiezy polaczenie HTTP oraz DNS.");
        	osiem.add(ChatColor.GOLD + "-" + ChatColor.GRAY + " zresetuje polaczenie z baza danych.");
        	osiem.add(" ");
        	osiem.add(ChatColor.DARK_GRAY + "Dostep do tej funkcji ma jedynie: " + ChatColor.GRAY + "DeMoNeK_");

        	meta8.setLore(osiem);
            
            slot0.setItemMeta(meta0);
            slot1.setItemMeta(meta1);
            slot2.setItemMeta(meta2);
            slot3.setItemMeta(meta3);
            slot4.setItemMeta(meta4);
            slot5.setItemMeta(meta5);
            slot6.setItemMeta(meta6);
            slot7.setItemMeta(meta7);
            slot8.setItemMeta(meta8);
            
            Inventory x104 = Bukkit.createInventory(null, 9, "XavernusRPG Menu");
            
            x104.setItem(0, slot0);
            x104.setItem(1, slot1);
            x104.setItem(2, slot2);
            x104.setItem(3, slot3);
            x104.setItem(4, slot4);
            x104.setItem(5, slot5);
            x104.setItem(6, slot6);
            x104.setItem(7, slot7);
            x104.setItem(8, slot8);
            
            p.openInventory(x104);
            eve.setCancelled(true);
          }
        }
      }
      
      @EventHandler
      public void onCmd(PlayerCommandPreprocessEvent e)
      {
        Player p = e.getPlayer();
        if (getServer().getHelpMap().getHelpTopic(e.getMessage().split(" ")[0]) == null)
        {
          e.setCancelled(true);
          ChatUtil.sendActionBar(p, ChatUtil.fixColor("&cPodane polecenie nie istnieje!"));
        }
      }
      
      @EventHandler
      public void ClickListener(InventoryClickEvent cevent)
      {
        Player por = (Player)cevent.getWhoClicked();
        if (por.hasPermission("xavernusrpg.menu"))
        {
          if (cevent.getInventory().getName() == "Twoja postac")
          {
        	cevent.setCancelled(true);
            if (cevent.getSlot() == 0)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              cevent.setCancelled(true);
              pl.chat(Main.this.getConfig().getString("postac.one.command"));
            }
            if (cevent.getSlot() == 1)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              cevent.setCancelled(true);
              pl.chat(Main.this.getConfig().getString("postac.two.command"));
            }
            if (cevent.getSlot() == 2)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              cevent.setCancelled(true);
              pl.chat(Main.this.getConfig().getString("postac.three.command"));
            }
            if (cevent.getSlot() == 3)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              cevent.setCancelled(true);
              pl.chat(Main.this.getConfig().getString("postac.four.command"));
            }
            if (cevent.getSlot() == 4)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              pl.chat(Main.this.getConfig().getString("postac.five.command"));
            }
            if (cevent.getSlot() == 5)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              cevent.setCancelled(true);
              pl.chat(Main.this.getConfig().getString("postac.six.command"));
            }
            if (cevent.getSlot() == 6)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              cevent.setCancelled(true);
              pl.chat(Main.this.getConfig().getString("postac.seven.command"));
            }
            if (cevent.getSlot() == 7)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              cevent.setCancelled(true);
              pl.chat(Main.this.getConfig().getString("postac.eight.command"));
            }
            if (cevent.getSlot() == 8)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              cevent.setCancelled(true);
              pl.chat(Main.this.getConfig().getString("postac.nine.command"));
            }
          }
          if (cevent.getInventory().getName() == "XavernusRPG Menu")
          {
            if (cevent.getSlot() == 0)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              pl.sendMessage(ChatColor.GOLD + "Ustawiono tryb kreatywny.");
              pl.setGameMode(GameMode.CREATIVE);
              System.out.println("[XavernusRPG]" + pl.getDisplayName() + " ustawil sobie tryb kreatywny.");
            }
            if (cevent.getSlot() == 1)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              pl.sendMessage(ChatColor.GOLD + "Ustawiono tryb survivalowy.");
              pl.setGameMode(GameMode.SURVIVAL);
              System.out.println("[XavernusRPG]" + pl.getDisplayName() + " ustawil sobie tryb survivalowy.");
            }
            if (cevent.getSlot() == 2)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              pl.sendMessage(ChatColor.GOLD + "Uleczyles wszystkich graczy!");
              pl.setHealth(20);
              for (Player p : Bukkit.getOnlinePlayers()) {
            	  p.setHealth(20);
            	  p.sendMessage(ChatColor.GOLD + "Zycie twojej postaci zostalo zregenerowane.");
              }
              System.out.println("[XavernusRPG]" + pl.getDisplayName() + " uleczyl wszystkich graczy.");
            }
            if (cevent.getSlot() == 3)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              Inventory target = pl.getInventory();
              ItemStack mastersword = new ItemStack(Material.DIAMOND_SWORD, 1);
              
              mastersword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
              mastersword.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 10);
              mastersword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
              ItemMeta mm = mastersword.getItemMeta();
              mm.setDisplayName(ChatColor.YELLOW + "BAN HAMMER " + ChatColor.GRAY + ChatColor.ITALIC + "+10 ataku");
              mastersword.setItemMeta(mm);
              target.addItem(new ItemStack[] { mastersword });
              System.out.println("[XavernusRPG]" + pl.getDisplayName() + " przywowal BAN HAMMERA.");
            }
            if (cevent.getSlot() == 4)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              pl.sendMessage(ChatColor.GOLD + "Abra kadabra, niech wstanie dzien!");
              pl.getWorld().setTime(0L);
              System.out.println("[XavernusRPG]" + pl.getDisplayName() + " ustawil pore dnia na 6 rano.");
            }
            if (cevent.getSlot() == 5)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              pl.sendMessage(ChatColor.GOLD + "Zzz... noc!");
              pl.getWorld().setTime(21000L);
              System.out.println("[XavernusRPG]" + pl.getDisplayName() + " ustawil pore dnia na 22 wieczorem.");
            }
            if (cevent.getSlot() == 6)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              pl.sendMessage(ChatColor.GOLD + "Slonce, takk slonce.");
              System.out.println("[XavernusRPG]" + pl.getDisplayName() + " ustawil sloneczna pogode.");
              pl.getWorld().setStorm(false);
            }
            if (cevent.getSlot() == 7)
            {
              Player pl = (Player)cevent.getWhoClicked();
              pl.closeInventory();
              pl.sendMessage(ChatColor.GOLD + "Rozdales wszystkim graczom, 1 talon!");
              System.out.println("[XavernusRPG]" + pl.getDisplayName() + " ustawil deszczowa pogode.");
              for (Player p : Bukkit.getOnlinePlayers())
              {
            	  p.sendMessage(ChatColor.GOLD + "Otrzymales 1 talon od " + ChatColor.GRAY +  pl.getName() + ChatColor.GOLD + " podziekuj ladnie.");
            	  
                  Inventory target = p.getInventory();
                  ItemStack talon = new ItemStack(Material.GOLD_INGOT, 1);
                  
                  ItemMeta mm = talon.getItemMeta();
                  mm.setDisplayName(ChatColor.GOLD + "Talon " + ChatColor.GRAY + ChatColor.ITALIC + "na kurwe i balon.");
                  talon.setItemMeta(mm);
                  target.addItem(new ItemStack[] { talon });
              }
            }
            if (cevent.getSlot() == 8)
            {
              Player pl = (Player)cevent.getWhoClicked();
              if (pl.hasPermission("xavernusrpg.reload"))
              {
                pl.closeInventory();
                System.out.println("[XavernusRPG]" + pl.getDisplayName() + " przeladowal serwer.");
                pl.sendMessage(ChatColor.GOLD + "Trwa przeladowywanie serwera...");
                Bukkit.reload();
              } 
              else 
              {
                pl.closeInventory();
                pl.sendMessage(ChatColor.RED + "Nie posiadasz uprawnien aby wykonac ta czynnosc.");
              }
            }
          }
        }
      }
    }, this);
  }
  
  public void onDisable()
  {
    System.out.println("[XavernusRPG] Wylaczanie glownego pluginu.");
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if ((sender instanceof Player))
    {
      Player p = (Player)sender;
      if (((cmd.getName().equals("zadanie")) || ((cmd.getName().equals("pomoc"))
    		  || ((cmd.getName().equals("postac"))
    		  || ((cmd.getName().equals("misja"))) && 
        (p.hasPermission("xavernusrpg.menu"))))))
      {
          ItemStack slot0 = new ItemStack(Material.IRON_SWORD, 1);
          ItemStack slot1 = new ItemStack(Material.DIAMOND_BOOTS, 1);
          ItemStack slot2 = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
          ItemStack slot3 = new ItemStack(Material.REDSTONE, 1);
          ItemStack slot4 = new ItemStack(Material.BARRIER, 1);
          ItemStack slot5 = new ItemStack(Material.BARRIER, 1);
          ItemStack slot6 = new ItemStack(Material.PAPER, 1);
          ItemStack slot7 = new ItemStack(Material.BARRIER, 1);
          ItemStack slot8 = new ItemStack(Material.BOOK, 1);
          
 
        
        ItemMeta meta0 = slot0.getItemMeta();
        
        ItemMeta meta1 = slot1.getItemMeta();
        ItemMeta meta2 = slot2.getItemMeta();
        ItemMeta meta3 = slot3.getItemMeta();
        ItemMeta meta4 = slot4.getItemMeta();
        ItemMeta meta5 = slot5.getItemMeta();
        ItemMeta meta6 = slot6.getItemMeta();
        
        ItemMeta meta7 = slot7.getItemMeta();
        ItemMeta meta8 = slot8.getItemMeta();
        
        meta0.setDisplayName(ChatColor.GOLD + getConfig().getString("postac.one.title"));
        meta1.setDisplayName(ChatColor.GOLD + getConfig().getString("postac.two.title"));
        meta2.setDisplayName(ChatColor.GOLD + getConfig().getString("postac.three.title"));
        meta3.setDisplayName(ChatColor.GOLD + getConfig().getString("postac.four.title"));
        meta4.setDisplayName(ChatColor.GOLD + getConfig().getString("postac.five.title"));
        meta5.setDisplayName(ChatColor.GOLD + getConfig().getString("postac.six.title"));
        meta6.setDisplayName(ChatColor.GOLD + getConfig().getString("postac.seven.title"));
        meta7.setDisplayName(ChatColor.GOLD + getConfig().getString("postac.eight.title"));
        meta8.setDisplayName(ChatColor.GOLD + getConfig().getString("postac.nine.title"));
        
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(" ");
        lore.add(ChatColor.GOLD + "Zabitych potworow: " + ChatColor.GRAY + "0");
        lore.add(ChatColor.GOLD + "Zabitych bossow: " + ChatColor.GRAY + "0");
        lore.add(ChatColor.GOLD + "Zabitych ludzi: " + ChatColor.GRAY + "0");
        lore.add(ChatColor.GOLD + "Wykonanych zadan: " + ChatColor.GRAY + "0");
        lore.add(ChatColor.GOLD + "Otrzymanych talonow: " + ChatColor.GRAY + "0");
        
        ArrayList<String> zadania = new ArrayList<String>();
        zadania.add(" ");
        zadania.add(ChatColor.GOLD + "Aktualne zadanie: " + ChatColor.GRAY + "Porozmawiaj z Tomaszem w karczmie");
        zadania.add(ChatColor.GOLD + "Postep: " + ChatColor.GRAY + "0%");
        zadania.add(ChatColor.GOLD + "Nagroda: " + ChatColor.GRAY + "10 exp");
        zadania.add(ChatColor.GOLD + "Trudnosc: " + ChatColor.GREEN + "latwe");
        zadania.add(ChatColor.GOLD + "Nastepne zadanie: " + ChatColor.GRAY + "-");

            ArrayList<String> sila = new ArrayList<String>();
            sila.add(" ");
            sila.add(ChatColor.GOLD + "Aktualny poziom sily: " + ChatColor.GRAY + "1/15");

            ArrayList<String> zwinnosc = new ArrayList<String>();
            zwinnosc.add(" ");
            zwinnosc.add(ChatColor.GOLD + "Aktualny poziom zwinnosci: " + ChatColor.GRAY + "1/15");

            ArrayList<String> obrona = new ArrayList<String>();
            obrona.add(" ");
            obrona.add(ChatColor.GOLD + "Aktualny poziom obrony: " + ChatColor.GRAY + "1/15");

            ArrayList<String> zdrowie = new ArrayList<String>();
            zdrowie.add(" ");
            zdrowie.add(ChatColor.GOLD + "Aktualny poziom zdrowia: " + ChatColor.GRAY + "1/20");
            zdrowie.add(" ");
            zdrowie.add(ChatColor.RED + "â– " + ChatColor.GRAY + "â– â– â– â– â– â– â– â– â– â– â– â– â– â– â– â– â– â– â– ");
            zdrowie.add(ChatColor.DARK_GRAY + "Chcialbys zwiekszyc poziom zdrowia? Zdobadz amulet zdrowia.");

            meta0.setLore(sila);
            meta1.setLore(zwinnosc);
            meta2.setLore(obrona);
            meta3.setLore(zdrowie);
        
        meta8.setLore(lore);
        meta6.setLore(zadania);
        
        slot0.setItemMeta(meta0);
        slot1.setItemMeta(meta1);
        slot2.setItemMeta(meta2);
        slot3.setItemMeta(meta3);
        slot4.setItemMeta(meta4);
        slot5.setItemMeta(meta5);
        slot6.setItemMeta(meta6);
        slot7.setItemMeta(meta7);
        slot8.setItemMeta(meta8);
        
        Inventory x104 = Bukkit.createInventory(null, 9, "Twoja postac");
        
        x104.setItem(0, slot0);
        x104.setItem(1, slot1);
        x104.setItem(2, slot2);
        x104.setItem(3, slot3);
        //x104.setItem(4, slot4);
        x104.setItem(5, slot5);
        x104.setItem(6, slot6);
        x104.setItem(7, slot7);
        x104.setItem(8, slot8);
        
        p.openInventory(x104);
      }
      if ((cmd.getName().equalsIgnoreCase("menu")) && 
        (p.hasPermission("xavernusrpg.menu")))
      {
          ItemStack slot0 = new ItemStack(Material.IRON_PICKAXE, 1);
          ItemStack slot1 = new ItemStack(Material.WOOD_PICKAXE, 1);
          ItemStack slot2 = new ItemStack(Material.GOLDEN_APPLE, 1);
          ItemStack slot3 = new ItemStack(Material.BLAZE_ROD, 1);
          ItemStack slot4 = new ItemStack(Material.HAY_BLOCK, 1);
          ItemStack slot5 = new ItemStack(Material.COAL_BLOCK, 1);
          ItemStack slot6 = new ItemStack(Material.GLOWSTONE_DUST, 1);
          ItemStack slot7 = new ItemStack(Material.GOLD_INGOT, 1);
          ItemStack slot8 = new ItemStack(Material.BARRIER, 1);
         
        
        ItemMeta meta0 = slot0.getItemMeta();
        
        ItemMeta meta1 = slot1.getItemMeta();
        ItemMeta meta2 = slot2.getItemMeta();
        ItemMeta meta3 = slot3.getItemMeta();
        ItemMeta meta4 = slot4.getItemMeta();
        ItemMeta meta5 = slot5.getItemMeta();
        ItemMeta meta6 = slot6.getItemMeta();
        
        ItemMeta meta7 = slot7.getItemMeta();
        ItemMeta meta8 = slot8.getItemMeta();
        
        meta0.setDisplayName(ChatColor.GOLD + "Tryb gry: Kreatywny");
        meta1.setDisplayName(ChatColor.GOLD + "Tryb gry: Survivalowy");
        meta2.setDisplayName(ChatColor.GOLD + "Ulecz wszystkich graczy");
        meta3.setDisplayName(ChatColor.GOLD + "BAN HAMMER");
        meta4.setDisplayName(ChatColor.GOLD + "Ustaw godzine: 6 rano.");
        meta5.setDisplayName(ChatColor.GOLD + "Ustaw godzine: 22 wieczorem.");
        meta6.setDisplayName(ChatColor.GOLD + "Ustaw pogode: Sloneczna");
        meta7.setDisplayName(ChatColor.GOLD + "Rozdaj wszystkim 1 talon.");
        meta8.setDisplayName(ChatColor.GOLD + "Przeladuj serwer.");

        ArrayList<String> osiem = new ArrayList<String>();
        osiem.add(" ");
        osiem.add(ChatColor.GOLD + "Ta opcja wykona ponizsze czynnosci:");
        osiem.add(ChatColor.GOLD + "-" + ChatColor.GRAY + " odswiezy ustawienia serwera, plug-inow.");
        osiem.add(ChatColor.GOLD + "-" + ChatColor.GRAY + " zresetuje chunki oraz ewentualne lagi serwera.");
        osiem.add(ChatColor.GOLD + "-" + ChatColor.GRAY + " usunie bugi wykonane przez serwer.");
        osiem.add(ChatColor.GOLD + "-" + ChatColor.GRAY + " odswiezy polaczenie HTTP oraz DNS.");
        osiem.add(ChatColor.GOLD + "-" + ChatColor.GRAY + " zresetuje polaczenie z baza danych.");
        osiem.add(" ");
        osiem.add(ChatColor.DARK_GRAY + "Dostep do tej funkcji ma jedynie: " + ChatColor.GRAY + "DeMoNeK_");

        meta8.setLore(osiem);
        
        slot0.setItemMeta(meta0);
        slot1.setItemMeta(meta1);
        slot2.setItemMeta(meta2);
        slot3.setItemMeta(meta3);
        slot4.setItemMeta(meta4);
        slot5.setItemMeta(meta5);
        slot6.setItemMeta(meta6);
        slot7.setItemMeta(meta7);
        slot8.setItemMeta(meta8);
        
        Inventory x104 = Bukkit.createInventory(null, 9, "XavernusRPG Menu");
        
        x104.setItem(0, slot0);
        x104.setItem(1, slot1);
        x104.setItem(2, slot2);
        x104.setItem(3, slot3);
        x104.setItem(4, slot4);
        x104.setItem(5, slot5);
        x104.setItem(6, slot6);
        x104.setItem(7, slot7);
        x104.setItem(8, slot8);
        
        p.openInventory(x104);
      }
    }
    return true;
  }
 
}

