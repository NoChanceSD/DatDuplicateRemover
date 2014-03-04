package duplicateremover;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class RemoveThread extends Thread {

	@Override
	public void run() {
		try {
			RealPlayersContainer playerscontainer = new RealPlayersContainer();
			playerscontainer.gatherRealPlayersList();
			for (File playerfile : PlayersDataUtils.getPlayersFiles()) {
				String nickname = PlayersDataUtils.getPlayerName(playerfile);
				if (nickname != null) {
					if (!playerscontainer.isPlayerReal(nickname)) {
						playerfile.delete();
					}
				}
			}
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
