package pramod.com.aleffelaworkflow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pramod.com.aleffelaworkflow.R;
import pramod.com.aleffelaworkflow.model.VideoData;

/**
 * Created by ipspl on 17/4/17.
 */

public class LinearListRowAdapter extends RecyclerView.Adapter<LinearListRowAdapter.ListRowHolder> {

    Context context;
    List<VideoData> videoDatas;

    public LinearListRowAdapter(Context context, List<VideoData> videoDatas) {
        this.context = context;
        this.videoDatas = videoDatas;
    }

    @Override
    public ListRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_list_row, parent, false);
        ListRowHolder listRowHolder = new ListRowHolder(view);
        return listRowHolder;
    }

    @Override
    public void onBindViewHolder(ListRowHolder holder, int position) {
        holder.imageVideo.setImageResource(videoDatas.get(position).getVideoImage());
        holder.textViewTitle.setText(videoDatas.get(position).getTitle());
        holder.textViewDescription.setText(videoDatas.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return videoDatas.size();
    }

    public class ListRowHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_view_list_video)
        ImageView imageVideo;

        @BindView(R.id.txt_list_title)
        TextView textViewTitle;
        @BindView(R.id.txt_list_description)
        TextView textViewDescription;

        public ListRowHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
