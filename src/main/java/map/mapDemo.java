package map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lujuan1 on 2017/7/24.
 */
public class mapDemo {

    public static void main(String[] args){

        Map<keyObject, keyObject> map = new HashMap<keyObject, keyObject>();
        map.put(new keyObject(1), new keyObject(1));

        if(map.containsKey(new keyObject(1)))
            System.out.println("the map contains 1");

    }

}
