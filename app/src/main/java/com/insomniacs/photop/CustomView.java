package com.insomniacs.photop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by INSODROID1 on 27-03-2018.
 */

public class CustomView extends View {

    Bitmap userImage;
    int width;
    int height;

    public CustomView(Context context) {
        super(context);
        init(context, null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void init(Context context, @Nullable AttributeSet attrs) {

    }

    public void setBitmap(Bitmap bitmap) {
        this.userImage = bitmap;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        if (userImage != null) {


            Rect rect = new Rect(0, 0, width, height);
            canvas.drawBitmap(userImage, null, rect, null);

            Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.test);
            Rect rect2 = new Rect(0, height - (20 * height) / 100, width, height);
            canvas.drawBitmap(image, null, rect2, null);


            Bitmap owlImage = BitmapFactory.decodeResource(getResources(), R.drawable.owl);
            Rect rect3 = new Rect(width - (10 * width) / 100, (5 * height) / 100, width, (10 * height) / 100);
            canvas.drawBitmap(owlImage, null, rect3, null);

        }
    }
}
