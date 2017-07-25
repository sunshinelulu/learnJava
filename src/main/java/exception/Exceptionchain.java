package exception;

/**
 * Created by lujuan1 on 2017/7/17.
 */


public class Exceptionchain {

    public static  void main(String[] args){
        try{
            throw new RuntimeException(new NullPointerException());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
