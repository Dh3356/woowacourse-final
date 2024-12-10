package lotto.controller.retryer;

import java.util.function.Supplier;
import lotto.common.exception.CustomException;

public final class Retryer {

    public static final String ERROR_PREFIX = "[ERROR] ";

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
            System.out.println(ERROR_PREFIX + e.getMessage());
            return;
        }
        throw e;
    }
}
