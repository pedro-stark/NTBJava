package src.Collections.bsp4_AnonymousClasses_Comparable;

import java.util.Comparator;

public class ArticlePriceDescendingComparator implements Comparator<Article> {

	public int compare(Article a1, Article a2) {
		return -a1.compareTo(a2);
	}

}
