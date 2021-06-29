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
import android.widget.ListView;

import java.util.ArrayList;

import nguyenthitrucgiang.com.dafastfoodstore.adapter.HoaDonAdapter;
import nguyenthitrucgiang.com.dafastfoodstore.data.DBManager;
import nguyenthitrucgiang.com.dafastfoodstore.model.HoaDon;

public class Bill extends AppCompatActivity {
    ArrayList<HoaDon> arrayHoadon = new ArrayList<HoaDon>();
    HoaDonAdapter adapter;
    Cursor cursor;
    DBManager db;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        ActionBar ab;
        ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.rgb(22, 175, 244)));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setLogo(R.mipmap.ic_launcher);
        ab.setDisplayUseLogoEnabled(true);

        ab.setDisplayHomeAsUpEnabled(true);
        lv = (ListView)findViewById(R.id.lv_hd);
        db = new DBManager(this);
        display();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                Intent in = new Intent(Bill.this, deatailBill.class);
                in.putExtra("CTHD", adapter.getItem(arg2));
                startActivity(in);
            }
        });
    }
    public void display(){

        cursor = db.getAllHoaDon();
        if (adapter==null){
            while (cursor.moveToNext()){
                arrayHoadon.add(new HoaDon(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
            }
            adapter = new HoaDonAdapter(this, R.layout.item_list_hoadon, arrayHoadon);
            lv.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }

    }
    //@Override
    /*public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hoa_don, menu);
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
    }*/
}
