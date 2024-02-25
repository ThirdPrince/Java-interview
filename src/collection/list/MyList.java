package collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MyList {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("Item 1");
        myList.add("Item 2");
        myList.add("Item 3");
        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }




    }
}
