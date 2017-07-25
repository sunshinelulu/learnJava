package Thread;

/**
 * Created by lujuan1 on 2017/7/19.
 */

/**
 * 线程的join方法的应用示例。一直对join都不太理解
 * join算法可以实现线程之间的顺序执行，通常是主线程要等待各个子线程的同步返回的时候可以使用。
 * 假设在B线程中new 了一个新的Thread对象
 */
public class JoinThreadTest implements Runnable{

    public static void main(String[] args)
    {
        Thread t = new Thread(new RunnableThreadTest(), "新的的线程");
        try {
            t.start();
            t.join();  //告诉当前的线程，等待其他线程的返回。即为需要等待线程t的活动停止。
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("从其他线程中返回");

    }
    public void run(){
        for(int i=0; i < 10; i++){

            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
