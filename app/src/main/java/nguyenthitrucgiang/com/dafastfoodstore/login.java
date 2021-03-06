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
import android.widget.Toast;

import nguyenthitrucgiang.com.dafastfoodstore.data.DBManager;

public class login extends AppCompatActivity {

    Button btnDangky;
    Button btnDangnhap;
    EditText edtpass;
    EditText edtuser;
    DBManager dbmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbmanager = new DBManager(this);
        btnDangky = (Button) findViewById(R.id.btnRegister);
        btnDangnhap = (Button) findViewById(R.id.btnLogin);
        edtuser = (EditText) findViewById(R.id.txtUsername_Login);
        edtpass = (EditText) findViewById(R.id.txtPassword_Login);

        ActionBar ab;
        ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.rgb(184, 45, 255)));

        if (dbmanager.checkcouser()){
            btnDangky.setVisibility(View.INVISIBLE);
        }
        btnDangky.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),
                        SignUp.class);
                startActivity(i);
            }
        });
        btnDangnhap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String tk = edtuser.getText().toString().trim();
                String mk = edtpass.getText().toString().trim();
                if (dbmanager.checklogin(tk, mk) == true) {
                    Intent i = new Intent(getApplicationContext(), managerpage.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),
                            "????ng nh???p th??nh c??ng", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "T??i kho???n ho???c m???t kh???u kh??ng ????ng, h??y ki???m tra l???i.",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.frm__login, menu);
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