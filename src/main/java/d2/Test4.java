package d2;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description:
 * @Author: LiYang
 * @Date: 2025/2/27 20:08
 */
public class Test4 {
    static Thread t1;
    static Thread t2;
    static Thread t3;

    public static void main(String[] args) {
        ParkUnpark parkUnpark = new ParkUnpark(5);

        t1 = new Thread(() -> {
            parkUnpark.print("a", t2);
        }, "t1");
        t2 = new Thread(() -> {
            parkUnpark.print("b", t3);
        }, "t2");
        t3 = new Thread(() -> {
            parkUnpark.print("c", t1);
        }, "t3");
        t1.start();
        t2.start();
        t3.start();
        LockSupport.unpark(t1);
    }
}

class ParkUnpark {
    public void print(String str, Thread thread) {
        for(int i = 0; i < loopNum; i++) {
            LockSupport.park();
            System.out.print(str);
            LockSupport.unpark(thread);
        }
    }

    private int loopNum;
    public ParkUnpark(int loopNum) {
        this.loopNum = loopNum;
    }
}