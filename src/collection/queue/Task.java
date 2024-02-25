package collection.queue;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Comparable<Task> {
    private String name;
    private int priority;

    private int enqueueCount;


    public Task(String name,int priority){
        this.name = name;
        this.priority = priority;
    }
    public Task(String name,int priority,int enqueueCount){
        this.name = name;
        this.priority = priority;
        this.enqueueCount = enqueueCount;
    }
    public int getPriority() {
        return priority;
    }
    @Override
    public int compareTo(Task task) {
        if(this.priority == task.priority){
            return this.enqueueCount - task.enqueueCount;
        }
        return -(this.priority - task.priority);
    }
    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }



    public static void main(String[] args) {
        /**
         *
         */

        PriorityQueue<Task> priorityQueue = new PriorityQueue<Task>();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        priorityQueue.offer(new Task("TaskA", 1,atomicInteger.getAndIncrement()));
        priorityQueue.offer(new Task("TaskB", 1,atomicInteger.getAndIncrement()));
        priorityQueue.offer(new Task("TaskC", 1,atomicInteger.getAndIncrement()));
        priorityQueue.offer(new Task("TaskD", 1,atomicInteger.getAndIncrement()));

        while (!priorityQueue.isEmpty()) {
            Task task = priorityQueue.poll();
            System.out.println(task);
        }

        System.out.println("--------------------");
        // 使用自定义比较器
//        PriorityQueue<Task> priorityQueue2 = new PriorityQueue<>(new Comparator<Task>() {
//            @Override
//            public int compare(Task t1, Task t2) {
//                return t1.priority - t2.priority;
//            }
//        });
//
//        priorityQueue2.offer(new Task("TaskA", 2));
//        priorityQueue2.offer(new Task("TaskB", 1));
//        priorityQueue2.offer(new Task("TaskC", 3));
//
//        // 遍历队列
//        while (!priorityQueue2.isEmpty()) {
//            Task task = priorityQueue2.poll();
//            System.out.println(task);
//        }
    }
}


