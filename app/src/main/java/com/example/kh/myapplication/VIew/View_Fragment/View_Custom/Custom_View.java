package com.example.kh.myapplication.VIew.View_Fragment.View_Custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;

import com.example.kh.myapplication.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by kh on 5/18/2017.
 */

public class Custom_View extends View {

    private Paint paintCircle;
    private Paint paintrect;
    private float cx;
    private float cy;
    private float radius=100f;
    private Bitmap bitmap;
    private Rect rect;

    public Custom_View(Context context) {
        super(context);
        Init(null);
    }

    public Custom_View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Init(attrs);
    }

    public Custom_View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init(attrs);
    }

    public Custom_View(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Init(attrs);
    }

    private void  Init(AttributeSet set){
        paintrect = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintrect.setColor(Color.RED);
        paintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.v);

        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(Build.VERSION.SDK_INT>=16){
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }else
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int padding = 100;
                bitmap  = getResizedBitmap(bitmap, getWidth()-padding, getHeight()-padding);
                postInvalidate();
                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        int nh,nw;

                        nh = bitmap.getHeight()-100;
                        nw = bitmap.getWidth()-100;
                        if(nh<=0 || nw <=0){

                            cancel();
                            return;
                        }
                        bitmap  = getResizedBitmap(bitmap, nw,nh);
                        postInvalidate();
                    }
                }, 10001, 2001);
            }
        });
    }

    private Bitmap getResizedBitmap(Bitmap bitmap, int width, int height) {
        Matrix matrix = new Matrix();
        RectF src = new RectF(0,0,bitmap.getWidth(),bitmap.getHeight());
        RectF dst = new RectF(0,0,width, height);
        matrix.setRectToRect(src,dst,Matrix.ScaleToFit.CENTER);
        return Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(), bitmap.getHeight(), matrix,false);
    }
    public  void Swap_Color(){
        paintrect.setColor(paintrect.getColor()==Color.RED?Color.GREEN:Color.RED);
        invalidate();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rect = new Rect();
        rect.top = 100;
        rect.left =100;
        rect.right = rect.left+100;
        rect.bottom = rect.top+100;
        canvas.drawRect(rect, paintrect);
        //draw circle
        if(cx == 0 || cy==0) {
            cy = getHeight() / 2;
            cx = getWidth()/2;
        }
        canvas.drawCircle(cx, cy, radius, paintCircle);
        float hi, wi;
        hi = (getHeight()-bitmap.getHeight())/2;
        wi  = (getWidth()-bitmap.getWidth())/2;
        canvas.drawBitmap(bitmap, wi,hi, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x,y;
        x = event.getX();
        y = event.getY();
        boolean valuel = super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(x>rect.left&&x<rect.right)
                if(y>rect.top && y<rect.bottom){
                        float newwidth, newheight;
                        radius+=100f;
                        postInvalidate();
                    return true;
                    }
                return true;
            case MotionEvent.ACTION_MOVE:
                double dx,dy;
                dx = Math.pow(x-cx,2);
                dy = Math.pow(y-cy,2);
                if(dx+dy<Math.pow(radius,2));{
                cx = x;
                cy = y;
                postInvalidate();
            }
                postInvalidate();

                return true;
        }
        return valuel;
    }

    public static class MyOnclick implements RecyclerView.OnTouchListener {

        public MyOnclick(Context context, myOnclickListener myOnclickListener){

        }
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return false;
        }
    }

   public interface myOnclickListener{
        void onClick(View view, int position);
        void onLongClick(View view, int position);
    }
}
