package net.havania.lobby.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDrop implements Listener {
	
	@EventHandler
	public void onDamage(PlayerDropItemEvent e)
	{
		e.setCancelled(true);
	}

}
