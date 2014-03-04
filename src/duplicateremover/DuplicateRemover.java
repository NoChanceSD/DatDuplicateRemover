package duplicateremover;

import org.bukkit.plugin.java.JavaPlugin;

public class DuplicateRemover extends JavaPlugin {

	@Override
	public void onEnable() {
		getCommand("dremove").setExecutor(new Commands());
	}

}
