package net.havania.lobby.utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import net.havania.core.Core;
import net.havania.core.utils.Server;
import net.havania.core.utils.SpeedItem;
import net.havania.core.utils.Server.ServerStatus;
import net.havania.core.utils.Server.ServerType;

public class GuiUtils {
	
	public static Inventory main;
	public static Inventory rush;
	public static Inventory practice;
	
	static
	{
		main = Bukkit.createInventory(null, 6*9, "§eMenu des jeux");
		rush = Bukkit.createInventory(null, 6*9, "§eMenu des jeux §7- §6Rush");
		practice = Bukkit.createInventory(null, 6*9, "§eMenu des jeux §7- §9Practice");
		
		loadMainMenu();
		loadPracticeMenu();
		loadRushMenu();
	}
	
	public static void loadMainMenu()
	{
		main.clear();
		
		ArrayList<String> rushLores = new ArrayList<>();
		rushLores.add("§aOnline§7: " + getServersPlayers(ServerType.RUSH));
		SpeedItem rush = new SpeedItem(Material.SANDSTONE, "§6Rush", rushLores);
		
		ArrayList<String> practiceLores = new ArrayList<>();
		practiceLores.add("§aOnline§7: " + getServersPlayers(ServerType.PRACTICE));
		SpeedItem practice = new SpeedItem(Material.POTION, "§9Practice", practiceLores);
		
		main.setItem(21, rush);
		main.setItem(23, practice);
	}
	
	public static void loadPracticeMenu()
	{
		practice.clear();
		
		ArrayList<String> euLores = new ArrayList<>();
		euLores.add("§aOnline§7: " + getServersPlayersByName(ServerType.PRACTICE, "US"));
		euLores.add("§aStatus§7: " + getServersStatusByName(ServerType.PRACTICE, "EU").name());
		SpeedItem eu = new SpeedItem(Material.POTION, "§9Practice §7EU", euLores);
		
		ArrayList<String> usLores = new ArrayList<>();
		usLores.add("§aOnline§7: " + getServersPlayersByName(ServerType.PRACTICE, "US"));
		usLores.add("§aStatus§7: " + getServersStatusByName(ServerType.PRACTICE, "EU").name());
		SpeedItem us = new SpeedItem(Material.POTION, "§9Practice §cUS", usLores);
		
		SpeedItem back = new SpeedItem(Material.ARROW, "§7Retour");
		
		practice.setItem(21, eu);
		practice.setItem(23, us);
		practice.setItem(40, back); 
	}
	
	public static void loadRushMenu()
	{
		rush.clear();
		
		ArrayList<String> rush1v1Lores = new ArrayList<>();
		rush1v1Lores.add("§aOnline§7: " + getServersPlayersByName(ServerType.RUSH, "4x1"));
		SpeedItem rush1v1 = new SpeedItem(Material.SANDSTONE, "§6Rush 4x1", rush1v1Lores);
		
		ArrayList<String> rush2v2Lores = new ArrayList<>();
		rush2v2Lores.add("§aOnline§7: " + getServersPlayersByName(ServerType.RUSH, "4x2"));
		SpeedItem rush2v2 = new SpeedItem(Material.SANDSTONE, "§6Rush 4x2", rush2v2Lores);
		
		ArrayList<String> rush4v4Lores = new ArrayList<>();
		rush4v4Lores.add("§aOnline§7: " + getServersPlayersByName(ServerType.RUSH, "4x4"));
		SpeedItem rush4v4 = new SpeedItem(Material.SANDSTONE, "§6Rush 4x4", rush4v4Lores);
		
		ArrayList<String> rush2v2x8Lores = new ArrayList<>();
		rush2v2x8Lores.add("§aOnline§7: " + getServersPlayersByName(ServerType.RUSH, "8x2"));
		SpeedItem rush2v2x8 = new SpeedItem(Material.SANDSTONE, "§6Rush 8x2", rush2v2x8Lores);
		
		ArrayList<String> rush4v4x8Lores = new ArrayList<>();
		rush4v4x8Lores.add("§aOnline§7: " + getServersPlayersByName(ServerType.RUSH, "8x4"));
		SpeedItem rush4v4x8 = new SpeedItem(Material.SANDSTONE, "§6Rush 8x4", rush4v4x8Lores);
		
		SpeedItem back = new SpeedItem(Material.ARROW, "§7Retour");
		
		rush.setItem(20, rush1v1);
		rush.setItem(21, rush2v2);
		rush.setItem(22, rush4v4);
		rush.setItem(23, rush2v2x8);
		rush.setItem(24, rush4v4x8);
		rush.setItem(40, back); 
	}
	
	public static void openMainMenu(Player p)
	{
		p.openInventory(main);
	}
	
	public static void openRushMenu(Player p)
	{
		p.openInventory(rush);
	}
	
	public static void openPracticeMenu(Player p)
	{
		p.openInventory(practice);
	}
	
	public static Integer getServersPlayers(ServerType type)
	{
		Integer number = 0;
		
		for(Server server : Core.getCore().getServers().values())
		{
			if(server.getType().equals(type))
			{
				number += server.getCurrentPlayer();
			}
		}
		
		return number;
	}
	
	public static Integer getServersPlayersByName(ServerType type, String name)
	{
		Integer number = 0;
		
		for(Server server : Core.getCore().getServers().values())
		{
			if(server.getType().equals(type) && server.getName().contains(name))
			{
				number += server.getCurrentPlayer();
			}
		}
		
		return number;
	}
	
	public static ServerStatus getServersStatusByName(ServerType type, String name)
	{
		for(Server server : Core.getCore().getServers().values())
		{
			if(server.getType().equals(type) && server.getName().contains(name))
			{
				return server.getStatus();
			}
		}
		
		return ServerStatus.CLOSE;
	}

}
