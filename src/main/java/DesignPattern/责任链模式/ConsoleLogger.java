package DesignPattern.责任链模式;

public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String msg) {
        System.out.println("Standard Console::Logger: " + msg);
    }
}
