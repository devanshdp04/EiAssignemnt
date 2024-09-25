import java.util.concurrent.Callable;

public class ErrorHandlingService {
    private static final int MAX_RETRIES = 3;

    public <T> T executeWithRetries(Callable<T> callable) throws Exception {
        int attempt = 0;
        while (attempt < MAX_RETRIES) {
            try {
                return callable.call();
            } catch (Exception ex) {
                attempt++;
                if (attempt >= MAX_RETRIES) {
                    throw ex;
                }
                LoggerService.getInstance().warn("Transient error occurred, retrying... Attempt " + attempt);
            }
        }
        return null;
    }
}
