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

package datduplicateremover.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import datduplicateremover.DatDuplicateRemover;
import datduplicateremover.storage.RealPlayersStorage;

public class LoginListener implements Listener {

	@EventHandler(priority=EventPriority.LOWEST,ignoreCancelled=true)
	public void onPlayerLogin(PlayerLoginEvent event) {
		if (event.getResult() != Result.ALLOWED) {
			return;
		}
		RealPlayersStorage storage = DatDuplicateRemover.getInstance().getRealPlayersStorage();
		if (!storage.hasRealPlayer(event.getPlayer())) {
			storage.addRealPlayer(event.getPlayer());
			return;
		}
		if (!storage.isPlayerReal(event.getPlayer())) {
			event.disallow(Result.KICK_OTHER, ChatColor.DARK_RED+"Invalid case in player name. " + ChatColor.RESET+"Please spell you name correctly: "+ChatColor.GOLD+storage.getRealPlayerValidName(event.getPlayer()));
		}
	}

}
