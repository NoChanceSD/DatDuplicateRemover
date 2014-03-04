package duplicateremover;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;

public class PlayersDataUtils {

	public static File[] getPlayersFiles() {
		return getPlayersDataFolder().listFiles();
	}
	
	public static String getPlayerName(File file) {
		String filename = file.getName();
		if (filename.endsWith(".dat")) {
			return filename.substring(0, filename.length() - 4);
		}
		return null;
	}

	public static OfflinePlayer getOffilePlayer(String name) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Server server = Bukkit.getServer();
		Class<?> craftofflineplayer = Bukkit.getOfflinePlayer("fakeautopurgeplayer").getClass();
		Constructor<?> ctor = craftofflineplayer.getDeclaredConstructor(server.getClass(), String.class);
		ctor.setAccessible(true);
		return (OfflinePlayer) ctor.newInstance(server, name);
	}

	private static File getPlayersDataFolder() {
		return new File(Bukkit.getWorlds().get(0).getWorldFolder(), "players");
	}

}
