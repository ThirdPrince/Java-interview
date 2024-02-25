package collection;

import java.util.*;

/**
 * 随机序列生成器
 */
public class RandomStringGenerator<T> implements Iterable<T> {

    private final List<T> list;
    public RandomStringGenerator(List<T> list){
        this.list = list;

    }


    @Override
    public Iterator<T> iterator() {
        return  new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public T next() {
                return list.get((int)(list.size() * Math.random()));
            }
        };
    }

    public static void main(String[] args) {
        var list = Arrays.asList("jj","kkkk","jjjjjjjjjjj");
        var randomStringGenerator = new RandomStringGenerator(list);
        for(var item:randomStringGenerator) {
            System.out.println(item);
        }


    }
}
