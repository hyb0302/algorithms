package delay;


import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * @author huangyb
 * @date 2020/4/28
 */
public class DelayTask {

    private List<Set<Task>> queue;

    private ExecutorService filterExecutor;

    private ExecutorService workExecutor;

    private ScheduledThreadPoolExecutor runningExecutor;

    private int currentIndex = 0;

    private int capacity;

    private int count = 0;

    private ScheduledFuture<?> scheduledFuture;

    private static Function<Set<Task>, Void> workFunction;

    private static Runnable runningRunnable;

    {
        workFunction = tasks -> {
            Iterator<Task> iterator = tasks.iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                if (task.getCycleNum() == 0) {
                    workExecutor.submit(task);
                    iterator.remove();
                } else {
                    task.setCycleNum(task.getCycleNum() - 1);
                }
            }
            return null;
        };
        runningRunnable = () -> {
            Set<Task> tasks = queue.get(currentIndex);
            filterExecutor.submit(() -> {
                workFunction.apply(tasks);
            });
            currentIndex = ++currentIndex % capacity;
            count++;
            System.out.println("当前 index ：" + currentIndex + "/" + count/capacity);
        };
    }

    public DelayTask(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            queue.add(new LinkedHashSet<>());
        }
        workExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        filterExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        runningExecutor = new ScheduledThreadPoolExecutor(1);

    }

    public void addTask(Task task, Integer delaySeconds) {
        int index = (delaySeconds + currentIndex) % capacity;
        int cycleNum = (delaySeconds + currentIndex) / capacity;
        task.setCycleNum(cycleNum);
        queue.get(index).add(task);
    }

    public void start() {
        scheduledFuture = runningExecutor.scheduleAtFixedRate(runningRunnable, 1, 1, TimeUnit.SECONDS);
    }

    public void stop() {
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        scheduledFuture.cancel(false);
    }

    public static class Task implements Runnable {

        private Integer cycleNum;

        private Runnable taskFunction;

        @Override
        public void run() {
            taskFunction.run();
        }

        public Task(Runnable taskFunction) {
            this.taskFunction = taskFunction;
        }

        public Integer getCycleNum() {
            return cycleNum;
        }

        public void setCycleNum(Integer cycleNum) {
            this.cycleNum = cycleNum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return cycleNum.equals(task.cycleNum) &&
                    taskFunction.equals(task.taskFunction);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cycleNum, taskFunction);
        }
    }

}
