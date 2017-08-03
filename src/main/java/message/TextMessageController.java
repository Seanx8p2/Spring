package message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

//Handles HTTP Requests for resources by returning output from the Service Class
@RestController
public class TextMessageController {
	
	//Declares a dependency injection (makes the instance available for the entire class)
	@Autowired
	private TextMessageService textMessageService;

    //GET Request for all TextMessages
    @RequestMapping(
    		value = "/textmessages",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<TextMessage>> getAllTextMessages() {
    	
        Collection<TextMessage> textmessages = textMessageService.readAllTextMessages();
        		return new ResponseEntity<Collection<TextMessage>>(textmessages,
                HttpStatus.OK);
    }

  
    //GET Request for a single TextMessage 
    @RequestMapping(
    		value = "/textmessages/{id}",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public TextMessage getTextMessage(@PathVariable int id) {    	
        return textMessageService.readTextMessage(id);        
    }
    
    //Put Request for a single TextMessage 
    @RequestMapping(
    		value = "/textmessages/{id}",
    		method = RequestMethod.PUT,
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public void putTextMessage(@RequestBody TextMessage textmessage, @PathVariable  int id) {    	
        textMessageService.updateTextMessage(id, textmessage);
    }
    
    //POST Request to create a new TextMessage
    @RequestMapping(
    		value = "/textmessages",
    		method = RequestMethod.POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public void postTextMessage(@RequestBody TextMessage textmessage) {
    		textMessageService.addTextMessage(textmessage);
    }


    //DELETE Request on a single TextMessage 
    @RequestMapping(
    		value = "/textmessages/{id}",
    		method = RequestMethod.DELETE,
    		consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTextMessage(@PathVariable int id) {
         textMessageService.removeTextMessage(id);
                            
}
    
}
