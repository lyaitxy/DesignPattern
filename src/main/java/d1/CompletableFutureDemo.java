package d1;

import java.net.http.HttpResponse;
import java.util.concurrent.*;

/**
 * @Description: demo类
 * @Author: LiYang
 * @Date: 2025/2/23 15:12
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            return 1;
        }).thenApply(f -> {
            return f + 1;
        }).thenApply(f -> {
            return f + 2;
        }).thenAccept(System.out::println);
    }

    private static void extracted() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        try {
            CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName() + "---- come in");
                int res = ThreadLocalRandom.current().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("----- 1秒后出结果" + res);
                if(res > 8) {
                    int i = 1 / 0;
                }
                return  res;
            }, threadPool).whenComplete((res, ex) -> {
                if(ex == null) {
                    System.out.println("----计算完成" + res);
                }
            }).exceptionally(e -> {
                System.out.println("异常情况");
                e.printStackTrace();
                return null;
            });
        } catch (Exception e) {

        } finally {
            threadPool.shutdown();
        }
    }
}

