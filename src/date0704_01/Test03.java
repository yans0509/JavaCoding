package date0704_01;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

/*
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 从右上角开始查找
 */
public class Test03 {

	/*
	 * @param matrix 待查找的数组
	 * 
	 * @param number 要查找的数
	 * 
	 * @return 查找结果，true找到，false没有找到
	 */
	public static boolean find(int[][] matrix, int number) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
			return false;
		}
		int rows = matrix.length;// 行数
		int cols = matrix[1].length;// 列数

		int row = 0;// 起始行数
		int col = cols - 1;// 起始行的列数

		while (row >= 0 && row < rows && col >= 0 && row < rows) {
			if (matrix[row][col] == number) {
				// 找到了，直接退出
				return true;
			} else if (number < matrix[row][col]) {
				// 如果要找的数小于找到的数，排除一列，即向左移动
				col--;
			} else {
				// 如果要找的数大于找到的数，排除一行，即向下移动
				row++;
			}

		}

		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		System.out.println(find(matrix, 7)); // 要查找的数在数组中
		System.out.println(find(matrix, 5)); // 要查找的数不在数组中
		System.out.println(find(matrix, 1)); // 要查找的数是数组中最小的数字
		System.out.println(find(matrix, 15)); // 要查找的数是数组中最大的数字
		System.out.println(find(matrix, 0)); // 要查找的数比数组中最小的数字还小
		System.out.println(find(matrix, 16)); // 要查找的数比数组中最大的数字还大
		System.out.println(find(null, 16)); // 健壮性测试，输入空指针
	}
}
