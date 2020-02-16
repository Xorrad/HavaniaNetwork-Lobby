package net.havania.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamage implements Listener {
	
	@EventHandler
	public void onDamage(EntityDamageEvent e)
	{
		e.setCancelled(true);
	}

}
