package com.expir3dcow.GUI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class KitGUI extends JavaPlugin implements Listener {
	public Inventory inv;
	
	
	public void onEnable(){
		this.getServer().getPluginManager().registerEvents(this, this);
		}
	
	
	
	public void openGUI(Player p){
	    inv = Bukkit.createInventory(null, 9, "Kit GUI");
	    inv.setItem(0, new ItemStack(Material.DIAMOND) );
	    p.openInventory(inv);
	}
	
	
	
	
	 @EventHandler
	    public void InventoryClick(InventoryClickEvent e){
	        Player p = (Player) e.getWhoClicked();  

	        if(e.getInventory().getTitle().contains("Kit GUI")){
	            e.setCancelled(true);

	            if(e.getCurrentItem() == null){
	                return;
	            }
	            else if(e.getCurrentItem().getType() == Material.DIAMOND){
	            p.sendMessage("You clicked the diamond!");
	            p.closeInventory();
	            }
	       }
	  }
	 
	
	 
	 
	 @Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	 	if (cmd.getName().equalsIgnoreCase("kits")) {
	 		openGUI( (Player)sender);
	 		return true;
	 		}
	 	return true;
	 }
	 
}
