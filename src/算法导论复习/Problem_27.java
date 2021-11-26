package 算法导论复习;

import java.util.*;

//背包问题
// 贪心算法,每次装单位价值最大的
public class Problem_27 {
    public static void main(String[] args) {
        int c = 110;
        int[] w = new int[]{1, 11, 21, 23, 33, 43, 45, 55};
        int[] v = new int[]{11, 21, 31, 33, 43, 53, 55, 65};
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < w.length; i++) {
            itemList.add(new Item(w[i], v[i]));
        }
        solve(itemList, c);
    }

    public static void solve(List<Item> itemList, int totalWeight) {
        Collections.sort(itemList, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.unitPrice - o2.unitPrice > 0 ? -1 : 1;
            }
        });
        for (Item item : itemList) {
            if (item.weight < totalWeight) {
                totalWeight -= item.weight;
                System.out.println("装下全部物品：" + item);
            } else {
                System.out.println("装下物品：" + item + ", 的部分,重量为" + totalWeight);
                break;
            }
        }
    }

    static class Item {
        int weight;
        int value;
        float unitPrice;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.unitPrice = (float) value / weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "weight=" + weight +
                    ", value=" + value +
                    ", 单价=" + unitPrice +
                    '}';
        }
    }
}
