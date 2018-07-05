package date0704_01;

/**
 * 请实现一个函数，把字符串中的空格替换成%20 输入：We are happy. 输出：We%20are%20happy.
 * 
 * @author Administrator
 *
 */
public class Test04 {

	// 允许额外开辟空间

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

	// 不允许额外开辟空间，首先统计出空格个数，然后从后往前进行替换，O(n)
	// 从前往后是O(n2)
	public static String replaceSpace2(String inString) {
		if (inString == null || inString.length() <= 0) {
			return inString;
		}
		// 计算字符串长度
		int oldLength = inString.length();
		// 计算空格数量
		int spaceCount = 0;
		char[] charArr = inString.toCharArray();
		for (char c : charArr) {
			if (c == ' ') {
				spaceCount++;
			}
		}

		int newLength = oldLength + 2 * spaceCount;
		char[] newCharArr = new char[newLength];

		// 指针1 指向旧字符数组末尾 指针2 指向新字符数组末尾
		int pOld = charArr.length - 1;
		int pNew = newCharArr.length - 1;

		// 遍历旧数组，遇到空格旧指针向前移动一个，新数组插入%20，新指针向前移动3个s
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
