package oncall.utils;

import oncall.constants.Errors;
import org.mockito.internal.util.Supplier;

public class ErrorCatcher {

    private static final int RETRY_LIMIT = 10;

    public static <T> T tryMethodAndThrow(Supplier<T> method, String errorMessage) {
        try {
            return method.get();
        } catch (Exception e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void retryHandler(Runnable method) {
        int retry = 0;
        while (retry < RETRY_LIMIT) {
            retry++;
            try {
                method.run();
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.err.println(Errors.OVER_MAX_RETRIES.getMessage());
        System.exit(1);
    }
}
