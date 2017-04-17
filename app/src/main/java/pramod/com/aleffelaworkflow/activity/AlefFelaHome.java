package pramod.com.aleffelaworkflow.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pramod.com.aleffelaworkflow.R;

public class AlefFelaHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alef_fela_home);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(getApplicationContext(), VideoCategoryActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, 3000);
    }
}
