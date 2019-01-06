package com.example.jahanveenarang.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Watch extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    private static final int RECOVERY_DIALOG_REQUEST = 1;

    Context context = this ;
    // YouTube player view
    private YouTubePlayerView youTubeView1 , youTubeView2 , youTubeView3, youTubeView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_watch);

        youTubeView1 = findViewById(R.id.youtube_view);
       youTubeView2 = findViewById(R.id.youtube_view2);
       youTubeView3  =findViewById(R.id.youtube_view3);
       youTubeView4  = findViewById(R.id.youtube_view4);

        // Initializing video player with developer key
        youTubeView1.initialize(Config.DEVELOPER_KEY , (YouTubePlayer.OnInitializedListener) this);
        youTubeView2.initialize(Config.DEVELOPER_KEY , (YouTubePlayer.OnInitializedListener) this);
        youTubeView3.initialize(Config.DEVELOPER_KEY , (YouTubePlayer.OnInitializedListener) this);
        youTubeView4.initialize(Config.DEVELOPER_KEY , (YouTubePlayer.OnInitializedListener) this);

    }
//
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    getString(R.string.error_player), errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {

            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
            player.cueVideo(Config.YOUTUBE_VIDEO_CODE);

            // Hiding player controls
            player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization
            // user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.DEVELOPER_KEY, (YouTubePlayer.OnInitializedListener) this);
        }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }

}
