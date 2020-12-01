package Iterator.Notification;

public class NotificationBar {
	private NotificationCollection notifications;

	public NotificationBar(NotificationCollection notifications) {
		this.notifications = notifications;
	}

	public void printNotifications() {
		Iterator iterator = notifications.iterator();
		System.out.println("-------NOTIFICATION BAR------------");
		while (iterator.hasNext()) {
			Notification n = (Notification) iterator.next();
			System.out.println(n.getNotification());
		}
	}

	public static void main(String args[]) {
		NotificationCollection nc = new NotificationCollection();
		// Dummy Notifications
		nc.addItem("Notification 1");
		nc.addItem("Notification 2");
		nc.addItem("Notification 3");
		
		NotificationBar nb = new NotificationBar(nc);
		nb.printNotifications();
	}
}
