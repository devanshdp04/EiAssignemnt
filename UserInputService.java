import java.util.Scanner;

public class UserInputService {
    private final InputValidator validator;
    private final LoggerService logger;

    public UserInputService() {
        this.validator = new InputValidator();
        this.logger = LoggerService.getInstance();
    }

    public void startUserInputProcess() {
        Scanner scanner = new Scanner(System.in);
        boolean continueProcess = true;
        
        while (continueProcess) {
            try {
                logger.info("Awaiting user input...");
                System.out.print("Enter a command (or type 'exit' to quit): ");
                String userInput = scanner.nextLine();
                
                if ("exit".equalsIgnoreCase(userInput)) {
                    continueProcess = false;
                    break;
                }
                
                validator.validateInput(userInput);
                processUserCommand(userInput);
                
            } catch (CustomException ex) {
                logger.warn("Validation failed: " + ex.getMessage());
            } catch (Exception e) {
                logger.error("Error while processing input: " + e.getMessage());
            }
        }
        
        scanner.close();
    }

    private void processUserCommand(String input) {
        switch(input.toLowerCase()) {
            case "start":
                logger.info("Starting the system...");
                // Add logic for starting a process
                break;
            case "stop":
                logger.info("Stopping the system...");
                // Add logic for stopping a process
                break;
            case "status":
                logger.info("System status: OK");
                // Add logic to show the status of the system
                break;
            default:
                logger.warn("Unknown command: " + input);
        }
    }
}
