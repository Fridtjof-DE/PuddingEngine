package me.fridtjof.puddingengine.io;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private boolean debugMode;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Logger(boolean debugMode) {
        this.debugMode = debugMode;
    }

    public void info(String message) {
        printer("INFO", message);
    }

    public void debug(String message) {
        printer("DEBUG", message);
    }

    public void warn(String message) {
        printer("WARN", message);
    }

    public void error(String message) {
        printer("ERROR", message);
    }

    private void printer(String prefix, String message) {
        System.out.println("[" + dtf.format(LocalDateTime.now()) + "] [" + prefix + "]: " + message);
    }

    //setters & getters

    public boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }
}
