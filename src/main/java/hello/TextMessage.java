package hello;

public class TextMessage {

    private final int id;
    private final String content;

    public TextMessage(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
