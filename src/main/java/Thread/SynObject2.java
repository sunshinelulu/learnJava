package Thread;

import exception.Exceptionchain;

import java.util.concurrent.TimeUnit;

/**
 * Created by lujuan1 on 2017/7/19.
 */
public class SynObject2 {

    public static  void main(String[] args) {

        final Object synObj = new Object();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized(synObj) {
                    System.out.println("T1获取synObj的对象监视器，开始执行同步块");
                    try{
                        synObj.wait();}
                    catch (Exception e){
                        e.printStackTrace();
                    }

                }
            };
        });
        t1.start();


        Thread t3 = new Thread(new Runnable() {
            public void run() {
                synchronized(synObj) {
                    System.out.println("T3获取synObj的对象监视器，开始执行同步块");
                    try{
                        synObj.wait();}
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
        });
        t3.start();
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                //System.out.println("T2启动，但是因为T1占用了synObj的对象监视器，则等待T1执行synObj.wait来释放它");
                synchronized(synObj) {
                    try {
                        System.out.println("T2获取synObj的对象监视器，进入同步块");
                        synObj.notifyAll();
                        System.out.println("T2执行synObj.notifyALL()，但T2还在同步块中，没有释放synObj的对象监视器");
                        TimeUnit.SECONDS.sleep(10);
                        System.out.println("T2结束同步块，释放synObj的对象监视器");
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        });
        t2.start();

    }
}
