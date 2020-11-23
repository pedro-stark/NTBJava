package Iterator.General;

public class KonkretesAggregat implements Aggregat {

	private String meineDaten[] = { "1", "2", "3", "4", "5" };

	private class KonkreterIterator implements Iterator {

		private int position = 0;

		public boolean hasNext() {
			if (position < meineDaten.length)
				return true;
			else
				return false;
		}

		public String next() {
			if (this.hasNext())
				return meineDaten[position++];
			else
				return null;
		}
	}

	public Iterator iterator() {
		return new KonkreterIterator();
	}

	public static void main(String args[]) {
		KonkretesAggregat ka = new KonkretesAggregat();
		Iterator it = ka.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
