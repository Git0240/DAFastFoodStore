package nguyenthitrucgiang.com.dafastfoodstore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import nguyenthitrucgiang.com.dafastfoodstore.adapter.SanPhamAdapter;
import nguyenthitrucgiang.com.dafastfoodstore.data.DBManager;
import nguyenthitrucgiang.com.dafastfoodstore.model.SanPham;

public class manaProducts extends AppCompatActivity {

    Button ibtAddnewSP, ibtnback;
    ArrayList<SanPham> arraySanpham = new ArrayList<SanPham>();
    SanPhamAdapter adapter;
    Cursor cursor;
    DBManager dbmanager;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mana_products);

        ActionBar ab;
        ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.rgb(22, 175, 244)));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setLogo(R.mipmap.ic_launcher);
        ab.setDisplayUseLogoEnabled(true);

        ab.setDisplayHomeAsUpEnabled(true);
        lv = (ListView)findViewById(R.id.lv_SP);
        ibtAddnewSP = findViewById(R.id.ibnThemHang);
        ibtnback=findViewById(R.id.ibtnQlspback);
        dbmanager = new DBManager(this);
        displaySP();
        ibtnback.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), products.class);
                startActivity(i);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(manaProducts.this, editProduct.class);
                intent.putExtra("Edit", adapter.getItem(arg2));
                startActivity(intent);
            }
        });
        ibtAddnewSP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), addProduct.class);
                startActivity(i);
            }
        });
    }
    public void displaySP(){
        cursor = dbmanager.getAllSanPham();
        while (cursor.moveToNext()){
            arraySanpham.add(new SanPham(cursor.getInt(0),cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getBlob(5)));
        }
        adapter = new SanPhamAdapter(this, R.layout.item_list_sanpham, arraySanpham);
        lv.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.qlsan_pham, menu);
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