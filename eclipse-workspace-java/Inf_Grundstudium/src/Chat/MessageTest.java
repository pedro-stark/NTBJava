package Chat;

public class MessageTest
{
    Communication communication;
    
    public MessageTest() {
        communication = new Communication();
        communication.open(6666);
    }

    public void sendeMessage(String host){
        User user = new User("Fritz");
        Message message = new PostingMessage(user,"Hoi du!");
        communication.sendMessage(host, 6666, message);
    }

    public void empfangeMessage() {
        communication.waitForMessage();
        Message message = communication.getMessage();
        if (message instanceof PostingMessage) {
            PostingMessage posting = (PostingMessage) message;
            System.out.println("Posting message von " + posting.getUser() + " mit Inhalt " + posting.getText() + " empfangen.");
        } else if (message instanceof RegisterMessage) {
            System.out.println("Register message von " + message.getUser() + " empfangen.");
        } else if (message instanceof UnregisterMessage) {
            System.out.println("Unregister message von " + message.getUser() + " empfangen.");
        } 
    }

    public void beenden() {
        communication.close();
    }
}
