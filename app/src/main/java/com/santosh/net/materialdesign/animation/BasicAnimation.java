package com.santosh.net.materialdesign.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.santosh.net.materialdesign.R;

public class BasicAnimation extends AppCompatActivity {

    Button btnFadeIn, btnFadeOut, btnCrossFade, btnBlink, btnZoomIn,
            btnZoomOut, btnRotate, btnMove, btnSlideUp, btnSlideDown,
            btnBounce, btnSequential, btnTogether;
    Animation animFadeIn, animFadeOut, animBlink, animZoomIn, animZoomOut, animRotate, animMove, animSlideUp, animSlideDown, animBounce, animSequential, animTogether, animCrossFadeIn, animCrossFadeOut;
    TextView txtFadeIn, txtFadeOut, txtBlink, txtZoomIn, txtZoomOut, txtRotate, txtMove, txtSlideUp,
            txtSlideDown, txtBounce, txtSeq, txtTog, txtIn, txtOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_basic);

        btnFadeIn = findViewById(R.id.btnFadeIn);
        btnFadeOut = findViewById(R.id.btnFadeOut);
        btnCrossFade = findViewById(R.id.btnCrossFade);
        btnBlink = findViewById(R.id.btnBlink);
        btnZoomIn = findViewById(R.id.btnZoomIn);
        btnZoomOut = findViewById(R.id.btnZoomOut);
        btnRotate = findViewById(R.id.btnRotate);
        btnMove = findViewById(R.id.btnMove);
        btnSlideUp = findViewById(R.id.btnSlideUp);
        btnSlideDown = findViewById(R.id.btnSlideDown);
        btnBounce = findViewById(R.id.btnBounce);
        btnSequential = findViewById(R.id.btnSequential);
        btnTogether = findViewById(R.id.btnTogether);
        txtFadeIn = findViewById(R.id.txt_fade_in);
        txtFadeOut = findViewById(R.id.txt_fade_out);
        txtBlink = findViewById(R.id.txt_blink);
        txtZoomIn = findViewById(R.id.txt_zoom_in);
        txtZoomOut = findViewById(R.id.txt_zoom_out);
        txtRotate = findViewById(R.id.txt_rotate);
        txtMove = findViewById(R.id.txt_move);
        txtSlideUp = findViewById(R.id.txt_slide_up);
        txtSlideDown = findViewById(R.id.txt_slide_down);
        txtBounce = findViewById(R.id.txt_bounce);
        txtSeq = findViewById(R.id.txt_seq);
        txtTog = findViewById(R.id.txt_tog);
        txtIn = findViewById(R.id.txt_in);
        txtOut = findViewById(R.id.txt_out);
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        /*
         * Buttons click events
         */
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        // fade in
        btnFadeIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                txtFadeIn.setVisibility(View.VISIBLE);
                txtFadeIn.startAnimation(animFadeIn);
            }
        });

        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_out);

        // fade out
        btnFadeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtFadeOut.setVisibility(View.VISIBLE);
                txtFadeOut.startAnimation(animFadeOut);
            }
        });
        animCrossFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        animCrossFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_out);
        // cross fade
        btnCrossFade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtOut.setVisibility(View.VISIBLE);
                // start fade in animation
                txtOut.startAnimation(animCrossFadeIn);

                // start fade out animation
                txtIn.startAnimation(animCrossFadeOut);
            }
        });
        animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
        // blink
        btnBlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtBlink.setVisibility(View.VISIBLE);
                txtBlink.startAnimation(animBlink);
            }
        });

        animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_in);
        // Zoom In
        btnZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtZoomIn.setVisibility(View.VISIBLE);
                txtZoomIn.startAnimation(animZoomIn);
            }
        });
        animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_out);
        // Zoom Out
        btnZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtZoomOut.setVisibility(View.VISIBLE);
                txtZoomOut.startAnimation(animZoomOut);
            }
        });
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);

        // Rotate
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtRotate.startAnimation(animRotate);
            }
        });
        animMove = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.move);
        // Move
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMove.startAnimation(animMove);
            }
        });
        animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);
        // Slide Up
        btnSlideUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSlideUp.startAnimation(animSlideUp);
            }
        });
        animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);
        // Slide Down
        btnSlideDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSlideDown.startAnimation(animSlideDown);
            }
        });
        animBounce = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bounce);
        // Slide Down
        btnBounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtBounce.startAnimation(animBounce);
            }
        });
        animSequential = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.sequential);
        // Sequential
        btnSequential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtSeq.startAnimation(animSequential);
            }
        });
        animTogether = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.together);

        // Together
        btnTogether.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTog.startAnimation(animTogether);
            }
        });

    }
}
