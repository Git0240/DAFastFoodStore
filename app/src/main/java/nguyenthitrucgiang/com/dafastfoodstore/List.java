package nguyenthitrucgiang.com.dafastfoodstore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import nguyenthitrucgiang.com.dafastfoodstore.adapter.DanhMucAdapter;
import nguyenthitrucgiang.com.dafastfoodstore.data.DBManager;
import nguyenthitrucgiang.com.dafastfoodstore.model.DanhMuc;

public class List extends AppCompatActivity {
    Button btnThemDM, btnBack;
    Cursor cursor;
    ArrayList<DanhMuc> arrDM = new ArrayList<DanhMuc>();
    DanhMucAdapter adapter;
    ListView lv;
    DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ActionBar ab;
        ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.rgb(22, 175, 244)));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setLogo(R.mipmap.ic_launcher);
        ab.setDisplayUseLogoEnabled(true);

        ab.setDisplayHomeAsUpEnabled(true);
        btnThemDM = findViewById(R.id.ibtnAddDM);
        btnBack = findViewById(R.id.ibtnBacksp);
        lv = (ListView)findViewById(R.id.lv_SP);
        dbManager = new DBManager(this);
        display();
        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), products.class);
                startActivity(i);
            }
        });
        btnThemDM.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),addList.class);
                startActivity(i);
            }
        });
    }
    public void display() {
        cursor = dbManager.SELECT_ALL_DANHMUC();
		/*
		String[] from = new String[]{dbManager.ID,dbManager.TEN_DANHMUC};
		int[] to  = new int[]{R.id.tv_Id,R.id.tv_tendm};
		adapter = new SimpleCursorAdapter(DanhMucActivity.this, R.layout.item_list_danhmuc, cursor, from, to, 0);
		dbManager.CloseDB();
		*/
        if (adapter == null) {
            while (cursor.moveToNext()) {

                arrDM.add(new DanhMuc(cursor.getInt(0), cursor.getString(1)));
            }
            adapter = new DanhMucAdapter(this, R.layout.item_list_danhmuc, arrDM);
            lv.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }
}