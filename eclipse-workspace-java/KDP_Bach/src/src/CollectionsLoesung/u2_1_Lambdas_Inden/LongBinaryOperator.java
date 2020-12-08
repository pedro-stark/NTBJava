package src.CollectionsLoesung.u2_1_Lambdas_Inden;

//Die Angabe @FunctionalInterface ist optional 
@FunctionalInterface 
public interface LongBinaryOperator { 
	long applyAsLong(final long left, final long right); 
}