package DesignPattern.责任链模式;

public class FailLogger extends AbstractLogger{

    public FailLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String msg) {
        System.out.println("Fail Console::Logger: " + msg);
    }
}
