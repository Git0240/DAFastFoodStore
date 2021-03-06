package nguyenthitrucgiang.com.dafastfoodstore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import nguyenthitrucgiang.com.dafastfoodstore.adapter.SanPhamAdapter;
import nguyenthitrucgiang.com.dafastfoodstore.data.DBManager;
import nguyenthitrucgiang.com.dafastfoodstore.model.SanPham;

public class createOrderForm extends AppCompatActivity {

    ArrayList<SanPham> arraySP = new ArrayList<SanPham>();
    SanPhamAdapter adapter;
    Cursor cursor;
    Button Purchase;
    DBManager dbmanager;
    TextView txttest;
    ListView lv;
    Integer tongtien = 0;
    Integer sosanpham;
    String ngay;
    int[] slsp;
    String[] tenspchon;
    int[]dongia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order_form);

        txttest = (TextView) findViewById(R.id.txtTest);
        Purchase = (Button) findViewById(R.id.btnThanhtoan);
        lv = (ListView) findViewById(R.id.lv_chonsp);

        ActionBar ab;
        ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.rgb(22, 175, 244)));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setLogo(R.mipmap.ic_launcher);
        ab.setDisplayUseLogoEnabled(true);

        ab.setDisplayHomeAsUpEnabled(true);

        dbmanager = new DBManager(this);
        display();
        sosanpham = lv.getAdapter().getCount();
        slsp = new int[sosanpham];
        tenspchon = new String[sosanpham];
        dongia = new int[sosanpham];
        ngay = dbmanager.ngaythang();
        txttest.setText(dbmanager.ngaythang());
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                TextView textview = (TextView) arg1.findViewById(R.id.tv_giasp_list);
                TextView textview2 = (TextView) arg1
                        .findViewById(R.id.lv_Soluong);
                TextView textview3 = (TextView) arg1
                        .findViewById(R.id.tv_tensp_list);
                String ten = textview3.getText().toString().trim();
                int text = Integer.parseInt(textview.getText().toString());
                int soluongsp = Integer.parseInt(textview2.getText().toString());

                if(soluongsp>0){
                    tongtien = tongtien + text;

                    solanchon(arg2);
                    tenchon(arg2, ten);
                    dongiasp(arg2, text);
                    int sll = soluongsp - 1;
                    textview2.setText(String.valueOf(sll));
                    String sl = String.valueOf(slsp[arg2]);
                    //Toast.makeText(getApplicationContext(), sl, Toast.LENGTH_SHORT)
                    //.show();
                } else {
                    Toast.makeText(createOrderForm.this, "H???t h??ng!", Toast.LENGTH_SHORT).show();}

                txttest.setText(String.valueOf(tongtien));

            }
        });
        Purchase.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                AlertDialog.Builder dialog =	new AlertDialog.Builder(createOrderForm.this);
                dialog.setTitle("THANH TO??N?");
                dialog.setMessage("B???n th???t s??? mu???n thanh to??n?");
                dialog.setPositiveButton("Thanh to??n", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO Auto-generated method stub
                        dbmanager.ThemHoaDon(ngay, tongtien);
                        String mahd = String.valueOf(dbmanager.LayMaHD());
                        for (int i = 0; i < sosanpham; i++) {
                            dbmanager.UpdateSanPham(slsp[i], tenspchon[i]);
                            dbmanager.ThemCTHoaDon(mahd, tenspchon[i], slsp[i], dongia[i], slsp[i]*dongia[i]);
                            Toast.makeText(createOrderForm.this, "Giao d???ch th??nh c??ng!", Toast.LENGTH_SHORT).show();
                            Intent intenttt = new Intent(getApplicationContext(), managerpage.class);
                            startActivity(intenttt);
                        }
                    }
                }).setNegativeButton("H???y", null).show();

            }
        });
    }
    public String[] tenchon(int i, String ten) {
        tenspchon[i] = ten;
        return tenspchon;
    }

    public int[] solanchon(int i) {

        slsp[i] = slsp[i] + 1;
        return slsp;


    }
    public int[] dongiasp(int a, int b){
        dongia[a] = b;
        return dongia;

    }
    public void display() {
        cursor = dbmanager.getAllSanPham();
        while (cursor.moveToNext()) {
            arraySP.add(new SanPham(cursor.getInt(0), cursor.getString(1),
                    cursor.getString(2), cursor.getInt(3), cursor.getInt(4),
                    cursor.getBlob(5)));
        }
        adapter = new SanPhamAdapter(this, R.layout.item_list_sanpham, arraySP);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tao_don_hang, menu);
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