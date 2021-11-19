package 算法导论复习;


import java.util.ArrayList;
import java.util.List;

//平衡二叉树
//https://blog.csdn.net/javazejian/article/details/53892797
public class Problem_8 {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        int[] data = new int[]{10, 9, 7, 6, 5, 8, 0};
        for (int num : data) {
            avlTree.insert(num);
            avlTree.inOrder();
        }
    }

    /**
     * AVL,二叉平衡树
     *
     * @param <T>
     */
    static class AVLTree<T extends Comparable> {
        AVLNode<T> root;//树的根节点

        /**
         * 中序遍历
         */
        public void inOrder() {
            List<T> order = new ArrayList<>();
            inOrderSubTree(root, order);
            System.out.println(order);
        }

        /**
         * 中序遍历子树
         */
        public List<T> inOrderSubTree(AVLNode<T> subTree, List<T> order) {
            if (subTree != null) {
                order.add(subTree.data);
                inOrderSubTree(subTree.left, order);
                inOrderSubTree(subTree.right, order);
            }
            return order;
        }

        /**
         * 求树的高度
         */
        public int height(AVLNode<T> p) {
            return p == null ? -1 : p.height;
        }

        /**
         * 向二叉树插入节点
         *
         * @param data
         */
        public void insert(T data) {
            if (data == null) {
                throw new RuntimeException("data cannot not be null ");
            }
            this.root = insert(data, root);
        }

        /**
         * 在某个位置插入节点
         *
         * @param data
         * @param p
         * @return
         */
        private AVLNode<T> insert(T data, AVLNode<T> p) {
            //没有子节点，可以插入
            if (p == null) {
                p = new AVLNode<>(data);
            }
            int result = data.compareTo(p.data);
            if (result > 0) {//插入到右子树,插入后判断是否需要旋转
                p.right = insert(data, p.right);
                if (height(p.right) - height(p.left) == 2) {//AVL不平衡
                    //判断是RL类型还是RR类型
                    if (data.compareTo(p.right.data) > 0) {//RR类型
                        p = RR(p);
                    } else {//RL类型
                        p = RL(p);
                    }
                }
            } else if (result < 0) {//插入到左子树,插入后判断是否需要旋转
                p.left = insert(data, p.left);
                if (height(p.left) - height(p.right) == 2) {//AVL不平衡
                    //判断是LR类型还是LL类型
                    if (data.compareTo(p.left.data) > 0) {//LR类型
                        p = LR(p);
                    } else {//LL类型
                        p = LL(p);
                    }
                }
            } else {//result = 0
                //什么都不做
            }
            p.height = Math.max(height(p.left), height(p.right)) + 1;
            return p;
        }

        /**
         * 左左情况，w变为x的父节点，x变为w的右子树
         *
         * @param x
         * @return
         */
        public AVLNode<T> LL(AVLNode<T> x) {
            AVLNode<T> w = x.left;
            x.left = w.right;
            w.right = x;
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            w.height = Math.max(height(w.left), height(w.right)) + 1;
            return w;
        }

        /**
         * 右右情况，w变为x的左子树，x变为w的父节点
         *
         * @param w
         * @return
         */
        public AVLNode<T> RR(AVLNode<T> w) {
            AVLNode<T> x = w.right;
            w.right = x.left;
            x.left = w;
            w.height = Math.max(height(w.left), height(w.right)) + 1;
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            return x;
        }

        /**
         * LR情况，左子树为RR情况，解决后变成LL情况
         *
         * @param x
         * @return
         */
        public AVLNode<T> LR(AVLNode<T> x) {
            x.left = RR(x.left);
            return LL(x);
        }

        /**
         * RL情况，右子树为LL情况，解决后变成RR情况
         *
         * @param x
         * @return
         */
        public AVLNode<T> RL(AVLNode<T> x) {
            x.right = LL(x.right);
            return RR(x);
        }
    }

    static class AVLNode<T extends Comparable> {

        public AVLNode<T> left;//左结点

        public AVLNode<T> right;//右结点

        public T data;

        public int height;//当前结点的高度

        public AVLNode(T data) {
            this(null, null, data);
        }

        public AVLNode(AVLNode<T> left, AVLNode<T> right, T data) {
            this(left, right, data, 0);
        }

        public AVLNode(AVLNode<T> left, AVLNode<T> right, T data, int height) {
            this.left = left;
            this.right = right;
            this.data = data;
            this.height = height;
        }
    }
}

