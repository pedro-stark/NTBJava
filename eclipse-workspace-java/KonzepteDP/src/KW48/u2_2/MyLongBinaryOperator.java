package KW48.u2_2;

public class MyLongBinaryOperator implements LongBinaryOperator {

	@Override
	public long applyAsLong(long left, long right) {
		return left + right;
	}

}
