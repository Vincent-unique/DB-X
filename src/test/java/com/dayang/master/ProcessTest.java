package com.dayang.master;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Vincent on 2017/9/7 0007.
 */
public class ProcessTest {
    public static void main(String[] args) {
        String line = null;
        try {
            Process mvnProc = Runtime.getRuntime().exec("mvn -v");
            BufferedReader reader = new BufferedReader(new InputStreamReader(mvnProc.getInputStream()));
            line = reader.readLine();
            while ((line=reader.readLine())!=null){
                System.out.print(line);
            }

        }catch (IOException ioe){
            ioe.fillInStackTrace();
        }
    }
}

