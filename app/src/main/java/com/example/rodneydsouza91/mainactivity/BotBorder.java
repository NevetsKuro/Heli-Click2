package com.example.rodneydsouza91.mainactivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by rodneydsouza91 on 27-02-2017.
 */
public class BotBorder extends GameObject {
    private Bitmap image;
    public BotBorder(Bitmap res, int x, int y)
    {
        height = 200;
        width = 20;

        this.x = x;
        this.y = y;
        dx = Panel.MOVESPEED;

        image = Bitmap.createBitmap(res, 0, 0, width, height);

    }
    public void update()
    {
        x +=dx;

    }
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image, x, y, null);

    }

}
