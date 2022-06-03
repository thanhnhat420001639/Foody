package hcmute.tranhoanglong.foody;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class AccountFragment extends Fragment
{
    private static final int RESULT_OK=-1;
    LinearLayout linearLayout, logout, linearLayoutCaiDat;
    View view;
    ImageView image_Search;
    TextView textViewTen;
    int REQUEST_CODE_EDIT = 123;
    public AccountFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account, container, false);
        Anhxa();
        if(Global.getTen().equals(""))
        {
            textViewTen.setText("Đăng nhập");
        }
        else{
            textViewTen.setText(Global.getTen());
        }
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textViewTen.getText().equals("Đăng nhập"))
                {
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    //(intent,REQUEST_CODE_EDIT);
                    startActivity(intent);
                }
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                Global.setTen("");
                Global.setTenTaiKhoan("");
                Toast.makeText(getActivity(), "Đã đăng xuất", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        image_Search = (ImageView) view.findViewById(R.id.image_Search);
        image_Search.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        linearLayoutCaiDat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Global.getTen().equals(""))
                {
                    Intent intent = new Intent(getActivity(),ChiTietTaiKhoanActivity.class);
                    //(intent,REQUEST_CODE_EDIT);
                    startActivity(intent);
                }

            }
        });

        return view;
    }
    public void Anhxa()
    {

        linearLayout = (LinearLayout) view.findViewById(R.id.layoutLogin);
        textViewTen = (TextView) view.findViewById(R.id.textViewLogin);
        logout = (LinearLayout) view.findViewById(R.id.logout);
        linearLayoutCaiDat = view.findViewById(R.id.linearLayoutCaiDat);
    }
}