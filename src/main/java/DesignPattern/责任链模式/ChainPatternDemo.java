package DesignPattern.责任链模式;

public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FailLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMsg(AbstractLogger.INFO, "This is an information.");

        loggerChain.logMsg(AbstractLogger.DEBUG,
                "This is a debug level information.");

        loggerChain.logMsg(AbstractLogger.ERROR,
                "This is an error information.");
    }

}
