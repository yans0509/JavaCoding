package date0704_01;

public class Test02 {

	/*
	 * ����ʽ �̰߳�ȫ
	 */
	public static class Singleton1 {
		private final static Singleton1 INSTANCE = new Singleton1();

		private Singleton1() {
		}

		public static Singleton1 getInstance() {
			return INSTANCE;
		}
	}

	/*
	 * ����ʽ �̲߳���ȫ
	 */

	public static class Singleton2 {
		private static Singleton2 instance = null;

		private Singleton2() {
		}

		public static Singleton2 getInstance() {
			if (instance == null) {
				instance = new Singleton2();
			}
			return instance;
		}
	}
	/*
	 * �����Ķ���ʽ �̰߳�ȫ ���̻߳�����Ч�ʲ���
	 */

	public static class Singleton3 {
		private static Singleton3 instance = null;

		private Singleton3() {
		}

		public static synchronized Singleton3 getInstance() {
			if (instance == null) {
				instance = new Singleton3();
			}
			return instance;
		}
	}

	/*
	 * ��̬����� ���ֶ���ʽ �̰߳�ȫ
	 */

	public static class Singleton4 {
		private static Singleton4 instance = null;
		static {
			instance = new Singleton4();
		}

		private Singleton4() {
		}

		public static Singleton4 getInstance() {

			return instance;
		}
	}

	/*
	 * ��̬�ڲ��� �̰߳�ȫ���Ƽ�������ʽ
	 */

	public static class Singleton5 {
		private final static class SingletonHolder {
			private final static Singleton5 INSTANCE = new Singleton5();
		}

		private Singleton5() {
		}

		public static Singleton5 getInstance() {
			return SingletonHolder.INSTANCE;
		}
	}

	/*
	 * ö��
	 */

	public enum Singleton6 {
		INSTANCE;

		public void someMethod() {

		}
	}

	/*
	 * ˫��У���� �̰߳�ȫ���Ƽ���
	 */

	public static class Singleton7 {
		private volatile static Singleton7 instance = null;
		// ��һ�����������volatile����ʱ�����ᱣ֤�޸ĵ�ֵ�����������µ����棬
		// ���������߳���Ҫ��ȡʱ������ȥ�ڴ��ж�ȡ��ֵ

		private Singleton7() {
		}

		public static Singleton7 getInstance() {
			if (instance == null) {
				synchronized (Singleton7.class) {
					if (instance == null) {
						instance = new Singleton7();
					}
				}
			}
			return instance;
		}

	}

	public static void main(String[] args) {
		System.out.println(Singleton1.getInstance() == Singleton1.getInstance());
		System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
		System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
		System.out.println(Singleton4.getInstance() == Singleton4.getInstance());
		System.out.println(Singleton5.getInstance() == Singleton5.getInstance());
		System.out.println(Singleton6.INSTANCE == Singleton6.INSTANCE);
		System.out.println(Singleton7.getInstance() == Singleton7.getInstance());

	}

}
