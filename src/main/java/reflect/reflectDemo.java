package reflect;

/**
 * Created by lujuan1 on 2017/7/18.
 */
import java.lang.reflect.*;
public class reflectDemo {
    /**
     * 利用反射机制来写的一个demo
     * 反射的两个方法 getMethods和getConstructors
     * @param args
     */
    public static void main(String[] args){
        try{
            Class c = Class.forName("exception.Exceptionchain");

            Method[] methods= c.getMethods();

            Constructor[] constructors = c.getConstructors();
            for(Method m:methods){
                System.out.println(m.toString());
            }
            for(Constructor cc : constructors){
                System.out.println(cc.toString());
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
