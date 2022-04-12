package pw.hysteria.jobs.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import pw.hysteria.jobs.Jobs;

import java.io.File;

public class QuestData {

    Jobs main;
    File file;
    FileConfiguration config;

    public QuestData(){
        this.file = new File(main.getDataFolder() + "quests.yml");
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getQuests(){
        return config;
    }

    public void saveQuests(){
        try {
            config.save(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
