package findik.mustafa.snapshot.classes;

public class Chat {

    private String fromUsername ,chatDate, chatId,userId,fromUserid;

    public Chat() {
    }

    public Chat(String fromUsername, String chatDate, String chatId, String userId, String fromUserid) {
        this.fromUsername = fromUsername;
        this.chatDate = chatDate;
        this.chatId = chatId;
        this.userId = userId;
        this.fromUserid = fromUserid;
    }

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername;
    }

    public String getChatDate() {
        return chatDate;
    }

    public void setChatDate(String chatDate) {
        this.chatDate = chatDate;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFromUserid() {
        return fromUserid;
    }

    public void setFromUserid(String fromUserid) {
        this.fromUserid = fromUserid;
    }
}
