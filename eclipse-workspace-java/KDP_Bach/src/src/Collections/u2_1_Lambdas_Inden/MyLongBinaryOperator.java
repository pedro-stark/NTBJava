package src.Collections.u2_1_Lambdas_Inden;

public class MyLongBinaryOperator implements LongBinaryOperator {

	@Override
	public long applyAsLong(long left, long right) {
		return left + right;
	}

}
