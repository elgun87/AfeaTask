package com.project.utilities;

public class BrowserSleep {
    public static void wait(int time){
        try{
            Thread.sleep(time * 1000L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
