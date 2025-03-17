package d2;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: LiYang
 * @Date: 2025/2/27 15:10
 */
@Slf4j
public class Test1 {
    static ReentrantLock lock = new ReentrantLock();
//    static final Object lock = new Object();
    static Condition condition = lock.newCondition();
    // 表示 t2 是否运行过
    static boolean t2Runned = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            // 获取锁
            lock.lock();
            try {
                while(!t2Runned) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                log.info("t1 也开始了");
            } finally {
                // 释放锁
                lock.unlock();
            }

        }, "t1");

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                log.info("t2 运行了");
                t2Runned = true;
                condition.signal();
            } finally {
                lock.unlock();
            }

        }, "t2");

        t1.start();
        t2.start();

    }
}
