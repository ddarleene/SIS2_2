public class ExamChecking extends Thread {
    private static int examSheets = 500;
    private int iterations;

    public ExamChecking(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < iterations; i++) {
                synchronized (ExamChecking.class) {
                    if (examSheets <= 0) {
                        System.out.println("There is no exam sheet left! All papers were already checked!!!");
                        System.exit(0);
                    }

                    examSheets -= 50;
                    System.out.println(Thread.currentThread().getName() + " finished checking, at: "
                            + new java.util.Date() + ", exam sheet count is now " + examSheets);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}
