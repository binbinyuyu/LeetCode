package 算法导论复习;

import java.util.ArrayList;
import java.util.List;

// dfs
//https://www.cnblogs.com/DWVictor/p/10048554.html
public class Problem_7 {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(10, null, null);
        root.leftChild = new BinaryTree(5, new BinaryTree(4, null, null), new BinaryTree(7, null, null));
        root.rightChild = new BinaryTree(12, null, null);
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, path, 22);
    }


    public static void dfs(BinaryTree tree, List<Integer> path, int target) {
        path.add(tree.value);
        if (tree.leftChild != null) {
            dfs(tree.leftChild, path, target);
        }
        if (tree.rightChild != null) {
            dfs(tree.rightChild, path, target);
        }
        if (tree.leftChild == null && tree.rightChild == null) {
            //左右子树都为空，则该节点为叶节点，判断一下路径和是否为target
            int sum = 0;
            for (int num : path)
                sum += num;
            if (sum == target)
                System.out.println(path);
        }
        path.remove(path.indexOf(tree.value));
    }

    static class BinaryTree {
        public int value;
        public BinaryTree leftChild;
        public BinaryTree rightChild;

        public BinaryTree(int value, BinaryTree leftChild, BinaryTree rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
}
