package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Процесс (Программа)
        // Поток
        // Синхронизация потоков (один работает другой не работает)
        int sum = 10;
        Random c = new Random();
        int rand = c.nextInt();
        new MyThread("+", rand).start(); // 1 поток
        new MyThread("-", -rand).start(); // 2 поток

        // [+][-][+][-][+][-]
    }


    public static void test(String message, int random) {
        try{
            int sum=10000;
            if(sum < 0){
                System.out.println("Больше денег нет.");
                Thread.sleep(1000);
            }
            else{
                sum=sum+random;
                Thread.sleep(1000);
                System.out.println("Сумма: " + message + sum);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyThread extends Thread{
    private String mess;
    private Random r = new Random();
    private int x= r.nextInt(1000);
    private int sum=10;
    MyThread(String mess, int x){
        this.x = x;
        this.mess = mess;
    }
    @Override
    public void run() {
        while(true){
            Main.test(this.mess, this.x);
        }
    }
}
class RRR implements Runnable{

    @Override
    public void run() {

    }
}