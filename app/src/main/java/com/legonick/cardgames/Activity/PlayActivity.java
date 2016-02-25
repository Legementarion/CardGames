package com.legonick.cardgames.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.legonick.cardgames.R;

/**
 * Created by Lego on 24.02.2016.
 */
public class PlayActivity extends Activity{
    LinearLayout background = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);
        background = (LinearLayout) findViewById(R.id.background);
//        background.setTileModeX(android.graphics.Shader.TileMode.REPEAT );
    }
}
