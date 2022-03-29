package com.example.siddur;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import com.example.siddur.activities.BirchatHamazonActivity;
import com.example.siddur.activities.BritActivity;
import com.example.siddur.activities.CompassActivity;
import com.example.siddur.activities.MaarivActivity;
import com.example.siddur.activities.MeenShaloshActivity;
import com.example.siddur.activities.MinchaActivity;
import com.example.siddur.activities.ShachritActivity;
import com.example.siddur.activities.TfillatHaderechActivity;
import com.example.siddur.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);

        setUpButtonClickListeners();

        setupToolbar();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setUpButtonClickListeners(){
        findViewById(R.id.btnShachrit).setOnClickListener(this);
        findViewById(R.id.btnMincha).setOnClickListener(this);
        findViewById(R.id.btnMaariv).setOnClickListener(this);
        findViewById(R.id.btnBirchatH).setOnClickListener(this);
        findViewById(R.id.btnMeenS).setOnClickListener(this);
        findViewById(R.id.btnTfillatH).setOnClickListener(this);
        findViewById(R.id.btnBritM).setOnClickListener(this);
        findViewById(R.id.btnShachrit).setOnClickListener(this);
        findViewById(R.id.btnCompass).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnShachrit:
                startActivity(new Intent(this, ShachritActivity.class));
                break;
            case R.id.btnMincha:
                startActivity(new Intent(this, MinchaActivity.class));
                break;
            case R.id.btnMaariv:
                startActivity(new Intent(this, MaarivActivity.class));
                break;
            case R.id.btnBirchatH:
                startActivity(new Intent(this, BirchatHamazonActivity.class));
                break;
            case R.id.btnMeenS:
                startActivity(new Intent(this, MeenShaloshActivity.class));
                break;
            case R.id.btnTfillatH:
                startActivity(new Intent(this, TfillatHaderechActivity.class));
                break;
            case R.id.btnBritM:
                startActivity(new Intent(this, BritActivity.class));
                break;
            case R.id.btnCompass:
                startActivity(new Intent(this, CompassActivity.class));
                break;
        }
    }
}