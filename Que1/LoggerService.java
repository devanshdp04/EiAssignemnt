import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggerService {
    private static LoggerService instance;
    private FileWriter logFile;

    private LoggerService() {
        try {
            logFile = new FileWriter("application.log", true);
        } catch (IOException e) {
            System.out.println("Failed to initialize logging: " + e.getMessage());
        }
    }

    public static LoggerService getInstance() {
        if (instance == null) {
            instance = new LoggerService();
        }
        return instance;
    }

    public void info(String message) {
        log("INFO", message);
    }

    public void warn(String message) {
        log("WARN", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }

    private void log(String level, String message) {
        try {
            logFile.write(LocalDateTime.now() + " [" + level + "] " + message + "\n");
            logFile.flush();
        } catch (IOException e) {
            System.out.println("Failed to write to log: " + e.getMessage());
        }
    }
}
