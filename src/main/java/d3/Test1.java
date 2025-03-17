package d3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;

/**
 * @Description:
 * @Author: LiYang
 * @Date: 2025/2/28 15:25
 */
@Slf4j
public class Test1 {
//    volatile static boolean run = true;
    static boolean run = true;

    final static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if(!run) {
                        break;
                    }
                }
            }
        });
        t.start();

        log.info("停止 t");
        Thread.sleep(1000);
        synchronized (lock) {
            run = false;
        }
    }
}
