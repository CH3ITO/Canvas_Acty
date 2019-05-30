package com.cambas_activity.cambas_activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public static class MyCanvas extends View {
        public MyCanvas(Context context) {
            super(context);
        }
        public MyCanvas(Context context, AttributeSet attrs) {
            super(context, attrs);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
        //    drawDemo(canvas);
        drawTablero(canvas);
        drawCaratula(canvas);
        }

        private void drawDemo(Canvas canvas) {
            int maxX = canvas.getWidth();
            int maxY = canvas.getHeight();
            Paint paint = new Paint();
            paint.setColor(Color.rgb(255, 0, 0)); // Pincel con color rojo
            paint.setStyle(Paint.Style.STROKE); // Para pintar solo bordes o todo el contenido
            paint.setStrokeWidth(20f); //Ancho del borde en pixeles
            // Calculamos el centro del canvas
            float centerX = maxX / 2;
            float centerY = maxY / 2;
            //dibuja solo borde de un rectangulo color verde
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.rgb(0, 255, 0));
            canvas.drawRect(0, 0, centerX, centerY, paint);
            //dibuja todo rectangulo color azul
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.rgb(0, 0, 255));
            canvas.drawRect(centerX, centerY, maxX, maxY, paint);
            // Dibuja una linea
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.CYAN);
            canvas.drawLine(0, 0, centerX, centerY, paint);
            // Dibuja un circulo
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.YELLOW);
            canvas.drawCircle(centerX, centerY, 50, paint);
        }
        private void drawCaratula(Canvas canvas) {
            Paint mPaint = new Paint();
            //mPaint.setAntiAlias(true);
            mPaint.setColor(Color.BLUE);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(10f);
            float maxW = canvas.getWidth();
            float maxH = canvas.getHeight();
            float offset = 30;
            //ARRIBA
            for (int i = 0; i < maxW; i += offset) {
                canvas.drawLine(
                        maxW - i,
                        0,
                        0,
                        i,
                        mPaint);
            }
            //ABAJO
            for (int i = 0; i < maxW; i += offset) {
                canvas.drawLine(i,maxH,maxW,maxH - i, mPaint);
            }
        }
        private void drawTablero(Canvas canvas) {
            int maxW = canvas.getWidth();
            int maxH = canvas.getHeight();
            float centerX = maxW / 8;
            float centerY = maxH /8;
            Paint mPaint = new Paint();
            mPaint.setColor(Color.BLUE);
            mPaint.setStyle(Paint.Style.FILL);
            Random random = new Random();
            int q=0;
            int c=1;
            int c2=1;
            for (int j=0;j<maxH;j+=centerY)
            {
                for (int i = 0; i < maxW; i += centerX) {
                    if (c % 2 == 0) {
                        mPaint.setColor(Color.WHITE);
                        canvas.drawRect(i, j, centerX + i, centerY+j, mPaint);
                        c = c + 1;
                    }
                    else {
                       int val1=random.nextInt(255);
                        int val2=random.nextInt(255);
                        int val3=random.nextInt(255);
                        mPaint.setColor(Color.rgb(val1,val2,val3));
                        //mPaint.setColor(Color.YELLOW);
                        canvas.drawRect(i, j, centerX + i, centerY+j, mPaint);
                        c = c + 1;
                    }
                }
                c=c+1;
            }
        }
    }
}