package pramod.com.aleffelaworkflow.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pramod.com.aleffelaworkflow.R;
import pramod.com.aleffelaworkflow.adapter.LinearListRowAdapter;
import pramod.com.aleffelaworkflow.model.VideoData;

public class RelatedVideoFragment extends Fragment {

    @BindView(R.id.recycler_view_fragment)
    RecyclerView recyclerViewFragment;

    List<VideoData> videoDatas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_related_video, container, false);

        ButterKnife.bind(this, view);

        videoDatas = VideoData.prepareViewData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        LinearListRowAdapter adapter = new LinearListRowAdapter(getContext(), videoDatas);
        recyclerViewFragment.setHasFixedSize(true);
        recyclerViewFragment.setLayoutManager(layoutManager);
        recyclerViewFragment.setAdapter(adapter);

        return view;
    }
}
