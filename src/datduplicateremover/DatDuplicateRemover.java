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

package datduplicateremover;

import org.bukkit.plugin.java.JavaPlugin;

import datduplicateremover.commands.Commands;
import datduplicateremover.listeners.LoginListener;
import datduplicateremover.storage.RealPlayersStorage;

public class DatDuplicateRemover extends JavaPlugin {

	private static DatDuplicateRemover instance;
	public static DatDuplicateRemover getInstance() {
		return instance;
	}

	private RealPlayersStorage storage;
	public RealPlayersStorage getRealPlayersStorage() {
		return storage;
	}

	@Override
	public void onEnable() {
		instance = this;
		MLogger.init(this);
		storage = new RealPlayersStorage();
		getCommand("dremove").setExecutor(new Commands());
		getServer().getPluginManager().registerEvents(new LoginListener(), this);
	}

	@Override
	public void onDisable() {
		instance = null;
	}

}
