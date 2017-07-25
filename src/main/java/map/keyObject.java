package map;

/**
 * Created by lujuan1 on 2017/7/24.
 */

/**
 * 当使用自己编写的类作为map的key值的时候，必须要重写hashCode和equals方法。
 * 才能够确保存放的结果和我们想要的结果是一样的。
 */
public class keyObject {

    public int n;
    public keyObject(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return n;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof keyObject) && (n == ((keyObject)obj).n);
    }
}
