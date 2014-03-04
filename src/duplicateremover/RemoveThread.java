package duplicateremover;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class RemoveThread extends Thread {

	@Override
	public void run() {
		try {
			DuplicateRemover.log("Players data duplicates removing started");
			RealPlayersContainer playerscontainer = new RealPlayersContainer();
			DuplicateRemover.log("Gathering real players list");
			playerscontainer.gatherRealPlayersList();
			DuplicateRemover.log("Finished gathering real players list");
			for (File playerfile : PlayersDataUtils.getPlayersFiles()) {
				String nickname = PlayersDataUtils.getPlayerName(playerfile);
				if (nickname != null) {
					if (!playerscontainer.isPlayerReal(nickname)) {
						DuplicateRemover.log("Removing duplicate "+nickname);
						playerfile.delete();
					}
				}
			}
			DuplicateRemover.log("Players data duplicates removing finished");
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
