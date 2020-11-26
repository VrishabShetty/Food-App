package com.example.project;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;


public class MyAnimator
{

    public static void animation(Context context, ImageView mImageView, int delay) {
        Animation stb = AnimationUtils.loadAnimation(context,R.anim.stb);
        stb.setStartOffset(delay);
        mImageView.startAnimation(stb);
    }

    public static void animation(Context context, Toolbar toolbar, int delay) {
        Animation ttb = AnimationUtils.loadAnimation(context,R.anim.ttb);
        ttb.setStartOffset(delay);
        toolbar.startAnimation(ttb);
    }

    public static void animation(Context context , View view,int delay) {
        Animation stb = AnimationUtils.loadAnimation(context,R.anim.stb);
        stb.setStartOffset(delay);
        view.startAnimation(stb);
    }

    public static void getImageCornerRounded(Resources resources, ImageView mImageView) {

        Bitmap mBitmap=((BitmapDrawable) resources.getDrawable(R.drawable.pizza)).getBitmap();
        Bitmap imageRounded=Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), mBitmap.getConfig());
        Canvas canvas=new Canvas(imageRounded);
        Paint mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setShader(new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect((new RectF(0, 0, mBitmap.getWidth(), mBitmap.getHeight())), 50, 50, mPaint); // Round Image Corner 100 100 100 100
        mImageView.setImageBitmap(imageRounded);
    }
}
