package hcmute.tranhoanglong.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText editTextTaiKhoan, editTextMatKhau, editTextMatKhau2, editTextTen;
    Button buttonDangki;
    ImageView imageViewBack;
    Database db = new Database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editTextTaiKhoan = findViewById(R.id.editTextTaiKhoan);
        editTextMatKhau = findViewById(R.id.editTextMatKhau);
        editTextMatKhau2 = findViewById(R.id.editTextMatKhau2);
        editTextTen = findViewById(R.id.editTextTen);
        buttonDangki = findViewById(R.id.buttonDangki);
        imageViewBack = findViewById(R.id.imageViewBackSignUp);

        buttonDangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = editTextTen.getText().toString().trim();
                String taikhoan = editTextTaiKhoan.getText().toString().trim();
                String matkhau = editTextMatKhau.getText().toString().trim();
                String matkhau2 = editTextMatKhau2.getText().toString().trim();
                String checkTK = null;
                if(ten.equals("")||taikhoan.equals("")||matkhau.equals("")||matkhau2.equals(""))
                {
                    Toast.makeText(SignUpActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(matkhau.equals(matkhau2)) {
                        Cursor dataUser=db.GetData("Select * From TaiKhoan Where TenTaiKhoan = '" + taikhoan + "'");
                        while (dataUser.moveToNext()) {
                            checkTK=dataUser.getString(2);
                        }
                        if (checkTK != null) {
                            Toast.makeText(SignUpActivity.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                        } else {
                            db.QueryData("INSERT INTO TaiKhoan VALUES(null, '"+ten+"','"+ taikhoan+"','"+ matkhau+"','','')");
                            Intent intent=new Intent(SignUpActivity.this, LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText(SignUpActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                    else {
                        Toast.makeText(SignUpActivity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }
}