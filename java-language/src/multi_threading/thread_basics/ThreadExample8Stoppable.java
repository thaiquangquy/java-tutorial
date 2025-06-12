package multi_threading.thread_basics;

public class ThreadExample8Stoppable {
    public static class StoppableRunnable implements Runnable {
        private boolean isRequestStop = false;

        public synchronized Boolean getIsRequestStop() {
            return isRequestStop;
        }

        public synchronized void setIsRequestStop(Boolean isRequestStop) {
            this.isRequestStop = isRequestStop;
        }

        private void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            System.out.println("Thread start");
            while (!getIsRequestStop()) {
                sleep(1000);
                System.out.println("...");
            }
            System.out.println("Thread stop");
        }
    }

    public static void main(String[] args) {
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread stoppableThread = new Thread(stoppableRunnable);
        stoppableThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stoppableRunnable.setIsRequestStop(true);
    }
}
