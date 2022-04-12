package pw.hysteria.jobs.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pw.hysteria.jobs.framework.JobType;
import pw.hysteria.jobs.PlayerProfile;
import pw.hysteria.jobs.framework.QuestCreator;

public class CMDTest implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        PlayerProfile profile = new PlayerProfile((Player) sender);
        profile.createProfile(JobType.MINER);
        QuestCreator.randomQuest(profile.getJob());
        return false;
    }
}
