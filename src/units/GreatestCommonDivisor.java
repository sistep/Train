package units;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		int a=60;
		int b=45;
		System.out.println(getGCD(a, b));

	}
	
	/**
	 * 返回最大公约数
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getGCD(int a, int b) {
		if (a < b) {
			return getGCD(b, a);
		}
		if (0 == b) {
			return a;
		}
		if (isTwo(a)) {
			if (isTwo(b)) {
				return getGCD(a / 2, b / 2) * 2;
			}
			return getGCD(a / 2, b);
		} else {
			if (isTwo(b)) {
				return getGCD(a, b / 2);
			}
			return getGCD(b, a - b);
		}

	}

	private static boolean isTwo(int a) {
		if (0 == a % 2) {
			return true;
		} else {
			return false;
		}
	}

}
