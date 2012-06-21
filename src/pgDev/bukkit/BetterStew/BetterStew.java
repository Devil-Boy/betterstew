package pgDev.bukkit.BetterStew;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BetterStew extends JavaPlugin {
	
	BSMainListener mainListener = new BSMainListener(this);
	
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(mainListener, this);
		
		PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
	}
	
	public void onDisable() {
		System.out.println("BetterStew disabled!");
	}
}