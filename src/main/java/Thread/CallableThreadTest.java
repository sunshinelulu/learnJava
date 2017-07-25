package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by lujuan1 on 2017/7/19.
 */
public class CallableThreadTest implements Callable<String> {

    /**
     * 这个例子中的主要的意思就是展示Callable接口和FutureTask是怎么使用的，
     * Callable接口主要实现一个带有返回值的call方法。
     * FutureTask主要是用来兜住实现了Callable接口的线程在运行结束的时候的返回值，用来使得我们能够得到处理的结果
     * 可以在主线程中对结果进行一个处理。如果没有这样的方法的话估计我们要使用很复杂的进程之间同步和通信的方法来获取各个线程的处理的结果。
     * 学习基础的链接为：http://www.runoob.com/java/java-multithreading.html
     * @param args
     */
    public static void main(String[] args)
    {
        List<FutureTask<String>> fts = new ArrayList<FutureTask<String>>();
        fts.add(new FutureTask<String>(new CallableThreadTest()));
        fts.add(new FutureTask<String>(new CallableThreadTest()));
        fts.add(new FutureTask<String>(new CallableThreadTest()));
        fts.add(new FutureTask<String>(new CallableThreadTest()));
        for(int i = 0;i < 100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);
            if( i < 3)
            {
                Thread t = new Thread(fts.get(i),"有返回值的线程" + i);
                t.setPriority(5+i);
                t.start();
            }
        }
        try
        {
            for(int i= 0; i < 3; i++)
                System.out.println("子线程的返回值："+fts.get(i).get());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }

    }
    public String call() throws Exception
    {
        int i = 0;
        for(;i<3;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        return Thread.currentThread().getName();
    }
}
