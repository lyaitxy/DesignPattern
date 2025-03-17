package d2;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description:
 * @Author: LiYang
 * @Date: 2025/2/27 15:35
 */
@Slf4j
public class Test2 {
    static final Object lock = new Object();
    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify(1, 5);
        Thread t1 = new Thread(() -> {
            waitNotify.printChar(1, 2, "a");
        }, "t1");

        Thread t2 = new Thread(() -> {
            waitNotify.printChar(2, 3, "b");
        }, "t2");

        Thread t3 = new Thread(() -> {
            waitNotify.printChar(3, 1, "c");
        }, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}

@Slf4j
class WaitNotify {
    // 等待标记
    private int flag;
    // 循环次数
    private int loopNumber;

    public WaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    public void printChar(int curFlag, int nextFlag, String str) {
        for(int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while(flag != curFlag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }
}
