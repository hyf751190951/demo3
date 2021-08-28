import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        test1();
        test2();
        test3();

    }
    public static void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c1 = Class.forName("Student");
        Student student = (Student) c1.newInstance();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            student.setName("黄扬帆");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("直接调用"+(endTime-startTime)+"ms");
    }

    public static void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class c1 = Class.forName("Student");
        Student student = (Student) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            setName.invoke(student,"黄扬帆");
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"ms");
    }

    public static void test3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class c1 = Class.forName("Student");
        Student student = (Student) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            setName.invoke(student,"黄扬帆");
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"ms");
    }

}
