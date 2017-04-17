package pramod.com.aleffelaworkflow.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import pramod.com.aleffelaworkflow.R;

/**
 * Created by ipspl on 17/4/17.
 */

public class VideoData implements Parcelable {

    int videoImage;
    String title;
    String description;

    static List<VideoData> videoDatas;

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

    public static List<VideoData> prepareViewData() {

        videoDatas = new ArrayList<>();

        int[] video = new int[]{R.drawable.akshay, R.drawable.ameer, R.drawable.imran, R.drawable.salman};

        VideoData videoData;

        videoData = new VideoData(video[0], "Rustom", "Tere Sang Yara");
        videoDatas.add(videoData);

        videoData = new VideoData(video[1], "Dangal", "Dhaakad");
        videoDatas.add(videoData);

        videoData = new VideoData(video[2], "Crook", "Challa");
        videoDatas.add(videoData);

        videoData = new VideoData(video[3], "Sultan", "Jag Ghoomeya");
        videoDatas.add(videoData);

        videoData = new VideoData(video[0], "Rustom", "Tere Sang Yara");
        videoDatas.add(videoData);

        videoData = new VideoData(video[1], "Dangal", "Dhaakad");
        videoDatas.add(videoData);

        videoData = new VideoData(video[2], "Crook", "Challa");
        videoDatas.add(videoData);

        videoData = new VideoData(video[3], "Sultan", "Jag Ghoomeya");
        videoDatas.add(videoData);

        return videoDatas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.videoImage);
        dest.writeString(this.title);
        dest.writeString(this.description);
    }

    protected VideoData(Parcel in) {
        this.videoImage = in.readInt();
        this.title = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<VideoData> CREATOR = new Parcelable.Creator<VideoData>() {
        @Override
        public VideoData createFromParcel(Parcel source) {
            return new VideoData(source);
        }

        @Override
        public VideoData[] newArray(int size) {
            return new VideoData[size];
        }
    };
}
