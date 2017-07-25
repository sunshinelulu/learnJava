package exception;

/**
 * Created by lujuan1 on 2017/7/17.
 */

class OneException extends Exception{}
public class FinallyWorks {


    public static  void f() throws Exception{
        try{
            throw new OneException();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            System.out.println("fffff");
        }
    }

    public static  void g() throws Exception{
        f();
    }

    public static void main(String[] args) throws Exception{
        g();
    }
}
