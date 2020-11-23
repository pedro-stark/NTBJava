package Iterator.Notification;

public class NotificationCollection implements Collection {
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	Notification[] notificationList;

	public NotificationCollection() {
		notificationList = new Notification[MAX_ITEMS];
	}

	public void addItem(String str) {
		Notification notification = new Notification(str);
		if (numberOfItems >= MAX_ITEMS)
			System.out.println("Full");
		else {
			notificationList[numberOfItems] = notification;
			numberOfItems++;
		}
	}

	public Iterator iterator() {
		return new NotificationIterator(notificationList);
	}

	private class NotificationIterator implements Iterator {
		// maintains curr pos of iterator over the array
		int pos = 0;

		private NotificationIterator(Notification[] nL) {
			notificationList = nL;
		}

		public Object next() {
			// return next element in the array and increment pos
			Notification notification = notificationList[pos];
			pos += 1;
			return notification;
		}

		public boolean hasNext() {
			if (pos >= notificationList.length || notificationList[pos] == null)
				return false;
			else
				return true;
		}
	}
}