package Exceptions.Phonebook;

public class PhoneBook {
	private Entry[] entries;
	private int nEntries;

	public PhoneBook(int size) {
		entries = new Entry[size];
		nEntries = 0;
	}

	public void enter(String name, int phone) {
		if (nEntries < entries.length && lookup(name) == -1) {
			entries[nEntries] = new Entry(name, phone);
			nEntries++;
		}
	}

	public int lookup(String name) {
		int i;
		for (i = 0; i < nEntries; i++) {
			if (name.equals(entries[i].getName())) {
				return entries[i].getPhone();
			}
		}
		return -1;
	}
}
