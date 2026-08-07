package com.techlynk.selenium.scenario2;

/**
 *
 * @author JonathanSaddler
 */
public abstract class SlowExTestBase extends ExTestBase {
    final int slowMoSeconds;
    public SlowExTestBase(String testPrepend) {
        super(testPrepend);
        this.testUrl = "https://jqueryui.com"; // default is jQueryUI.com
        slowMoSeconds = 1;
    }
    public SlowExTestBase(String testPrepend, int slowMoSeconds) {
        super(testPrepend);
        this.testUrl = "https://jqueryui.com"; // default is jQueryUI.com
        this.slowMoSeconds = slowMoSeconds;
    }
    
    public void i(String msg) {
        System.out.println(msg);
        testReport.info(msg);
        try {  Thread.sleep(slowMoSeconds*1000); } 
        catch(InterruptedException e) {  throw new RuntimeException("Step execution interrupted."); }
    }
    public void iFormat(String formatMsg, Object... formatObjs) {
        System.out.printf(formatMsg + "\n", formatObjs);
        testReport.info(String.format(formatMsg + "\n", formatObjs));
        try { Thread.sleep(slowMoSeconds*1000); } 
        catch(InterruptedException e) { throw new RuntimeException("Step execution interrupted."); }
    }
    public void iWait(int waitSeconds, String msg) {
        System.out.println(msg);
        testReport.info(msg);
        try {  Thread.sleep(waitSeconds*1000); } 
        catch(InterruptedException e) {  throw new RuntimeException("Step execution interrupted."); }
    }
}
