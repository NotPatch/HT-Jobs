package pw.hysteria.jobs.framework;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import pw.hysteria.jobs.Jobs;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;

public class QuestCreator {

    public static Quest randomQuest(JobType jobType){
        String job = jobType.getDisplayName().toUpperCase();
        FileConfiguration config = Jobs.getQuestData().getQuests();
        Set<String> keys = config.getConfigurationSection(job).getKeys(false);
        int random = new Random().nextInt(keys.size());
        String key = (String) keys.toArray()[random];

        String[] amountstr = config.getString(job + key + ".amount").split("-");
        int min = Integer.parseInt(amountstr[0]);
        int max = Integer.parseInt(amountstr[1]);

        int amount = getRandomInt(min, max);
        Quest quest = new Quest(jobType, amount, Arrays.asList("sadas", "sadas"), Arrays.asList("asd", "asdas"));
        Bukkit.broadcastMessage(String.valueOf(quest.getAmount()));
        Bukkit.broadcastMessage(quest.getJobType().getDisplayName());
        return quest;

    }

    public static int getRandomInt(int min, int max) {
        Random r = new Random();
        int result = r.nextInt(max - min) + min;
        return result;
    }



}
