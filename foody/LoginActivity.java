package hcmute.tranhoanglong.foody;

import static java.sql.DriverManager.println;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class LoginActivity extends AppCompatActivity {
    ImageView imageView;
    Button buttonDangnhap, buttonDangki;
    EditText editTextTaiKhoan, editTextMatKhau;
    Database db = new Database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        imageView = (ImageView) findViewById(R.id.imageViewBack);
        buttonDangnhap = (Button)findViewById(R.id.buttonDangnhap);
        buttonDangki = (Button)findViewById(R.id.buttonDangkitaikhoan);
        editTextTaiKhoan = (EditText) findViewById(R.id.editTextTaiKhoan);
        editTextMatKhau = (EditText) findViewById(R.id.editTextMatKhau);

        buttonDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taikhoan = editTextTaiKhoan.getText().toString().trim();
                String matkhau = editTextMatKhau.getText().toString().trim();
                String checkTK = null;
                String Ten = null ;
                if(taikhoan.equals("")||matkhau.equals(""))
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Không thể để trống tài khoản hoặc mật khẩu", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    Cursor dataUser = db.GetData("Select * From TaiKhoan Where TenTaiKhoan = '"+taikhoan+"' and MatKhau = '"+matkhau+"'");
                    while (dataUser.moveToNext())
                    {
                        checkTK = dataUser.getString(2);
                        Ten = dataUser.getString(1);
                    }
                    if(checkTK == null){
                        Toast.makeText(LoginActivity.this, "Sai thông tin", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Global.TenTaiKhoan = checkTK;
                        Global.Ten = Ten;
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        finish();
                    }


                }
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buttonDangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}