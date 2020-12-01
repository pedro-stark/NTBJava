package KW48.u2_2;

//Die Angabe @FunctionalInterface ist optional 
@FunctionalInterface 
public interface LongBinaryOperator { 
	long applyAsLong(final long left, final long right); 
}