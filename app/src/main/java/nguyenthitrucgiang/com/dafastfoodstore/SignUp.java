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
import nguyenthitrucgiang.com.dafastfoodstore.model.Users;

public class SignUp extends AppCompatActivity {

    DBManager dbManager;
    EditText txtUsername;
    EditText txtPassword;
    Button btnSave, btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ActionBar ab;
        ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.rgb(184, 45, 255)));

        dbManager = new DBManager(this);
        txtUsername = (EditText) findViewById(R.id.txtUsername_User);
        txtPassword = (EditText) findViewById(R.id.txtPassword_User);
        btnClear = (Button)findViewById(R.id.btnGiamgia);
        btnSave = (Button) findViewById(R.id.btnLogin);

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Users users = createUser();
                if (users != null) {
                    dbManager.adduser(users);
                    Toast.makeText(SignUp.this, "Tạo tài khoản thành công!", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(getApplicationContext(), login.class);
                    startActivity(in);
                }
            }

        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtUsername.setText("");
                txtPassword.setText("");
                txtUsername.requestFocus();
            }
        });
    }
    private Users createUser() {
        String name = txtUsername.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();

        Users users = new Users(name, password);
        return users;
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