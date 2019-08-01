package findik.mustafa.snapshot.classes;

public class Story {

    private String userImage,userName,storyDate,storyId,userId;
    private Boolean IsLook;

    public Story() {
    }

    public Story(String userImage, String userName, String storyDate, String storyId, String userId,Boolean IsLook) {
        this.userImage = userImage;
        this.userName = userName;
        this.storyDate = storyDate;
        this.storyId = storyId;
        this.userId = userId;
        this.IsLook=IsLook;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStoryDate() {
        return storyDate;
    }

    public void setStoryDate(String storyDate) {
        this.storyDate = storyDate;
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getLook() {
        return IsLook;
    }

    public void setLook(Boolean look) {
        IsLook = look;
    }
}
