public class InputValidator {
    public void validateInput(String input) throws CustomException {
        if (input == null || input.trim().isEmpty()) {
            throw new CustomException("Input cannot be empty or null.");
        }
        
        // Add more validation rules as required
    }
}
