package pw.hysteria.jobs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import pw.hysteria.jobs.command.CMDTest;
import pw.hysteria.jobs.data.QuestData;
import pw.hysteria.jobs.hook.EconomyAPI;
import pw.hysteria.jobs.task.JobBooster;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class Jobs extends JavaPlugin {

    private static Jobs instance;

    private static JobBooster booster;

    private static EconomyAPI economyAPI;

    private static QuestData questData;

    public static Jobs getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        economyAPI = new EconomyAPI();

        booster = new JobBooster();
        booster.runTaskTimer(this, 1200,72000);

        questData = new QuestData();

        getCommand("deneme").setExecutor(new CMDTest());
    }

    @Override
    public void onDisable() {
        booster.cancel();
        questData.saveQuests();
        File filepath = new File(Jobs.getInstance().getDataFolder() + "/playerdata/");
        for(File file : Objects.requireNonNull(filepath.listFiles())){
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            try {
                config.save(file);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public static EconomyAPI getEconomyAPI() {
        return economyAPI;
    }

    public static QuestData getQuestData() {
        return questData;
    }
}
