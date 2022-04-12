package pw.hysteria.jobs.hook;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import pw.hysteria.jobs.Jobs;

public class EconomyAPI {

    private static Economy econ = null;

    public EconomyAPI() {
        if (!setupEconomy() ) {
            Jobs.getInstance().getLogger().severe(String.format("[%s] - Vault bulunamadığı için eklenti devredışı!", Jobs.getInstance().getDescription().getName()));
            Jobs.getInstance().getServer().getPluginManager().disablePlugin(Jobs.getInstance());
            return;
        }
    }

    public boolean setupEconomy() {
        if (Jobs.getInstance().getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = Jobs.getInstance().getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

}
