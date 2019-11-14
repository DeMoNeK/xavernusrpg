package demonek.xavernusrpg.core.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityEvent implements Listener
{
  @EventHandler
  public void onEntityExplode(EntityExplodeEvent e)
  {
	e.setCancelled(true);
  }
}
