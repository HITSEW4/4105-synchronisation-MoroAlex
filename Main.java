public class Main {
    public static void main(String[] args) {
        TickTack tickTack = new TickTack();

        Thread tickThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    tickTack.tick();
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "tick");

        Thread tackThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    tickTack.tack();
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "tack");


        tickThread.start();
        tackThread.start();
    }
}
