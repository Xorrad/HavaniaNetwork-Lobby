package net.havania.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EntitySpawnEvent implements Listener {
	
	@EventHandler
	public void onSpawn(org.bukkit.event.entity.EntitySpawnEvent e)
	{
		e.setCancelled(true);
	}

}
