package pramod.com.aleffelaworkflow.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pramod.com.aleffelaworkflow.R;
import pramod.com.aleffelaworkflow.activity.VideoSelectedActivity;
import pramod.com.aleffelaworkflow.model.VideoData;

/**
 * Created by ipspl on 17/4/17.
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.VideoListHolder> {

    Context context;
    List<VideoData> videoDatas;

    public VideoListAdapter(Context context, List<VideoData> videoDatas) {
        this.context = context;
        this.videoDatas = videoDatas;
    }

    @Override
    public VideoListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list_row, parent, false);
        VideoListHolder videoListHolder = new VideoListHolder(view);
        return videoListHolder;
    }

    @Override
    public void onBindViewHolder(VideoListHolder holder, int position) {
        holder.imageVideo.setImageResource(videoDatas.get(position).getVideoImage());
        holder.textViewTitle.setText(videoDatas.get(position).getTitle());
        holder.textViewDescription.setText(videoDatas.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return videoDatas.size();
    }

    public class VideoListHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_view_video)
        ImageView imageVideo;

        @BindView(R.id.txt_title)
        TextView textViewTitle;
        @BindView(R.id.txt_description)
        TextView textViewDescription;

        @BindView(R.id.card_view_grid)
        CardView cardViewGrid;

        @BindView(R.id.image_button_download)
        ImageButton imageButtonDownload;

        public VideoListHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            cardViewGrid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    VideoData videoData = videoDatas.get(getAdapterPosition());
                    Intent videoSelected = new Intent(context, VideoSelectedActivity.class);
                    videoSelected.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    videoSelected.putExtra("VideoData", videoData);
                    context.startActivity(videoSelected);
                    Toast.makeText(context, "Waiting for Video", Toast.LENGTH_LONG).show();
                }
            });

            imageButtonDownload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ColorDrawable colorDrawable = (ColorDrawable) imageButtonDownload.getBackground();
                    int color = colorDrawable.getColor();

                    if(color != Color.parseColor("#FF70C227")) {
                        imageButtonDownload.setBackgroundColor(Color.parseColor("#FF70C227"));
                    }
                    else {
                        imageButtonDownload.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                }
            });
        }
    }
}
