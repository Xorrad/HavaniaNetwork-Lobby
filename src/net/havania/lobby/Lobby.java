package net.havania.lobby;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import net.havania.core.utils.SpeedItem;
import net.havania.lobby.listener.EntitySpawnEvent;
import net.havania.lobby.listener.PlayerDamage;
import net.havania.lobby.listener.PlayerDrop;
import net.havania.lobby.listener.PlayerInteract;
import net.havania.lobby.listener.PlayerInventoryClick;
import net.havania.lobby.listener.PlayerJoin;
import net.havania.lobby.utils.GuiUtils;

public class Lobby extends JavaPlugin {
	
	static Lobby lobby;
	
	public Integer autoUpdateDelay;
	
	@Override
	public void onEnable() 
	{
		lobby = this;
		registerVariables();
		registerListeners();
		registerCommands();
		loadConfiguration();
		reloadPlayer();
		autoUpdateTask();
	}
	
	@Override
	public void onDisable() 
	{
		
	}
	
	private void registerVariables()
	{
		autoUpdateDelay = 5;
	}
	
	private void registerListeners()
	{
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerInteract(), this);
		pm.registerEvents(new PlayerInventoryClick(), this);
		pm.registerEvents(new EntitySpawnEvent(), this);
		pm.registerEvents(new PlayerDrop(), this);
		pm.registerEvents(new PlayerDamage(), this);
	}
	
	private void registerCommands()
	{
		
	}
	
	private void loadConfiguration()
	{
		saveDefaultConfig();
		
		autoUpdateDelay = this.getConfig().getInt("update-delay");
		
        this.saveConfig();
        this.reloadConfig();
	}
	
	@SuppressWarnings("deprecation")
	public void reloadPlayer()
	{
		for(Player pls : Bukkit.getOnlinePlayers())
		{
			addPlayer(pls);
		}
	}
	
	private void autoUpdateTask()
	{
		new BukkitRunnable() {
			
			@Override
			public void run() {
				GuiUtils.loadMainMenu();
				GuiUtils.loadPracticeMenu();
				GuiUtils.loadRushMenu();
			}
		}.runTaskTimer(this, autoUpdateDelay * 20L, autoUpdateDelay * 20L);
	}
	
	public static Lobby getLobby() { return lobby; }

	public void addPlayer(Player p) 
	{
		p.getInventory().clear();
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		
		for(PotionEffect pe : p.getActivePotionEffects())
		{
			p.removePotionEffect(pe.getType());
		}
		p.setHealth(20.0D);
		p.setFoodLevel(20);
		p.setFireTicks(0);
		
		p.getInventory().setItem(4, new SpeedItem(Material.COMPASS, "§eMenu des jeux"));
		
		p.updateInventory();
	}
}
