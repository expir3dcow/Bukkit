package com.expir3dcow.launchpad;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
//import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
//import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class LaunchPad extends JavaPlugin implements Listener{
	//Array of who is jumping.
	private ArrayList<Player> jumpers = new ArrayList<Player>();
	public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
}
	@SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE) {
			
			
			
			for (Player player: Bukkit.getServer().getOnlinePlayers()) {
			    if (player.hasPermission("spongman.kick")) {
			        player.sendMessage("You were sent a message");

			
			
			
		Vector velocity = null;	   
		Location loc = e.getPlayer().getLocation();
		int xLaunchers=0;
		int yLaunchers=0;
		int zLaunchers=0;
		
		//Y
		for(int x = 0; x<20; x++){
			Block block =new Location(loc.getWorld(),loc.getBlockX(),loc.getBlockY()-x,loc.getBlockZ()).getBlock();
			if(block.getRelative(BlockFace.DOWN).getType()==Material.SPONGE){
				yLaunchers ++;
			}
			
		}
		
		//X
		for(int i = 0; i<20; i++){
			Block block =new Location(loc.getWorld(),loc.getBlockX()-i,loc.getBlockY(),loc.getBlockZ()).getBlock();
			if(block.getRelative(BlockFace.DOWN).getType()==Material.SPONGE){
				xLaunchers ++;
			}
			
		}
		//X
		for(int i = 0; i<20; i++){
			Block block =new Location(loc.getWorld(),loc.getBlockX()+i,loc.getBlockY(),loc.getBlockZ()).getBlock();
			if(block.getRelative(BlockFace.DOWN).getType()==Material.SPONGE){
				xLaunchers --;
			}
			
		}
		
		
		//Z
		for(int i = 0; i<20; i++){
			Block block =new Location(loc.getWorld(),loc.getBlockX(),loc.getBlockY(),loc.getBlockZ()-i).getBlock();
			if(block.getRelative(BlockFace.DOWN).getType()==Material.SPONGE){
				zLaunchers ++;
			}
			
		}
		//Z
		for(int i = 0; i<20; i++){
			Block block =new Location(loc.getWorld(),loc.getBlockX(),loc.getBlockY(),loc.getBlockZ()+i).getBlock();
			if(block.getRelative(BlockFace.DOWN).getType()==Material.SPONGE){
				zLaunchers --;
			}
			
		}
		
		
		
		
		
		velocity = new Vector(xLaunchers,yLaunchers,zLaunchers);
		
		if(velocity!=null){
			e.getPlayer().setVelocity(velocity);
			jumpers.add(e.getPlayer());
		}
	}
}
	

		}
		}
			
			
			
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
            if (e.getEntity() instanceof Player) {
                    Player p = (Player) e.getEntity();
                    if (e.getCause() == DamageCause.FALL && jumpers.contains(p)) {
                    	 e.setCancelled(true);//<- cancels the entity damaged event
                    	 p.setFallDistance(0);
                            jumpers.remove(p);
                    }
            }
    }
	
	
}
