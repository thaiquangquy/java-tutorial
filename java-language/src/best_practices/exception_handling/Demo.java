package best_practices.exception_handling;

public class Demo {
    public static void main(String[] args) {
        // 1. Throw a specific, meaningful exception instead of a generic one
        //    so callers can tell exactly what went wrong.
        try {
            withdraw(30, 100);
        } catch (InsufficientFundsException e) {
            System.out.println("Handled precisely: " + e.getMessage());
        }

        // 2. Only catch what you can actually handle; here we add context
        //    and rethrow rather than swallowing the failure silently.
        try {
            loadConfig();
        } catch (RuntimeException e) {
            System.out.println("Propagated with context: " + e.getMessage());
        }
    }

    private static void withdraw(int balance, int amount) {
        if (amount > balance) {
            // A custom, specific exception beats throwing a bare
            // RuntimeException or, worse, returning a sentinel value.
            throw new InsufficientFundsException(
                    "Cannot withdraw " + amount + " from balance of " + balance);
        }
    }

    private static void loadConfig() {
        try {
            throw new java.io.UncheckedIOException(new java.io.IOException("config.yml not found"));
        } catch (java.io.UncheckedIOException e) {
            // Bad practice would be: `catch (Exception e) {}` (silently
            // swallowed) or `catch (Exception e) { e.printStackTrace(); }`
            // and continuing as if nothing happened.
            // Good practice: add context, then rethrow so the caller can react.
            throw new RuntimeException("Failed to start application: missing configuration", e);
        }
    }

    /** Specific exception type instead of a generic RuntimeException. */
    private static class InsufficientFundsException extends RuntimeException {
        InsufficientFundsException(String message) {
            super(message);
        }
    }
}
