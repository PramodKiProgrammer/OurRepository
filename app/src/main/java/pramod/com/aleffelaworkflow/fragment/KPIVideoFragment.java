package pramod.com.aleffelaworkflow.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pramod.com.aleffelaworkflow.R;

public class KPIVideoFragment extends Fragment {

    @BindView(R.id.txt_video_history)
    TextView textViewVideoHistory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kpivideo, container, false);

        ButterKnife.bind(this, view);

        String data = "VIDEO HISTORY\n" +
                "Video Length : 1.39\n" +
                "Video Category : Entertainment\n";

        textViewVideoHistory.setText(data);

        return view;
    }
}
