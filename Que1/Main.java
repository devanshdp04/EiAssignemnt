public class Main {
    public static void main(String[] args) {
        LoggerService logger = LoggerService.getInstance();
        UserInputService inputService = new UserInputService();
        
        logger.info("Application started...");
        
        try {
            inputService.startUserInputProcess();
        } catch (Exception e) {
            logger.error("Unexpected error in main process: " + e.getMessage());
        }
        
        logger.info("Application ended.");
    }
}
