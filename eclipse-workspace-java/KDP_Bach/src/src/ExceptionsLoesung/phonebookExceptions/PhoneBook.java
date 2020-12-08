package src.ExceptionsLoesung.phonebookExceptions;

public class PhoneBook {
	private Entry[] entries;
	private int nEntries;

	public PhoneBook(int size) {
		if (size <= 0){
			throw new IllegalArgumentException("size must be positiv");
		}
		entries = new Entry[size];
		nEntries = 0;
	}

	public void enter(String name, int phone) 
			throws NoPhoneNumberException, OverflowException {
		
		if (!(999999 < phone && phone < 9999999)) {
			throw new NoPhoneNumberException(name);
		}
		
		if (nEntries >= entries.length) {
			throw new OverflowException();
		}
		
		try {
			lookup(name);
			System.out.println(name + " already in phone book - not entered");
			
		} catch (NameNotFoundException e) {
			System.out.println(name + " entered");
			entries[nEntries] = new Entry(name, phone);
			nEntries++;
		}
	}

	public int lookup(String name) throws NameNotFoundException {
		for (int i = 0; i < nEntries; i++) {
			if (name.equals(entries[i].getName())) {
				return entries[i].getPhone();
			}
		}
		throw new NameNotFoundException(name);
	}
		
}
