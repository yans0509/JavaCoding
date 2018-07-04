package date0704_01;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

/*
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * 
 * �����Ͻǿ�ʼ����
 */
public class Test03 {

	/*
	 * @param matrix �����ҵ�����
	 * 
	 * @param number Ҫ���ҵ���
	 * 
	 * @return ���ҽ����true�ҵ���falseû���ҵ�
	 */
	public static boolean find(int[][] matrix, int number) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
			return false;
		}
		int rows = matrix.length;// ����
		int cols = matrix[1].length;// ����

		int row = 0;// ��ʼ����
		int col = cols - 1;// ��ʼ�е�����

		while (row >= 0 && row < rows && col >= 0 && row < rows) {
			if (matrix[row][col] == number) {
				// �ҵ��ˣ�ֱ���˳�
				return true;
			} else if (number < matrix[row][col]) {
				// ���Ҫ�ҵ���С���ҵ��������ų�һ�У��������ƶ�
				col--;
			} else {
				// ���Ҫ�ҵ��������ҵ��������ų�һ�У��������ƶ�
				row++;
			}

		}

		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		System.out.println(find(matrix, 7)); // Ҫ���ҵ�����������
		System.out.println(find(matrix, 5)); // Ҫ���ҵ�������������
		System.out.println(find(matrix, 1)); // Ҫ���ҵ�������������С������
		System.out.println(find(matrix, 15)); // Ҫ���ҵ�������������������
		System.out.println(find(matrix, 0)); // Ҫ���ҵ�������������С�����ֻ�С
		System.out.println(find(matrix, 16)); // Ҫ���ҵ������������������ֻ���
		System.out.println(find(null, 16)); // ��׳�Բ��ԣ������ָ��
	}
}
