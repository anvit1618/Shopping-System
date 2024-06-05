package logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Singleton class for logging events and errors.
 */
public class Logger {
    private static Logger instance;
    private final PrintWriter writer;

    private Logger() {
        PrintWriter tempWriter = null;
        try {
            tempWriter = new PrintWriter(new FileWriter("log.txt", true), true);
        } catch (IOException e) {
            System.err.println("Failed to initialize log writer: " + e.getMessage());
        }
        writer = tempWriter != null ? tempWriter : new PrintWriter(System.err);
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public static void log(String message) {
        Logger loggerInstance = getInstance();
        loggerInstance.writer.println(message);
    }

    public static void log(Exception e) {
        Logger loggerInstance = getInstance();
        e.printStackTrace(loggerInstance.writer);
    }
}
