package duplicateremover;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.bukkit.OfflinePlayer;

public class RealPlayersContainer {

	private HashMap<String, OfflinePlayer> realplayers = new HashMap<String, OfflinePlayer>();

	public void gatherRealPlayersList() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (File file : PlayersDataUtils.getPlayersFiles()) {
			String nickname = PlayersDataUtils.getPlayerName(file);
			if (nickname != null) {
				OfflinePlayer offplayer = PlayersDataUtils.getOffilePlayer(nickname);
				String offplayername = offplayer.getName();
				if (realplayers.containsKey(offplayer.getName())) {
					OfflinePlayer prevpl = realplayers.get(offplayer.getName());
					if (prevpl.getLastPlayed() < offplayer.getLastPlayed()) {
						realplayers.put(offplayername, offplayer);
					}
				} else {
					realplayers.put(offplayername, offplayer);
				}
			}
		}
	}

	public boolean isPlayerReal(String plname) {
		return realplayers.containsKey(plname);
	}

}
