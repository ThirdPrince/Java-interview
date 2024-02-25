package collection.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class SetDemo {

    public static void main(String[] args) {
        var hashSet = new HashSet<Integer>();
        hashSet.add(3);
        hashSet.add(7);
        hashSet.add(2);
        hashSet.add(81);
        System.out.println(hashSet.stream().map(x -> x.toString()).collect(Collectors.joining(",")));

        var treeSet = new TreeSet<Integer>(){
            {
                add(3);
                add(7);
                add(2);
                add(81);
            }
        };

        var y = treeSet.higher(7);
        System.out.println("y ="+y);

        System.out.println(treeSet.stream().map(x -> x.toString()).collect(Collectors.joining(",")));

      //  ReentrantLock

    }
}
