package oncall.controller.retryer;

import java.util.function.Supplier;
import oncall.exception.CustomException;

public final class Retryer {

    private static final String ERROR_FORM = "[ERROR] %s\n\n";

    public static <T> T retryOnCustomException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (RuntimeException e) {
            handleException(e);
            return retryOnCustomException(supplier);
        }
    }

    public static void retryOnCustomException(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            handleException(e);
            retryOnCustomException(runnable);
        }
    }

    private static void handleException(RuntimeException e) throws RuntimeException {
        if (e instanceof CustomException) {
            System.out.printf(ERROR_FORM, e.getMessage());
            return;
        }
        throw e;
    }
}
