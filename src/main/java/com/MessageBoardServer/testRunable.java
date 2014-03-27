package com.MessageBoardServer;

/**
 * Created by DELL on 14-3-19.
 */
public class testRunable implements Runnable{
    private int count =5;
//    public void run() {
//
//        while(true){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        if (count>0){
//            System.out.println(Thread.currentThread().getName()+"  >>>"+count--);
//        }else{
//            return;
//        }
//    }
//
//}
    public void run(){
        dbHandler a=dbHandler.getInstance();

        System.out.println(Thread.currentThread().getName() + a.testAdd("哈"));
    }

    public static void main(String[] args) {
        testRunable a1=new testRunable();

        new Thread(a1,"1号").start();
        new Thread(a1,"2号").start();
        new Thread(a1,"3号").start();
        System.out.println(Thread.currentThread().getName());

        dbHandler a=dbHandler.getInstance();
        dbHandler b=dbHandler.getInstance();
        if(a==b){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }



}
