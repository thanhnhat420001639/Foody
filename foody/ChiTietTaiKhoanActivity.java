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

public class ChiTietTaiKhoanActivity extends AppCompatActivity {
    EditText editTextTen, editTextMatKhau, editTextSDT, editTextEmail;
    Button buttonCapNhat;
    ImageView imageViewBack;
    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_tai_khoan);

        editTextTen = findViewById(R.id.editTextTen);
        editTextMatKhau = findViewById(R.id.editTextMatKhauCT);
        editTextSDT = findViewById(R.id.editTextSDT);
        editTextEmail = findViewById(R.id.editTextEmail);
        imageViewBack = findViewById(R.id.imageViewBackCTTaiKhoan);
        buttonCapNhat = findViewById(R.id.buttonCapNhat);

        Cursor dataUser = db.GetData("Select * From TaiKhoan Where TenTaiKhoan = '"+Global.getTenTaiKhoan()+"'");
        while (dataUser.moveToNext())
        {
            editTextTen.setText( dataUser.getString(1));
            editTextMatKhau.setText( dataUser.getString(2));
            editTextSDT.setText( dataUser.getString(3));
            editTextEmail.setText( dataUser.getString(4));
        }

        buttonCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = editTextTen.getText().toString().trim();
                String matkhau = editTextMatKhau.getText().toString().trim();
                String SDT = editTextSDT.getText().toString().trim();
                String Email = editTextEmail.getText().toString().trim();
                if(ten.equals("")||matkhau.equals("")||SDT.equals("")||Email.equals(""))
                {
                    Toast.makeText(ChiTietTaiKhoanActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.QueryData("UPDATE TaiKhoan SET Ten = '"+ten+"',MatKhau = '"+matkhau+"',SDT = '"+SDT+"',Email = '"+Email+"' WHERE TenTaiKhoan = '"+Global.getTenTaiKhoan()+"'");
                    Toast.makeText(ChiTietTaiKhoanActivity.this, "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(ChiTietTaiKhoanActivity.this, ChiTietTaiKhoanActivity.class);
                    startActivity(intent);
                }


            }
        });

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChiTietTaiKhoanActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}