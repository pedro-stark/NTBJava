package FactoryMethod.Notification;

public class NotificationTest { 
	public static void main(String[] args) 
	{ 
		NotificationFactory notificationFactory = new NotificationFactory(); 
		
		Notification noti1 = notificationFactory.createNotification("SMS"); 
		noti1.notifyUser(); 

		Notification noti3 = notificationFactory.createNotification("EMAIL");
		noti3.notifyUser();
		
		Notification noti4 = notificationFactory.createNotification("PUSH");
		noti4.notifyUser();
		
	} 
} 
