package message;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//A singleton service
@Service
public class TextMessageService {

	//Creates List of TextMessage Objects
	private List<TextMessage> textmessages = new ArrayList<>(Arrays.asList(
			new TextMessage(1, "Hello World"),
			new TextMessage(2, "Hello Sean"),
			new TextMessage(3, "Hello Spring")
			));

	//GET-All Text
	public List<TextMessage> readAllTextMessages() {
		return textmessages;
	}
	
	//GET-Single Text
	 public TextMessage readTextMessage(int id) {
	 TextMessage foundtext = new TextMessage();
		 for(TextMessage text : textmessages) {
			if(text.getId() == id) {
			foundtext = text;
			}
		 }
		return foundtext;
	}
	
	 //Put-Single Text
	 public void updateTextMessage(int id, TextMessage textmessage) {
		if(textmessage != null)
		 for(int i = 0; i<textmessages.size(); i++) {
			 TextMessage t = textmessages.get(i);
			 if (t.getId() == id) {
				 textmessages.set(i, textmessage);
			 }
		 }
	 }

	//POST
	public TextMessage addTextMessage(TextMessage textmessage) {
		textmessages.add(textmessage);
		return textmessage;
	}

	//DELETE
	public void removeTextMessage(int id) {
		TextMessage foundtext = new TextMessage();
		for(TextMessage text : textmessages) {
			if(text.getId() == id) {
				textmessages.remove(text);
			}
		}
	}

}
	
	