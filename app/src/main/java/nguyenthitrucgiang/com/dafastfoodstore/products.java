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
import android.widget.ImageButton;

public class products extends AppCompatActivity {

    Button btnDanhMuc;
    Button btnSanPham;
    Button btnSanphamsaphet;
    /*ImageButton ibtnback;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        btnDanhMuc = (Button) findViewById(R.id.btnDanhMuc_SanPham);
        btnSanPham = (Button)findViewById(R.id.btnSanPham_SP);
        btnSanphamsaphet = (Button)findViewById(R.id.btnGiamgia);
        ActionBar ab;
        ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.rgb(22, 175, 244)));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setLogo(R.mipmap.ic_launcher);
        ab.setDisplayUseLogoEnabled(true);

        ab.setDisplayHomeAsUpEnabled(true);
        /*ibtnback = (ImageButton)findViewById(R.id.ibtnbacksanpham);
        ibtnback.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), managerpage.class);
                startActivity(i);
            }
        }); */
        btnDanhMuc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), List.class);
                startActivity(i);
            }
        });
        btnSanPham.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), manaProducts.class);
                startActivity(i);
            }
        });
        btnSanphamsaphet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent b = new Intent(getApplicationContext(), Number.class);
                startActivity(b);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.san_pham, menu);
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