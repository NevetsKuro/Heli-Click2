package com.example.rodneydsouza91.mainactivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by rodneydsouza91 on 25-02-2017.
 */
public class Background {


    private Bitmap image;
    private int x, y, dx;

    public Background(Bitmap res)
    {
        image = res;
    }
    public void update()
    {
        x+=dx;
        if(x<-Panel.WIDTH){
            x=0;
        }
    }
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image, x, y,null);
        if(x<0)
        {
            canvas.drawBitmap(image, x+Panel.WIDTH, y, null);
        }
    }
    public void setVector(int dx)
    {
        this.dx = dx;
    }


}
