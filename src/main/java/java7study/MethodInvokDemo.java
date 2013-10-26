package java7study;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * User: jinyanhua
 * Date: 13-10-27
 * Time: 上午7:04
 */
public class MethodInvokDemo {
    public static void main(String[] args) {
        try {
            MethodInvokDemo obj = new MethodInvokDemo();
            MethodType mt = MethodType.methodType(int.class, String.class, String.class);
            MethodHandle mh = MethodHandles.lookup().findVirtual(obj.getClass(),"getStrLength",mt);
            int result = (int) mh.invokeExact(obj,"www","hust");
            System.out.println(result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private int getStrLength(String a,String b){
        return (a+b).length();
    }
}
