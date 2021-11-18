package study;

public class 稀疏数组 {
    /**
     * 将二维数组转换为稀疏数组
     *
     * @param chess
     * @return
     */
    public static int[][] ConvertToSparseArray(int chess[][]) {
        //1、首先遍历二维数组，获得数组大小及非空值的个数
        int count = 0;
        for (int[] row : chess) {
            for (int value : row) {
                if (value != 0)
                    count++;
            }
        }
        //2、初始化稀疏数组，数组第一行存储原先的数组大小、非空值个数
        int[][] sparseArray = new int[count + 1][3];
        sparseArray[0][0] = chess.length;//二维数组行数
        sparseArray[0][1] = chess[0].length;//二维数组列数
        sparseArray[0][2] = count;//原先棋盘中非空值的个数
        //3、遍历二维数组，将值存入稀疏数组
        int index = 0;//记录是第几个非空数据
        for (int i = 0; i < chess.length; i++)
            for (int j = 0; j < chess[0].length; j++) {
                if (chess[i][j] != 0) {
                    index++;
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = chess[i][j];
                }
            }
        return sparseArray;
    }

    /**
     * 将稀疏数组转换为二维数组
     *
     * @param sparseArray
     * @return
     */
    public static int[][] convertToChess(int[][] sparseArray) {
        //1、读取第一行，初始化二维数组
        int[][] chess = new int[sparseArray[0][0]][sparseArray[0][1]];
        //2、遍历稀疏数组，将值存入二维数组
        for (int i = 1; i < sparseArray.length; i++) {
            int row = sparseArray[i][0];
            int col = sparseArray[i][1];
            int val = sparseArray[i][2];
            chess[row][col] = val;
        }
        return chess;
    }

    /**
     * 输出数组
     *
     * @param data
     */
    public static void printData(int[][] data) {
        if (data == null)
            return;
        for (int[] row : data) {
            for (int value : row) {
                System.out.printf("%d\t", value);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //将二维数组的棋盘保存为一个稀疏数组
        int[][] chess = new int[10][10];
        //1表示为黑棋，2表示为白棋，0表示没有棋子
        chess[2][5] = 1;
        chess[3][6] = 1;
        chess[4][7] = 2;
        chess[5][8] = 2;
        chess[6][9] = 2;
        System.out.println("原始棋盘：");
        printData(chess);

        int[][] sparseArray = ConvertToSparseArray(chess);
        System.out.println("稀疏数组：");
        printData(sparseArray);

        int[][] convertToChess = convertToChess(sparseArray);
        System.out.println("恢复后的二维数组：");
        printData(convertToChess);
    }
}
