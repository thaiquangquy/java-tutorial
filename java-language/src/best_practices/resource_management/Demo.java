package best_practices.resource_management;

public class Demo {
    public static void main(String[] args) {
        // try-with-resources: any AutoCloseable declared in the parentheses
        // is closed automatically when the block exits, even if an exception
        // is thrown -- no verbose finally block needed, and no leaked handle.
        try (NoisyResource resource = new NoisyResource("db-connection")) {
            resource.doWork();
        }

        System.out.println("---");

        // Even when the work throws, close() still runs before the
        // exception propagates.
        try (NoisyResource resource = new NoisyResource("file-handle")) {
            resource.explode();
        } catch (IllegalStateException e) {
            System.out.println("Caught expected failure: " + e.getMessage());
        }
    }

    private static class NoisyResource implements AutoCloseable {
        private final String name;

        NoisyResource(String name) {
            this.name = name;
            System.out.println("Opened " + name);
        }

        void doWork() {
            System.out.println("Using " + name);
        }

        void explode() {
            throw new IllegalStateException(name + " failed mid-use");
        }

        @Override
        public void close() {
            System.out.println("Closed " + name);
        }
    }
}
