package com.example.fitnessrink;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    private  static int SPLASH_SCREEN=5000;

    Animation Top,Bottom;
    ImageView Image;
    TextView Logo,Slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        Top= AnimationUtils.loadAnimation(Splash.this,R.anim.top_animation);
        Bottom= AnimationUtils.loadAnimation(Splash.this,R.anim.bottom_animation);

        Image=findViewById(R.id.imageView);
        Logo=findViewById(R.id.textView);
        Slogan=findViewById(R.id.textView2);


        Image.setAnimation(Top);
        Logo.setAnimation(Bottom);
        Slogan.setAnimation(Bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent IO=new Intent(Splash.this,Login.class);

                Pair [] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(Image,"logo_image");
                pairs[1] = new Pair<View,String>(Logo,"logo_text");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Splash.this,pairs);
                    startActivity(IO,options.toBundle());
                }


            }
        },SPLASH_SCREEN);

    }
}
