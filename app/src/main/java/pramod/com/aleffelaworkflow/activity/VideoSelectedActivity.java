package pramod.com.aleffelaworkflow.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pramod.com.aleffelaworkflow.R;
import pramod.com.aleffelaworkflow.fragment.KPIVideoFragment;
import pramod.com.aleffelaworkflow.fragment.RelatedVideoFragment;
import pramod.com.aleffelaworkflow.model.VideoData;

public class VideoSelectedActivity extends AppCompatActivity {

    @BindView(R.id.image_view)
    ImageView imageView;

    @BindView(R.id.txt_tt)
    TextView textViewTt;

    @BindView(R.id.txt_desc)
    TextView textViewDesc;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.image_button_download)
    ImageButton imageButtonDownload;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_selected);

        ButterKnife.bind(this);

        VideoData videoData = (VideoData) getIntent().getExtras().get("VideoData");

        imageView.setImageResource(videoData.getVideoImage());
        textViewTt.setText(videoData.getTitle());
        textViewDesc.setText(videoData.getDescription());

        NestedScrollView scrollView = (NestedScrollView) findViewById (R.id.nest_scrollview);
        scrollView.setFillViewport (true);

        addViewPager(viewPager);
        viewPager.setOffscreenPageLimit(2);

        tabLayout.setupWithViewPager(viewPager);


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

    private void addViewPager(ViewPager viewPager) {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new KPIVideoFragment(), "VIDEO KPI");
        viewPagerAdapter.addFragment(new RelatedVideoFragment(), "RELATED VIDEOS");
        viewPager.setAdapter(viewPagerAdapter);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {

        List<Fragment> FragmentList = new ArrayList<>();
        List<String> TitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TitleList.get(position);
        }

        @Override
        public int getCount() {
            return FragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            FragmentList.add(fragment);
            TitleList.add(title);
        }
    }
}
