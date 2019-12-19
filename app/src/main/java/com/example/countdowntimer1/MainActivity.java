package com.example.countdowntimer1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    int [] mArrayImages = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
    };

    Button mButtonView1;
    ViewFlipper mViewFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonView1 = findViewById(R.id.buttonView1);
        mViewFlipper = findViewById(R.id.viewflipper);

        for (int i = 0; i < mArrayImages.length ; i++ ){
            ImageView imageView = new ImageView(this);
//                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
//                        mViewFlipper.getLayoutParams().height,
//                        mViewFlipper.getLayoutParams().width
//                );
//            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(mArrayImages[i]);
            mViewFlipper.addView(imageView);
        }


         mButtonView1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (mViewFlipper.isFlipping()){
                     return;
                 }
                 mViewFlipper.setFlipInterval(1000);
                 mViewFlipper.startFlipping();
             }
         });




    }
}
