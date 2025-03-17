package DesignPattern.单例模式;

public class Singleton {
    // 双重检查锁实现
    /*
    private static volatile Singleton instance;

    private Singleton(){};

    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
     */

    // 静态内部类
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton(){};
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
