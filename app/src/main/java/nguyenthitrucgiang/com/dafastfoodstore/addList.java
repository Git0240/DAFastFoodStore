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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import nguyenthitrucgiang.com.dafastfoodstore.data.DBManager;
import nguyenthitrucgiang.com.dafastfoodstore.model.DanhMuc;

public class addList extends AppCompatActivity {

    DBManager dbManager;
    EditText txtThemDM;
    Button btnLuu;
    Button ibtnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);

        ActionBar ab;
        ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.rgb(22, 175, 244)));
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setLogo(R.mipmap.ic_launcher);
        ab.setDisplayUseLogoEnabled(true);

        ab.setDisplayHomeAsUpEnabled(true);
        dbManager = new DBManager(this);
        txtThemDM = (EditText) findViewById(R.id.txtTenSP_ThemSP);
        btnLuu = (Button) findViewById(R.id.btnSaveDM);
        ibtnback = findViewById(R.id.ibtnbackthemdm);
        ibtnback.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

            }
        });

        btnLuu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                DanhMuc dm = createList();
                if (dm != null ){
                    dbManager.addDanhmuc(dm);
                }
                Toast.makeText(addList.this, "Th??m th??nh c??ng", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), List.class);
                startActivity(i);
            }

        });
    }
    private DanhMuc createList() {
        String tenDM = txtThemDM.getText().toString().trim();
        DanhMuc dm = new DanhMuc(tenDM);
        return dm;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.them_danh_muc, menu);
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