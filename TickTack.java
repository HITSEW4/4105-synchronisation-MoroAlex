import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TickTack {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean tickTurn = true;

    public void tick() throws InterruptedException{
        lock.lock();
        try {
            while (!tickTurn){
                condition.await();
            }
            System.out.println("tick");
            tickTurn = false;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void tack() throws InterruptedException{
        lock.lock();
        try {
            while (tickTurn){
                condition.await();
            }
            System.out.println("tack");
            tickTurn = true;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}