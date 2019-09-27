package andrew.websockets.model;

public class Message {

    private String label;
    private String content;
    private String timestamp;

    public Message(String label, String content, String timestamp) {
        this.label = label;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
