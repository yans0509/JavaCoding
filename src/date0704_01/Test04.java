package date0704_01;

/**
 * ��ʵ��һ�����������ַ����еĿո��滻��%20 ���룺We are happy. �����We%20are%20happy.
 * 
 * @author Administrator
 *
 */
public class Test04 {

	// ������⿪�ٿռ�

	public static String replaceSpace(String inString, int length) {
		if (inString == null || inString.length() <= 0) {
			return inString;
		}

		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			char c = inString.charAt(i);
			if (c == ' ') {
				sBuffer.append("%20");
			} else {
				sBuffer.append(c);
			}
		}
		return sBuffer.toString();
	}

	// ��������⿪�ٿռ䣬����ͳ�Ƴ��ո������Ȼ��Ӻ���ǰ�����滻��O(n)
	// ��ǰ������O(n2)
	public static String replaceSpace2(String inString) {
		if (inString == null || inString.length() <= 0) {
			return inString;
		}
		// �����ַ�������
		int oldLength = inString.length();
		// ����ո�����
		int spaceCount = 0;
		char[] charArr = inString.toCharArray();
		for (char c : charArr) {
			if (c == ' ') {
				spaceCount++;
			}
		}

		int newLength = oldLength + 2 * spaceCount;
		char[] newCharArr = new char[newLength];

		// ָ��1 ָ����ַ�����ĩβ ָ��2 ָ�����ַ�����ĩβ
		int pOld = charArr.length - 1;
		int pNew = newCharArr.length - 1;

		// ���������飬�����ո��ָ����ǰ�ƶ�һ�������������%20����ָ����ǰ�ƶ�3��s
		while (pOld >= 0) {
			if (charArr[pOld] == ' ') {
				newCharArr[pNew--] = '0';
				newCharArr[pNew--] = '2';
				newCharArr[pNew--] = '%';

				pOld--;
			} else {
				newCharArr[pNew--] = charArr[pOld--];
			}
		}

		return String.valueOf(newCharArr);
	}

	public static void main(String[] args) {
		String s = "We are happy.";

		// System.out.println(replaceSpace(s, s.length()));

		System.out.println(replaceSpace2(s));

	}
}
