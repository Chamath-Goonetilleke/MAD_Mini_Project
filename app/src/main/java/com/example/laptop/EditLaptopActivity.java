package com.example.laptop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class EditLaptopActivity extends AppCompatActivity {
    private TextView edtBrandName,edtProcessor,edtHdd,edtVga,edtOther,edtPrice,edtRam,edtSsd;
    private ImageView edtImage;
    private Button btnSave, btnDelete;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private String lapId;
    private LaptopRVModel laptopRVModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_laptop);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        edtBrandName =  findViewById(R.id.BrandName);
        edtProcessor =  findViewById(R.id.Processor);
        edtHdd =  findViewById(R.id.Hdd);
        edtVga =  findViewById(R.id.Vga);
        edtOther =  findViewById(R.id.Other);
        edtPrice =  findViewById(R.id.Price);
        edtRam =  findViewById(R.id.Ram);
        edtSsd =  findViewById(R.id.Ssd);
        edtImage =  findViewById(R.id.image);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Laptops");

        laptopRVModel = getIntent().getParcelableExtra("laptop");
        if(laptopRVModel != null){
            edtBrandName.setText(laptopRVModel.getName());
            edtProcessor.setText(laptopRVModel.getProcessor());
            edtHdd.setText(laptopRVModel.getHdd());
            edtVga.setText(laptopRVModel.getVga());
            edtOther.setText(laptopRVModel.getOther());
            edtPrice.setText(laptopRVModel.getPrice());
            edtRam.setText(laptopRVModel.getRam());
            edtSsd.setText(laptopRVModel.getSsd());
            Picasso.get().load(laptopRVModel.getImage()).into(edtImage);
            lapId = laptopRVModel.getLaptopId();
        }
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Laptops").child(lapId);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtBrandName.getText().toString();
                String price = edtPrice.getText().toString();
                String processor = edtProcessor.getText().toString();
                String vga = edtVga.getText().toString();
                String other = edtOther.getText().toString();
                String ram = edtRam.getText().toString();
                String ssd = edtSsd.getText().toString();
                String hdd = edtHdd.getText().toString();
                String image = laptopRVModel.getImage();

                Map<String,Object> map = new HashMap<>();
                map.put("name",name);
                map.put("price",price);
                map.put("processor",processor);
                map.put("vga",vga);
                map.put("other",other);
                map.put("ram",ram);
                map.put("ssd",ssd);
                map.put("hdd",hdd);
                map.put("image",image);
                map.put("laptopId",lapId);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.updateChildren(map);
                        Toast.makeText(EditLaptopActivity.this,"Laptop Updated..",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(EditLaptopActivity.this, ViewActivity.class));
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(EditLaptopActivity.this,"Failed to Updated Laptop..",Toast.LENGTH_SHORT).show();
                    }
                });
                btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteItem();
                    }
                });
            }
        });
    }
    private void deleteItem(){
        databaseReference.setValue(null);
        databaseReference.removeValue();
        Toast.makeText(this,"Laptop Deleted...",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(EditLaptopActivity.this,ViewActivity.class));
    }
}