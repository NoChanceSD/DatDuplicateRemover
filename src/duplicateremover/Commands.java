package duplicateremover;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.RemoteConsoleCommandSender;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender || sender instanceof RemoteConsoleCommandSender) {
			new RemoveThread().start();
			sender.sendMessage(ChatColor.BLUE + "Players data duplicates removing started");
			return true;
		}
		return false;
	}

}
