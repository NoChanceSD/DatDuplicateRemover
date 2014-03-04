package duplicateremover;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class DuplicateRemover extends JavaPlugin {

	private static Logger log;
	
	@Override
	public void onEnable() {
		log = this.getLogger();
		getCommand("dremove").setExecutor(new Commands());
	}

	public static void log(String message) {
		if (log != null) {
			log.log(Level.INFO, message);
		}
	}

}
