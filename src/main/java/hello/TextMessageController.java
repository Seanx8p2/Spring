package hello;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Handles HTTP Requests for resources by returning output from the Service Class
@RestController
public class TextMessageController {
	
	//Declares a dependency injection (makes the instance available for the entire class)
	@Autowired
	private TextMessageService textMessageService;
	
	/*
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //Maps the HTTP request to the textMessage method
    @RequestMapping("/textmessages")
    public Collection<TextMessage> createTextMessage(@RequestParam(value="name", defaultValue="World") String name) {
        return Arrays.asList( 
        		new TextMessage(counter.incrementAndGet(),String.format(template, name)));
    }
     */

    //GET Request for all TextMessages
    @RequestMapping("/textmessages")
    public Collection<TextMessage> getAllTextMessages() {
    		return textMessageService.getAllTextMessages();
    }
  
    //GET Request for a single TextMessage 
    @RequestMapping("/textmessages/{id}")
    public TextMessage getTextMessage(@PathVariable int id) {    	
        return textMessageService.getAllTextMessages(id);        
    }
    
    //POST Request to create a new TextMessage
    @RequestMapping(method=RequestMethod.POST, value="/textmessages")
    public void addTextMessage(@RequestBody TextMessage textmessage) {
    		textMessageService.addTextMessage(textmessage);
    }
    
    //DELETE Request on a single TextMessage 
    @RequestMapping(method=RequestMethod.DELETE, value="/textmessages/{id}")
    public TextMessage deleteTextMessage(@PathVariable int id) {    	
        return textMessageService.deleteTextMessages(id);
                            
}
    
}
