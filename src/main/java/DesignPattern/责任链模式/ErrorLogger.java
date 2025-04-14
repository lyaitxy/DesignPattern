package DesignPattern.责任链模式;

public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String msg) {
        System.out.println("Error Console::Logger: " + msg);
    }
}
