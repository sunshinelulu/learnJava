package Thread;

import exception.SimpleExceptionDemo;

/**
 * Created by lujuan1 on 2017/7/18.
 */
public class SimpleThread extends Thread{

    public String toString(){
        return "hello, hello, hello";
    }

    public SimpleThread(String name){
        super(name);
    }
    public  void run(){
        System.out.println(this.getName() + toString());
    }
    public static  void main(String[] args) {


        SimpleThread t = new SimpleThread("新的线程：");
        t.start();
        System.out.println("开启了新的线程");

    }

}
