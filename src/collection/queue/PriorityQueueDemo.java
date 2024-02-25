package collection.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue(Comparator.reverseOrder());
        queue.offer(5);
        queue.offer(2);
        queue.offer(8);

        /**
         * 这种遍历无序
         */
        for (Integer item : queue) {
            System.out.println(item);
        }
        System.out.println("-----------");
        /**
         * 按照数字递减排序
         */
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
