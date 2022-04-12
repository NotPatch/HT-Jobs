package pw.hysteria.jobs.task;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;
import pw.hysteria.jobs.Jobs;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class JobBooster extends BukkitRunnable {

    File filepath;

    public JobBooster(){
        filepath = new File(Jobs.getInstance().getDataFolder() + "/playerdata/");
    }

    @Override
    public void run() {
        for(File file : Objects.requireNonNull(filepath.listFiles())){
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            if(config.isSet("jobs.booster.duration")){
                int duration = config.getInt("jobs.booster.duration");
                if(duration > 0){
                    config.set("jobs.booster.duration", (duration - 1));
                }else{
                    config.set("jobs.booster", null);
                }
                try {
                    config.save(file);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

}
