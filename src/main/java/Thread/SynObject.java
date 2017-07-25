package Thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by lujuan1 on 2017/7/19.
 */

public class SynObject {


    /**
     * 主要用来展示对象锁在进行多线程同步时的应用
     * 在java的Object中
     * 当线程调用 sleep 时，并没有释放对象锁，而 wait 则释放了对象锁：
     * @param args
     */
    public static  void main(String[] args) {

        final Object synObj = new Object();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized(synObj) {
                    System.out.println("T1获取synObj的对象监视器，开始执行同步块");
                    try {
                        TimeUnit.SECONDS.sleep(10);
                        System.out.println("T1在 wait()时挂起了");
                        synObj.wait();
                        System.out.println("T1被T2唤醒后并重新获得synObj的对象监视器，继续执行");
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T1获取synObj的对象监视器，结束同步块");
                }
            };
        });
        t1.start();


        Thread t3 = new Thread(new Runnable() {
            public void run() {
                synchronized(synObj) {
                    System.out.println("T3获取synObj的对象监视器，开始执行同步块");
                    try {
                        TimeUnit.SECONDS.sleep(10);
                        System.out.println("T3在 wait()时挂起了");
                        synObj.wait();
                        System.out.println("T3被T2唤醒后并重新获得synObj的对象监视器，继续执行");
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("T3获取synObj的对象监视器，结束同步块");
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
