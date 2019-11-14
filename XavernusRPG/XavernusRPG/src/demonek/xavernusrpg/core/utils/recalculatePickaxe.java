package demonek.xavernusrpg.core.utils;

import java.util.Random;

import org.apache.commons.lang.Validate;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class recalculatePickaxe
{
  private static final Random rand = new Random();
  
  public static void recalculateDurability(Player player, ItemStack item)
  {
    if (item.getType().getMaxDurability() == 0) {
      return;
    }
    int enchantLevel = item.getEnchantmentLevel(Enchantment.DURABILITY);
    short d = item.getDurability();
    if (enchantLevel > 0)
    {
      if (100 / (enchantLevel + 1) > getRandInt(0, 100)) {
        if (d == item.getType().getMaxDurability()) {
          player.getInventory().clear(player.getInventory().getHeldItemSlot());
        } else {
          item.setDurability((short)(d + 1));
        }
      }
    }
    else if (d == item.getType().getMaxDurability()) {
      player.getInventory().clear(player.getInventory().getHeldItemSlot());
    } else {
      item.setDurability((short)(d + 1));
    }
  }
  
  public static int getRandInt(int min, int max)
    throws IllegalArgumentException
  {
    Validate.isTrue(max > min, "Max can't be smaller than min!");
    return rand.nextInt(max - min + 1) + min;
  }
}
