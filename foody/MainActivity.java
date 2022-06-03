package hcmute.tranhoanglong.foody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        NavController navController = Navigation.findNavController(findViewById(R.id.nav_fragment));
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}