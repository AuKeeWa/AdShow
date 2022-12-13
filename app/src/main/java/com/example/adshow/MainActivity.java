package com.example.adshow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Dialog dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = MainActivity.this;
        dia = new Dialog(context, R.style.edit_AlertDialog_style);
        dia.setContentView(R.layout.activity_start_dialog);


        ImageView imageView = (ImageView) dia.findViewById(R.id.start_img);
        imageView.setBackgroundResource(R.mipmap.iv_android);
        dia.show();

        dia.setCanceledOnTouchOutside(false); // Sets whether this dialog is
        Window w = dia.getWindow();
        WindowManager.LayoutParams lp = w.getAttributes();
        lp.x = 0;
        lp.y = 40;
        dia.onWindowAttributesChanged(lp);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = event.getX();
                float y = event.getY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_DOWN:
                        Log.i("Test", "x: " + x + "  " + "y: " + y);
                        if (920 <= x && x <= 1000 && 50 <= y && y <= 140) {//在cross范围内
                            Log.i("test", "i am cross");
                            Log.i("Test", "x: " + x + "  " + "y: " + y);
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }/* else if ((800 <= x && x < 920 && 0 <= y && y < 200) || (x > 1000 && 0 <= y && y < 200) ||
                                ((920 <= x && x <= 1000) && (y <= 50 || 100 <= y && y < 200))) {
                            Log.i("test", "i am green block");
                            break;
                        }*/ else {
                            Log.i("test", "i am open");
                            Intent intent = new Intent(MainActivity.this, AdActivity.class);
                            startActivity(intent);
                            break;
                        }
                    default:
                        break;
                }
                return false;
            }
        });

    }


}