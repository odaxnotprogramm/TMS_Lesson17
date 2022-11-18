package com.tms.java.Lesson16;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);
    public String inputStringByScanner(String message){
        System.out.print(message);
        return scanner.next();
    }

    public int inputIntByScanner (String message){
        System.out.print(message);
        return scanner.nextInt();
    }
}
