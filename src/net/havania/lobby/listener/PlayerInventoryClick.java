package net.havania.lobby.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.havania.core.Core;
import net.havania.core.utils.Server;
import net.havania.core.utils.Server.ServerStatus;
import net.havania.core.utils.Server.ServerType;
import net.havania.lobby.utils.GuiUtils;

public class PlayerInventoryClick implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e)
	{
		Player p = (Player) e.getWhoClicked();
		
		if(e.getCurrentItem() == null || e.getCurrentItem().getItemMeta() == null || e.getCurrentItem().getItemMeta().getDisplayName() == null || e.getInventory().getName() == null)
		{
			return;
		}
		
		e.setCancelled(true);
		
		if(e.getInventory().getName().equalsIgnoreCase("§eMenu des jeux")) //MAIN MENU
		{
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Rush"))
			{
				GuiUtils.openRushMenu(p);
			}
			else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§9Practice"))
			{
				GuiUtils.openPracticeMenu(p);
			}
		}
		else if(e.getInventory().getName().equalsIgnoreCase("§eMenu des jeux §7- §6Rush")) //RUSH MENU
		{
			if(e.getCurrentItem().getItemMeta().getDisplayName().contains("4x1"))
			{
				for(Server server : Core.getCore().getServersByType(ServerType.RUSH))
				{
					if(server.getName().contains("4x1"))
					{
						if(server.getStatus().equals(ServerStatus.READY))
						{
							if(server.getMaxPlayer() == -1 || server.getCurrentPlayer() < server.getMaxPlayer())
							{
								server.connectPlayer(p);
								return;
							}
						}
					}
				}
			}
			else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("4x2"))
			{
				for(Server server : Core.getCore().getServersByType(ServerType.RUSH))
				{
					if(server.getName().contains("4x2"))
					{
						if(server.getStatus().equals(ServerStatus.READY))
						{
							if(server.getMaxPlayer() == -1 || server.getCurrentPlayer() < server.getMaxPlayer())
							{
								server.connectPlayer(p);
								return;
							}
						}
					}
				}
			}
			else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("4x4"))
			{
				for(Server server : Core.getCore().getServersByType(ServerType.RUSH))
				{
					if(server.getName().contains("4x4"))
					{
						if(server.getStatus().equals(ServerStatus.READY))
						{
							if(server.getMaxPlayer() == -1 || server.getCurrentPlayer() < server.getMaxPlayer())
							{
								server.connectPlayer(p);
								return;
							}
						}
					}
				}
			}
			else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("8x2"))
			{
				for(Server server : Core.getCore().getServersByType(ServerType.RUSH))
				{
					if(server.getName().contains("8x2"))
					{
						if(server.getStatus().equals(ServerStatus.READY))
						{
							if(server.getMaxPlayer() == -1 || server.getCurrentPlayer() < server.getMaxPlayer())
							{
								server.connectPlayer(p);
								return;
							}
						}
					}
				}
			}
			else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("8x4"))
			{
				for(Server server : Core.getCore().getServersByType(ServerType.RUSH))
				{
					if(server.getName().contains("8x4"))
					{
						if(server.getStatus().equals(ServerStatus.READY))
						{
							if(server.getMaxPlayer() == -1 || server.getCurrentPlayer() < server.getMaxPlayer())
							{
								server.connectPlayer(p);
								return;
							}
						}
					}
				}
			}
			else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§7Retour"))
			{
				GuiUtils.openMainMenu(p);
				return;
			}
			
			p.sendMessage("§cAucun serveur n'est actuellement disponible !");
			p.closeInventory();
		}
		else if(e.getInventory().getName().equalsIgnoreCase("§eMenu des jeux §7- §9Practice")) //PRACTICE MENU
		{
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§9Practice EU"))
			{
				for(Server server : Core.getCore().getServersByType(ServerType.PRACTICE))
				{
					if(server.getName().contains("EU"))
					{
						if(server.getStatus().equals(ServerStatus.READY))
						{
							if(server.getMaxPlayer() == -1 || server.getCurrentPlayer() < server.getMaxPlayer())
							{
								server.connectPlayer(p);
								return;
							}
						}
					}
				}
			}
			else if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§9Practice US"))
			{
				for(Server server : Core.getCore().getServersByType(ServerType.PRACTICE))
				{
					if(server.getName().contains("US"))
					{
						if(server.getStatus().equals(ServerStatus.READY))
						{
							if(server.getMaxPlayer() == -1 || server.getCurrentPlayer() < server.getMaxPlayer())
							{
								server.connectPlayer(p);
								return;
							}
						}
					}
				}
			}
			else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§7Retour"))
			{
				GuiUtils.openMainMenu(p);
				return;
			}
			
			p.closeInventory();
			p.sendMessage("§cAucun serveur n'est actuellement disponible !");
		}
	}

}
