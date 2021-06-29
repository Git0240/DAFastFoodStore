package nguyenthitrucgiang.com.dafastfoodstore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab;
        ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.rgb(22, 175, 244)));

        Thread bamgio = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (Exception e) {
                    // TODO: handle exception
                } finally {
                    Intent i = new Intent(getApplicationContext(),
                            login.class);
                    startActivity(i);
                }
            }
        };
        bamgio.start();
    }
    protected void onPause() {
        super.onPause();
        finish();
    }

}