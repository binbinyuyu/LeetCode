package study;

import java.util.*;

public class HashMap哈希表的遍历方式 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 100);
        hashMap.put(2, 200);

        //遍历方法1：通过迭代器Iterator遍历entrySet,效率高
        System.out.println("遍历方式1：");
        Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            int key = next.getKey();
            int value = next.getValue();
            System.out.println("key=" + key + ",value=" + value);
        }

        //遍历方法2：通过迭代器Iterator遍历keyset或values
        System.out.println("遍历方式2：");
        Collection<Integer> values = hashMap.keySet();
        Iterator<Integer> iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            System.out.println("key=" + next + ",value=" + hashMap.get(next));
        }

        //遍历方法3：foreach遍历entrySet或keyset或values
        System.out.println("遍历方式3：");
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
        }

        //遍历方法4：Lambda表达式遍历
        System.out.println("遍历方式4：");
        hashMap.forEach((k,v)->{
            System.out.println("key=" + k + ",value=" + v);
        });
    }
}
