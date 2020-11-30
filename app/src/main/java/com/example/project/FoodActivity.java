package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class FoodActivity extends AppCompatActivity {

    private static final String EXTRA_FOOD_ID = "food id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        UUID id = (UUID) getIntent().getSerializableExtra(EXTRA_FOOD_ID);
        Food mFood = Foods.get().getFood(id);

        ImageView image = findViewById(R.id.image_food);
        TextView text = findViewById(R.id.text_food);
        TextView price = findViewById(R.id.price);
        Button visit = findViewById(R.id.visit);
        TextView name = findViewById(R.id.food_name);
        Button button = findViewById(R.id.add);

        if (mFood.getImage() != null)
            image.setImageResource(mFood.getImage());

        if (mFood.getName() != null)
            name.setText(mFood.getName());

        if (mFood.getPrice() != 0.0) {
            String s = ("Rs " +mFood.getPrice());
            price.setText(s);
        }

        if (mFood.getDes() != null)
            text.setText(mFood.getDes());

        button.setEnabled(!mFood.isInCart());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Toast.makeText(FoodActivity.this,"Your item is added to compare",Toast.LENGTH_SHORT).show();
                mFood.setInCart(true);
                Foods.get().add(mFood);
                button.setEnabled(false);
            }
        });

        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(mFood.getURL()));
                startActivity(intent);
            }
        });
    }

    public static Intent newIntent(Context context, UUID id)
    {
        Intent intent = new Intent(context,FoodActivity.class);
        intent.putExtra(EXTRA_FOOD_ID,id);
        return intent;
    }

//    private void getImageCornerRounded(ImageView mImageView,Integer image) {
//        mImageView.setImageResource(image);
//        Bitmap mBitmap=((BitmapDrawable) getResources().getDrawable(image)).getBitmap();
//        Bitmap imageRounded=Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), mBitmap.getConfig());
//        Canvas canvas=new Canvas(imageRounded);
//        Paint mPaint=new Paint();
//        mPaint.setAntiAlias(true);
//        mPaint.setShader(new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
//        canvas.drawRoundRect((new RectF(0, 0, mBitmap.getWidth(), mBitmap.getHeight())), 50, 50, mPaint); // Round Image Corner 100 100 100 100
//        mImageView.setImageBitmap(imageRounded);
//    }

}