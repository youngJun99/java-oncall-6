package oncall.utils;

import org.mockito.internal.util.Supplier;

public class ErrorCatcher {
    public static <T> T tryMethodAndThrow(Supplier<T> method, String errorMessage) {
        try {
            return method.get();
        } catch (Exception e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
