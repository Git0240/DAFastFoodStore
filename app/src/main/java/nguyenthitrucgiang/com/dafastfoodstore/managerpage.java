package nguyenthitrucgiang.com.dafastfoodstore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class managerpage extends AppCompatActivity {

    Button btnMathang;
    Button btnDonhang;
    Button btnHoadon;
    Button btnThongke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managerpage);

        ActionBar ab;
        ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.rgb(22, 175, 244)));

        btnDonhang = (Button) findViewById(R.id.btnCall_Donhang);
        btnMathang = (Button)findViewById(R.id.btnCall_Mathang);
        btnHoadon = (Button)findViewById(R.id.btnCall_Hoadon);
        btnThongke = (Button)findViewById(R.id.btnCall_CSKH);
        btnDonhang.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent (getApplicationContext(), createOrderForm.class);
                startActivity(i);
            }
        });
        btnHoadon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent (getApplicationContext(), Bill.class);
                startActivity(i);
            }
        });
        btnMathang.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent (getApplicationContext(), products.class);
                startActivity(i);
            }
        });
        btnThongke.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent t = new Intent (getApplicationContext(), statistic.class);
                startActivity(t);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.trangquanly, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}