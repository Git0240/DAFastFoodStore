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

import nguyenthitrucgiang.com.dafastfoodstore.adapter.CTHoaDonAdapter;
import nguyenthitrucgiang.com.dafastfoodstore.data.DBManager;
import nguyenthitrucgiang.com.dafastfoodstore.model.ChiTietHoaDon;
import nguyenthitrucgiang.com.dafastfoodstore.model.HoaDon;

public class deatailBill extends AppCompatActivity {

    ArrayList<ChiTietHoaDon> arrCTHD = new ArrayList<ChiTietHoaDon>();
    CTHoaDonAdapter adapter;
    Cursor cursor;
    DBManager db;
    ListView lv;
    String mhd;
    HoaDon hoadon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatail_bill);

        ActionBar ab;
        ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.rgb(22, 175, 244)));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setLogo(R.mipmap.ic_launcher);
        ab.setDisplayUseLogoEnabled(true);

        ab.setDisplayHomeAsUpEnabled(true);

        lv = (ListView)findViewById(R.id.lv_cthd);

        db = new DBManager(this);
        getData();
        display();
    }
    public void getData(){
        if (getIntent().getExtras()!=null){
            hoadon = (HoaDon) getIntent().getSerializableExtra("CTHD");
            mhd = String.valueOf(hoadon.getmMaHD());
        }
    }
    public void display(){

        cursor = db.getAllCTHoaDon(mhd);
        if (adapter==null){
            while (cursor.moveToNext()){
                arrCTHD.add(new ChiTietHoaDon(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5)));
            }
            adapter = new CTHoaDonAdapter(this, R.layout.item_list_cthoadon, arrCTHD);
            lv.setAdapter(adapter);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chi_tiet_hd, menu);
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