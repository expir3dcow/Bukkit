package com.expir3dcow.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PVP {
	@SuppressWarnings("deprecation")
	public PVP(Player p){
		p.setHealth(20);
		p.setFoodLevel(20);
		p.sendMessage(ChatColor.GREEN+"You chose the PVP kit!");
		p.getInventory().setItem(0, new ItemStack(Material.DIAMOND_SWORD, 1));
		
		for(int i = 1; i <27+9;i++){
			p.getInventory().setItem(i,new ItemStack(Material.MUSHROOM_SOUP,1) );
		}
		ItemStack[] armour = {new ItemStack(Material.DIAMOND_HELMET),new ItemStack(Material.DIAMOND_CHESTPLATE),new ItemStack(Material.DIAMOND_LEGGINGS), new ItemStack(Material.DIAMOND_BOOTS) };
		p.getInventory().setHelmet(armour[0]);
		p.getInventory().setChestplate(armour[1]);
		p.getInventory().setLeggings(armour[2]);
		p.getInventory().setBoots(armour[3]);
	}
}
