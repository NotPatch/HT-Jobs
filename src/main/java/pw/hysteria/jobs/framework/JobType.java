package pw.hysteria.jobs.framework;

public enum JobType {

    MINER("Madenci"),
    LUMBERJACK("Oduncu"),
    HUNTER("Avcı"),
    FISHER("Balıkçı");

    String displayName;

    JobType(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
