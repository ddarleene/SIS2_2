public class ExamChecking extends Thread {
    private static int examSheets = 500;
    private int a;

    public ExamChecking(int a) {
        this.a = a;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < a; i++) {
                synchronized (ExamChecking.class) {
                    if (examSheets <= 0) {
                        System.out.println("No sheets left! All done!");
                        System.exit(0);
                    }

                    examSheets -= 50;
                    System.out.println(Thread.currentThread().getName() + "  finishing checking, at: "
                            + new java.util.Date() + ", exam sheet count is now " + examSheets);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}
