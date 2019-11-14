package demonek.xavernusrpg.core.events.mobs;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

@SuppressWarnings("deprecation")
public class MobLvl1 implements Listener 
{
  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent e)
  {
	Action action = e.getAction();
	Player p = e.getPlayer();
	
	if (action.equals(Action.LEFT_CLICK_BLOCK))
	{
	  Location test1 = e.getClickedBlock().getLocation().add(0.0D, 0.0D, 1.0D);
	  
      if ((test1.getBlock().getType() == Material.DIAMOND_BLOCK) && 
      (e.getClickedBlock().getType().equals(Material.WOOD_BUTTON)))
      {
    	World w = p.getWorld();
    	Location l1 = new Location(w, 0.0D, 0.0D, -1.0D); 
    	
    	w.spawnCreature(l1, CreatureType.ZOMBIE);
    	p.teleport(l1);
      }
	}
  }
}
