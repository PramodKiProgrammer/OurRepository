package pramod.com.aleffelaworkflow.model;

/**
 * Created by ipspl on 17/4/17.
 */

public class VideoData {

    int videoImage;
    String title;
    String description;

    public VideoData(int videoImage, String title, String description) {
        this.videoImage = videoImage;
        this.title = title;
        this.description = description;
    }

    public int getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(int videoImage) {
        this.videoImage = videoImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
