package d2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: LiYang
 * @Date: 2025/2/27 19:44
 */
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        AwaitSignal signal = new AwaitSignal(5);
        Condition a = signal.newCondition();
        Condition b = signal.newCondition();
        Condition c = signal.newCondition();
        new Thread(() -> {
            signal.print("a", a, b);
        }).start();
        new Thread(() -> {
            signal.print("b", b, c);
        }).start();
        new Thread(() -> {
            signal.print("c", c, a);
        }).start();
        Thread.sleep(1000);
        signal.lock();
        try {
            a.signal();
        } finally {
            signal.unlock();
        }
    }
}

class AwaitSignal extends ReentrantLock {
    private int loopNum;

    public AwaitSignal(int loopNum) {
        this.loopNum = loopNum;
    }

    public void print(String str, Condition cur, Condition next) {
        for(int i = 0; i < loopNum; i++) {
            lock();
            try {
                cur.await();
                System.out.print(str);
                next.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                unlock();
            }
        }
    }
}
