package com.sarunasbend.github.utility.debug;

public enum LogLevel {
    DEBUG("debug", 0),
    INFO("info", 1),
    WARNING("warning", 2),
    ERROR("error", 3);

    private final String id;
    private final int level;

    LogLevel(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public static LogLevel from(String id) {
        return LogLevel.valueOf(id.toUpperCase());
    }

    public String getId() {
        return this.id;
    }

    public int getLevel() {
        return this.level;
    }
}
