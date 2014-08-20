/**
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 */

package datduplicateremover.commands;

import org.bukkit.OfflinePlayer;

import datduplicateremover.DatDuplicateRemover;
import datduplicateremover.MLogger;
import datduplicateremover.storage.PlayersDataUtils;

public class RemoveThread extends Thread {

	@Override
	public void run() {
		MLogger.log("Players data duplicates removing started");
		for (OfflinePlayer player : PlayersDataUtils.getPlayers()) {
			if (!DatDuplicateRemover.getInstance().getRealPlayersStorage().isPlayerReal(player)) {
				MLogger.log("Removing duplicate "+player.getName());
				PlayersDataUtils.getPlayerFile(player).delete();
			}
		}
		MLogger.log("Players data duplicates removing finished");
	}

}
