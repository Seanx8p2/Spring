package hello;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Service;

//A singleton service
@Service
public class TextMessageService {

	
	private Collection<TextMessage> textmessages = Arrays.asList(
			new TextMessage(1, "Hello World"));


	public Collection<TextMessage> getAllTextMessages() {
		return textmessages;
	}

	//GET-fix
	public TextMessage getAllTextMessages(int id) {
		return null;
	}
	
	//DELETE-fix
	public TextMessage deleteTextMessage(int id) {
		return null;
	}

	//POST
	public void addTextMessage(TextMessage textmessage) {
		textmessages.add(textmessage);
	}
	
}
	
	