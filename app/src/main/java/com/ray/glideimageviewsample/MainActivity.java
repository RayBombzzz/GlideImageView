package com.ray.glideimageviewsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ray.glideimageviewlib.GlideImageView;
import com.ray.glideimageviewlib.progress.CircleProgressView;

public class MainActivity extends Activity {

    String url = "https://cdn.pixabay.com/photo/2015/09/05/00/37/girl-923573_960_720.jpg";//"https://cdn.pixabay.com/photo/2019/07/22/20/36/mountains-4356017_960_720.jpg";
    private GlideImageView imageView;
    private CircleProgressView progressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (GlideImageView) findViewById(R.id.glide_imageview);
        progressView = (CircleProgressView) findViewById(R.id.progressView);

        imageView.error(R.mipmap.image_load_err).centerCrop().diskCacheStrategy(DiskCacheStrategy.NONE)
                .load(url,R.color.placeholder,(isComplete, percentage, bytesRead, totalBytes) -> {

                    if (isComplete) {
                       progressView.setVisibility(View.GONE);
                    } else {
                        progressView.setVisibility(View.VISIBLE);
                        progressView.setProgress(percentage);
                    }
                });
    }
}
