package delay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangyb
 * @date 2020/4/28
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        DelayTask delayTask = new DelayTask(3600);
        delayTask.start();
        AtomicInteger count = new AtomicInteger();
        while (true) {
            String s = b.readLine();
            if ("0".equals(s)) {
                break;
            }
            delayTask.addTask(new DelayTask.Task(() -> System.out.println("执行任务" + count.getAndIncrement())), Integer.valueOf(s));
        }
    }
}
