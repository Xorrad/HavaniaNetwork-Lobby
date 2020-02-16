package net.havania.lobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import net.havania.lobby.utils.GuiUtils;

public class PlayerInteract implements Listener {
	
	@EventHandler
	public void onClick(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		{
			if(e.getItem() == null || e.getItem().getItemMeta() == null || e.getItem().getItemMeta().getDisplayName() == null)
			{
				return;
			}
			
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eMenu des jeux"))
			{
				GuiUtils.openMainMenu(p);
			}
		}
	}

}
