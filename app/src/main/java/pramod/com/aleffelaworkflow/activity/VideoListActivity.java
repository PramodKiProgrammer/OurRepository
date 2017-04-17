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

        videoDatas = VideoData.prepareViewData();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);

        VideoListAdapter videoListAdapter = new VideoListAdapter(getApplicationContext(), videoDatas);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(videoListAdapter);

    }


}
