package demonek.xavernusrpg.core.events;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import demonek.xavernusrpg.core.utils.recalculatePickaxe;

public class PlayerBlockBreakEvent implements Listener 
{
  
  @SuppressWarnings("unused")
  private int amount;
  
  public PlayerBlockBreakEvent()
  {
	this.amount = 1;  
  }
	
  @EventHandler(priority=EventPriority.MONITOR)
  public void onPlayerBreak(BlockBreakEvent e)
  {
	Player p = e.getPlayer();
	if (!(p instanceof Player))
	{
	  return;	  
	}
	
	if (e.getBlock().getType() == Material.COBBLESTONE)
	{
	  if (e.isCancelled())
	  {
		e.setCancelled(true);  
	  }
	  
	  if (p.getGameMode() == GameMode.SURVIVAL)
	  {
		e.getPlayer().getItemInHand().setDurability(e.getPlayer().getItemInHand().getDurability());
		recalculatePickaxe.recalculateDurability(e.getPlayer(), e.getPlayer().getItemInHand());
		
		e.getBlock().setType(Material.COBBLESTONE);
		
		ItemStack cobble = new ItemStack(Material.COBBLESTONE);
		HashMap<Integer, ItemStack> not = p.getInventory().addItem(new ItemStack[] { cobble });
		
		if (!(not.isEmpty()))
		{
		  e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), cobble);
		}
		
		if (p.getItemInHand().getType() == Material.WOOD_PICKAXE)
		{
		  Map<Enchantment, Integer> enchant = p.getItemInHand().getEnchantments();
		  if (enchant.containsKey(Enchantment.LOOT_BONUS_BLOCKS))
		  {
			if (p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1)
			{
			  this.amount = randomAmount(2);
			  p.giveExp(1);
			}
		  }
		}
	  }
	}
  }
  
  public static int randomAmount(int max)
  {
    Random rand = new Random();
    int number = rand.nextInt(max) + 1;
    return number;
  }
}
