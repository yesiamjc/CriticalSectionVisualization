public class CriticalSectionVisualization {

    private static final Object lock = new Object();
    private static volatile boolean isCriticalSectionRunning = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if (!isCriticalSectionRunning) {
                            isCriticalSectionRunning = true;
                            System.out.println("Thread 1: Entered critical section");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Thread 1: Exited critical section");
                            isCriticalSectionRunning = false;
                            break;
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if (!isCriticalSectionRunning) {
                            isCriticalSectionRunning = true;
                            System.out.println("Thread 2: Entered critical section");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Thread 2: Exited critical section");
                            isCriticalSectionRunning = false;
                            break;
                        }
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
