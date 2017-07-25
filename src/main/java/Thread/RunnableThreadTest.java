package Thread;

/**
 * Created by lujuan1 on 2017/7/19.
 */
public class RunnableThreadTest implements Runnable{


    public void run(){
        for(int i=0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + i);
        }
    }

    public static  void main(String[] args) {


        Thread t = new Thread(new RunnableThreadTest(),"新的线程：");
        t.start();
        System.out.println("开启了新的线程");

    }

}
