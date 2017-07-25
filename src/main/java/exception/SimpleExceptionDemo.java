package exception;

/**
 * Created by lujuan1 on 2017/7/17.
 */
public class SimpleExceptionDemo extends Exception{

    public void f() throws SimpleExceptionDemo{
        throw new SimpleExceptionDemo();
    }

    @Override
    public String toString(){
        return "hello, this is an exception detail";
    }

    /**
     * 异常编写的简单的例子
     * @param args
     */
    public static void  main(String[] args) throws Throwable{

        SimpleExceptionDemo demo = new SimpleExceptionDemo();
        System.out.println(demo.getClass());
        try{
            demo.f();
        }catch (Exception e){
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            throw e.fillInStackTrace();
        }
    }

}
