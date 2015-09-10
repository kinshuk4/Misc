package com.thatcodecorner.youtubeplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.youtube.player.YouTubeStandalonePlayer;


/**
 * @author rafal
 */
public class StandAloneActivity extends Activity implements View.OnClickListener {
    public static final String GOOGLE_API_KEY = "";

    public static final String YOUTUBE_VIDEO_ID="PyxLaHmOaYM";
    public static final String YOUTUBE_PLAYLIST_ID="PLfKRHQB97HyDWtiqAphY351YnFrfl5L6u";

    private Button btnPlayVideo;
    private Button btnPlayPlayList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standalone);
        btnPlayVideo = (Button) findViewById(R.id.btnStartVideo);
        btnPlayPlayList = (Button) findViewById(R.id.btnStartList);

        btnPlayVideo.setOnClickListener(this);
        btnPlayPlayList.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent intent = null;
        if(v == btnPlayVideo) {
            //Play a single video
            intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
        } else if(v == btnPlayPlayList) {
            //Play playlist
            intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST_ID);
        }

        if (intent != null) {
            startActivityForResult(intent, 0);
        }
    }

}
