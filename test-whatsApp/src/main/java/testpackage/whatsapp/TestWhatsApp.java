package testpackage.whatsapp;

// Install the Java helper library from twilio.com/docs/libraries/java
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TestWhatsApp {

	// Find your Account Sid and Auth Token at twilio.com/console
	public static final String AUTH_TOKEN = "ca0bca8345feb29ce6e12117b4c2036c";

	// Find your Account Sid and Token at twilio.com/console
	public static final String ACCOUNT_SID = "ACab0b8e40d9b07255f2c2601f5329af9b";
//    public static final String AUTH_TOKEN = "[AuthToken]"; 

	public static void main(String[] args) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(new com.twilio.type.PhoneNumber("whatsapp:+919992817007"),
				new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), "Your appointment is coming up on July 21 at 3PM")
				.create();

		System.out.println(message);
        
	}

}


//Install the Java helper library from twilio.com/docs/java/install
