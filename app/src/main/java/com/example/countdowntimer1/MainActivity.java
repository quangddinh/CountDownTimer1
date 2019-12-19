package com.example.countdowntimer1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int [] mArrayImages = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
    };
    ImageView mImageView1;
    Button mButtonView1;
    int mCount = 0;
    boolean mIsLoading = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView1 = findViewById(R.id.imageView1);
        mButtonView1 = findViewById(R.id.buttonView1);

        mButtonView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIsLoading) {
                    return;
                }
                mIsLoading = true;
                CountDownTimer countDownTimer = new CountDownTimer((mArrayImages.length * 1000) + 1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mImageView1.setImageResource(mArrayImages[mCount++]);
                    }

                    @Override
                    public void onFinish() {
                        mCount = 0;
                        this.start();
                    }
                };
                countDownTimer.start();
            }
        });



    }
}
