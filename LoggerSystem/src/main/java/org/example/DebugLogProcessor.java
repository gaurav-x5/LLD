package org.example;

public class DebugLogProcessor extends LogProcessor{
    DebugLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    public void log(int logLevel, String message) {

        if(logLevel == DEBUG) {
            System.out.println("DEBUG: " + message);
        } else{
            super.log(logLevel, message);
        }

    }
}
