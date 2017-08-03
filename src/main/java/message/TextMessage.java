package message;

public class TextMessage {

    private int id;
    private String content;

    public TextMessage() {
    }
    
    public TextMessage(int id, String content) {
    	super();
        this.id = id;
        this.content = content;
    }

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
