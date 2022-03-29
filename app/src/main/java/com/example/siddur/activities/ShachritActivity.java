package com.example.siddur.activities;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import com.example.siddur.R;
import java.util.ArrayList;

public class ShachritActivity extends AppCompatActivity {

    private NestedScrollView scrlvw;
    private TextView txtvw;
    private ScaleGestureDetector scaleGestureDetector;
    private ArrayList<TextView> textViews = new ArrayList<TextView>();

    public SharedPreferences sharedPref;
    public static final String TEXT_SIZE = "textSize";
    public float product = 30;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shachrit);

        setupToolbar();

        setupVariables();

        loadTextSize();

        setupListener();

        addViews();

        updateViews();
    }

    private void setupListener() {
        scrlvw.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getPointerCount() > 1) {
                    scrlvw.requestDisallowInterceptTouchEvent(true);
                    scaleGestureDetector.onTouchEvent(event);
                    return true;
                }
                return false;
            }
        });
    }

    private void addViews() {
        textViews.add(findViewById(R.id.shachrit1));
        textViews.add(findViewById(R.id.shachrit2));
        textViews.add(findViewById(R.id.shachrit3));
        textViews.add(findViewById(R.id.shachrit4));
        textViews.add(findViewById(R.id.shachrit5));
        textViews.add(findViewById(R.id.shachrit6));
        textViews.add(findViewById(R.id.shachrit7));
        textViews.add(findViewById(R.id.shachrit8));
        textViews.add(findViewById(R.id.shachrit9));
        textViews.add(findViewById(R.id.shachrit10));
        textViews.add(findViewById(R.id.shachrit11));
        textViews.add(findViewById(R.id.shachritYaaleh));
        textViews.add(findViewById(R.id.shachritAlHanissim));
    }

    private void setupVariables() {
        sharedPref = getSharedPreferences("my_shared_pref", MODE_PRIVATE);
        txtvw = findViewById(R.id.shachrit1);
        scrlvw = findViewById(R.id.shachritScrollView);
        scaleGestureDetector = new ScaleGestureDetector(this, new simpleOnScaleGestureListener());
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void saveTextSize() {

        sharedPref.edit().putFloat(TEXT_SIZE, product).apply();
    }

    private void loadTextSize() {
        product = sharedPref.getFloat(TEXT_SIZE, 30);
    }

    private void updateViews() {
        for (TextView v: textViews) {
            v.setTextSize(TypedValue.COMPLEX_UNIT_PX, product);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public class simpleOnScaleGestureListener extends
            ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            // TODO Auto-generated method stub
            float size = txtvw.getTextSize();
            Log.d("TextSizeStart", String.valueOf(size));

            float factor = detector.getScaleFactor();
            Log.d("Factor", String.valueOf(factor));

            product = size * factor;
            Log.d("TextSize", String.valueOf(product));

            if (product > 140) {
                product = 140;
            }
            if (product < 60) {
                product = 60;
            }

            // save size to sharedPreferences
            saveTextSize();

            // change for all textviews
            updateViews();

            size = txtvw.getTextSize();
            Log.d("TextSizeEnd", String.valueOf(size));
            return true;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if ( item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}