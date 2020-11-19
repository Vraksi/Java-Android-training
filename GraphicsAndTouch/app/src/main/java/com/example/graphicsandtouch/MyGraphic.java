package com.example.graphicsandtouch;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;

import androidx.annotation.Nullable;

public class MyGraphic extends View implements View.OnTouchListener, Runnable
{
    int screenWidth, screenHeight;
    int xPos = 100, yPos = 100;
    int radius = 50;
    int prevX, prevY;
    Boolean moving = false;
    ////////////////////////////////////////
    int pcDrawX = 100, pcDrawY = 100;
    int pcDrawDeltaX = 10, pcDrawDeltaY = 10;

    public MyGraphic(Context context) {
        super(context);
        this.setOnTouchListener(this);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenWidth = w;
        screenWidth = h;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        Paint paint = new Paint();
        paint.setColor(0xFF00FF00); //Color.GREEN

        canvas.drawCircle(xPos, yPos, radius, paint);
        paint.setTextSize(screenWidth/10);
        paint.setColor(0x12343FFF);
        canvas.drawText("hej med jer",250, 500, paint);

        ///////////////////////////////////////////////////

        Drawable pcDraw = getResources().getDrawable(R.drawable.pc18);
        int pcDrawW = pcDraw.getMinimumWidth();
        int pcDrawH = pcDraw.getMinimumHeight();
        pcDraw.setBounds(pcDrawX, pcDrawY, pcDrawX + pcDrawW/2, pcDrawY + pcDrawH/2);
        pcDraw.draw(canvas);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int newX = (int)event.getX();
        int newY = (int)event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
            {
                int deltaX = xPos - newX;
                int deltaY = yPos - newY;
                int r2 = (int)Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
                if(r2 <= radius)
                {
                    moving = true;
                    prevX = newX;
                    prevY = newY;
                }
                break;
            }
            case MotionEvent.ACTION_MOVE:
            {
                if (moving)
                {
                    xPos += newX - prevX;
                    yPos += newY - prevY;
                    prevX = newX;
                    prevY = newY;

                    invalidate();
                }
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                moving = false;
                break;
            }
        }

        return true;
    }


    @Override
    public void run()
    {
        while(true)
        {
            pcDrawX += pcDrawDeltaX;
            pcDrawY += pcDrawDeltaY;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            postInvalidate();
        }
    }
}
