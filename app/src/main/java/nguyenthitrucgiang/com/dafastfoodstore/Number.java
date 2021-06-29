package nguyenthitrucgiang.com.dafastfoodstore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import nguyenthitrucgiang.com.dafastfoodstore.adapter.SPsaphetAdapter;
import nguyenthitrucgiang.com.dafastfoodstore.data.DBManager;
import nguyenthitrucgiang.com.dafastfoodstore.model.SanPham;

public class Number extends AppCompatActivity {
    ArrayList<SanPham> arraySanpham = new ArrayList<SanPham>();
    SPsaphetAdapter adapter;
    Cursor cursor;
    DBManager dbmanager;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        ActionBar ab;
        ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.rgb(22, 175, 244)));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setLogo(R.mipmap.ic_launcher);
        ab.setDisplayUseLogoEnabled(true);

        ab.setDisplayHomeAsUpEnabled(true);
        lv = (ListView)findViewById(R.id.lv_sphh);
        dbmanager = new DBManager(this);
        displaySP();
    }
    public void displaySP(){
        cursor = dbmanager.Saphethang();
        while (cursor.moveToNext()){
            arraySanpham.add(new SanPham(cursor.getString(0), cursor.getInt(1)));
        }
        adapter = new SPsaphetAdapter(this, R.layout.item_list_sanpham, arraySanpham);
        lv.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.spsaphet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}