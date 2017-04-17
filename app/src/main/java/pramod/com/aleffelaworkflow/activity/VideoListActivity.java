package pramod.com.aleffelaworkflow.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pramod.com.aleffelaworkflow.R;
import pramod.com.aleffelaworkflow.adapter.VideoListAdapter;
import pramod.com.aleffelaworkflow.model.VideoData;

public class VideoListActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    List<VideoData> videoDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        ButterKnife.bind(this);

        videoDatas = new ArrayList<>();
        prepareViewData();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);

        VideoListAdapter videoListAdapter = new VideoListAdapter(getApplicationContext(), videoDatas);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(videoListAdapter);

    }

    public void prepareViewData() {

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
    }
}
