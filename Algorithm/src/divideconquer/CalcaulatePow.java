package divideconquer;

public class CalcaulatePow {

	// T.C o(log(pow))
	private float calculate(float base, int pow) {
		if (pow == 0)
			return 1;

		float num = calculate(base, pow / 2);
		if (pow % 2 == 0) {
				return num * num;
		} else {
			if(pow > 0)
				return num*num*base;
				else
					return (num*num)/base;
		}
	}

	public static void main(String[] args) {
		CalcaulatePow obj = new CalcaulatePow();
		System.out.println(obj.calculate(10, -2));

	}

}
