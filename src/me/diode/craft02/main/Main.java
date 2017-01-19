package me.diode.craft02.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.diode.craft02.cmds.BuildCMD;
import me.diode.craft02.cmds.FlyCMD;
import me.diode.craft02.cmds.SetCMD;
import me.diode.craft02.listeners.BuildListener;
import me.diode.craft02.listeners.DamageListener;
import me.diode.craft02.listeners.DisablerListener;
import me.diode.craft02.listeners.FeedListener;
import me.diode.craft02.listeners.InteractListener;
import me.diode.craft02.listeners.InventoryClickListener;
import me.diode.craft02.listeners.JoinListener;
import me.diode.craft02.listeners.QuitListener;
import me.diode.craft02.utils.Settings;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class Main extends JavaPlugin{
	
	public static String prefix = "§6[§5Ender§bCraft§6] §a";
	public static String noperm = prefix + "Keine Rechte!";
	int automsg = 1;
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§eName: §c§l" + getDescription().getName());
		Bukkit.getConsoleSender().sendMessage("§eVersion: §c§l" + getDescription().getVersion());
		Bukkit.getConsoleSender().sendMessage("§eErsteller: §c§l" + getDescription().getAuthors());
		Bukkit.getConsoleSender().sendMessage("§ePlugin aktiviert...");
		
		if(Settings.getSettings() == false) {
			
			Settings.createSettings();
			
		}
		
		register();
		autoMsg();
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§eName: §c§l" + getDescription().getName());
		Bukkit.getConsoleSender().sendMessage("§eVersion: §c§l" + getDescription().getVersion());
		Bukkit.getConsoleSender().sendMessage("§eErsteller: §c§l" + getDescription().getAuthors());
		Bukkit.getConsoleSender().sendMessage("§ePlugin wird deaktiviert...");
	}
	
	private void register() {
		Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new QuitListener(), this);
		Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
		Bukkit.getPluginManager().registerEvents(new FeedListener(), this);
		Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
		Bukkit.getPluginManager().registerEvents(new DisablerListener(), this);
		Bukkit.getPluginManager().registerEvents(new BuildListener(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
		getCommand("fly").setExecutor(new FlyCMD());
		getCommand("build").setExecutor(new BuildCMD());
		getCommand("set").setExecutor(new SetCMD());
	}
	
	File ordner = new File("plugins//EnderCraft02-LobbySystem");
	File file = new File("plugins//EnderCraft02-LobbySystem//settings.yml");
	
	YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	private void autoMsg() {
		Bukkit.getScheduler().runTaskTimerAsynchronously(this, new Runnable() {
		public void run() {
		         switch (Main.this.automsg) {
		/*     */         case 1: 
			                for(Player all : Bukkit.getOnlinePlayers()) {
			                	sendActionBar(all, cfg.getString("ActionbarMessage1.Nachricht").replaceAll("&", "§"));
			                }
		/* 210 */           break;
		/*     */         case 2: 
            for(Player all : Bukkit.getOnlinePlayers()) {
            	sendActionBar(all, cfg.getString("ActionbarMessage2.Nachricht").replaceAll("&", "§"));
            }
/* 210 */           break;
		/*     */         default: 
            for(Player all : Bukkit.getOnlinePlayers()) {
            	sendActionBar(all, cfg.getString("ActionbarMessage3.Nachricht").replaceAll("&", "§"));
            }
/* 210 */           break;
		/*     */         }
		/*     */         
		/* 228 */         Main.this.automsg += 1;
		                  if(automsg == 4) {
		                	  automsg = 1;
		                  }
		/*     */       }
		/*     */       
		/* 231 */     }, 40, 40);
		/*     */   }
	
	/*     */   public static void sendActionBar(Player player, String Nachricht)
	/*     */   {
	/* 104 */     String NachrichtNeu = Nachricht.replace("_", " ");
	/* 105 */     String s = ChatColor.translateAlternateColorCodes('&', NachrichtNeu);
	/* 106 */     IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + s + 
	/* 107 */       "\"}");
	/* 108 */     PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
	/* 109 */     ((CraftPlayer)player).getHandle().playerConnection.sendPacket(bar);
	/*     */   }
	
	

}
