package com.example.madmini.it20122096;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.madmini.R;
import com.example.madmini.it20122096.BulidPc;
import com.example.madmini.it20122096.spare_parts_comp.AddSparePart;
import com.example.madmini.it20122096.spare_parts_comp.ShowSpareParts;
import com.example.madmini.it20122096.spare_parts_comp.ViewAllSpareParts;

public class DashBoard extends AppCompatActivity {

    ImageButton laptop,parts,build,profile;
    Button addSparePart, manageSparePart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        laptop =(ImageButton) findViewById(R.id.laptop_btn);
        parts =(ImageButton) findViewById(R.id.parts_btn);
        build =(ImageButton) findViewById(R.id.build_btn);
        profile =(ImageButton) findViewById(R.id.profile_btn);

        addSparePart = findViewById(R.id.btn_add_spare);
        manageSparePart = findViewById(R.id.btn_manage_spare);


        build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              startActivity(new Intent(getApplicationContext(), BulidPc.class));

            }
        });

        parts.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ShowSpareParts.class);
            startActivity(intent);
        });

        addSparePart.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AddSparePart.class);
            startActivity(intent);
        });

        manageSparePart.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ViewAllSpareParts.class);
            startActivity(intent);
        });
    }
}