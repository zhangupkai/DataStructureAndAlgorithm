/**
 * @Description 系数数组
 * @Author Kai
 * @Date 2021/8/26 11:09
 */
public class SparseArray {
    public static void main(String[] args) {
        // 原始二维数组
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        // 二维数组中有效元素个数
        int sum = 0;
        System.out.println("原始二维数组：");
        for (int[] rows : chessArr1) {
            for (int ele : rows) {
                System.out.printf("%d\t", ele);
                if (ele != 0) {
                    sum++;
                }
            }
            System.out.println();
        }

        // 创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        int row1 = chessArr1.length;
        int col1 = chessArr1[0].length;
        sparseArray[0][0] = row1;
        sparseArray[0][1] = col1;
        sparseArray[0][2] = 3;

        // count记录第几个非0数据
        // 遍历二维数组，并将非0值存入稀疏数组中
        int count = 0;
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println("稀疏数组：");
        for (int[] rows : sparseArray) {
            for (int ele : rows) {
                System.out.printf("%d\t", ele);
            }
            System.out.println();
        }

        // 稀疏数组 转 二维数组
        int row2 = sum + 1;
        int col2 = 3;
        int[][] chessArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < row2; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("转回的二维数组：");
        for (int[] rows : chessArr2) {
            for (int ele : rows) {
                System.out.printf("%d\t", ele);
            }
            System.out.println();
        }
    }
}
