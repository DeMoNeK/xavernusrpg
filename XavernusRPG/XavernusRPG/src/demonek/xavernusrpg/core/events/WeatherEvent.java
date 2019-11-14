package demonek.xavernusrpg.core.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherEvent implements Listener
{
  @EventHandler
  public void WeatherChange(WeatherChangeEvent e)
  {
	if (e.toWeatherState())
	{
	  e.setCancelled(true);
	}
  }
}
