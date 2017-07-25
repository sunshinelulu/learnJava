package Thread;

import java.util.concurrent.ExecutionException;

/**
 * Created by lujuan1 on 2017/7/20.
 */

/**
 * 展示后台线程的应用。当所有的非后台线程结束的时候，程序就结束，后台线程就消失。
 * 后台线程是一种提供通用服务的线程，这种线程可有可无，并不是不可或缺的对程序来讲。
 * 故而程序的生命是由非后台线程所决定的。
 */
public class DemoThread extends Thread{

    public DemoThread(){
        setDaemon(true);
        start();
    }

    public void run(){
        try{
            sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(this);
    }

    /**
     * 在这里我们看到了一个例子，由于在main线程开启了一个后台线程之后，main线程就结束了，因此后台线程
     * 也就结束了，从而并没有打印输出相关的信息。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException{
        new DemoThread();
    }
}
