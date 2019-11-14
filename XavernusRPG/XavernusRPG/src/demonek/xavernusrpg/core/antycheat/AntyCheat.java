package demonek.xavernusrpg.core.antycheat;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import demonek.xavernusrpg.core.Main;
import demonek.xavernusrpg.core.utils.ChatUtil;

public class AntyCheat
  implements Listener
{
  public ArrayList<Player> uderzenie = new ArrayList<Player>();
  public ArrayList<Player> aura = new ArrayList<Player>();
  public ArrayList<Player> odleglosc = new ArrayList<Player>();
  
  @SuppressWarnings("unlikely-arg-type")
@EventHandler(priority=EventPriority.MONITOR)
  public void przyUderzeniu(EntityDamageByEntityEvent e)
  {
    if ((e.getDamager() instanceof Player))
    {
      final Player p = (Player)e.getDamager();
      if (!p.getItemInHand().equals(Material.BOW)) {
        if (e.getEntity().getLocation().distance(p.getLocation()) < 5.0D)
        {
          if (p.getItemInHand().equals(Material.BOW)) {
            if (!this.uderzenie.contains(p))
            {
              this.uderzenie.add(p);
              Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInst(), new Runnable()
              {
                public void run()
                {
                  AntyCheat.this.uderzenie.remove(p);
                }
              }, 2L);
            }
            else if (!this.aura.contains(p))
            {
              for (Player admini : Bukkit.getOnlinePlayers())
              {
                if ((admini.hasPermission("xavernusrpg.antycheat")) || (admini.isOp()))
                {
                  this.aura.add(p);
                  admini.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1.0F, 1.0F);
                  admini.sendMessage(ChatUtil.fixColor("&6XavernusRPG &7|&eAC&7|: &6" + p.getDisplayName() + "&6Wykryto: &7KillAure"));
                  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInst(), new Runnable()
                  {
                    public void run()
                    {
                      AntyCheat.this.aura.remove(p);
                    }
                  }, 200L);
                }
              }
            }
          }
        }
        else if (!this.odleglosc.contains(p))
        {
          for (Player admini : Bukkit.getOnlinePlayers())
          {
            if ((admini.hasPermission("xavernusrpg.antycheat")) || (admini.isOp()))
            {
              this.odleglosc.add(p);
              admini.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1.0F, 1.0F);
              admini.sendMessage(ChatUtil.fixColor("&6XavernusRPG &7|&eAC&7|: &6" + p.getDisplayName() + "&6Wykryto: &7Reach"));
              Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInst(), new Runnable()
              {
                public void run()
                {
                  AntyCheat.this.odleglosc.remove(p);
                }
              }, 200L);
            }
          }
        }
      }
    }
  }
}
