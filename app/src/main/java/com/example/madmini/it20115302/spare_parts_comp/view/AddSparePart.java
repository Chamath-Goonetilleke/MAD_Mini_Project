package com.example.madmini.it20115302.spare_parts_comp.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.madmini.R;

import com.example.madmini.it20115302.spare_parts_comp.controller.DAOSpareParts;
import com.example.madmini.it20115302.spare_parts_comp.model.SparePart;
import com.example.madmini.it20122096.DashBoard;
//import com.example.madmini.it20115302.SparePart;

public class AddSparePart extends AppCompatActivity {

    // attributes
    private EditText editName;
    private EditText editBrand;
    private EditText editModel;
    private EditText editPrice;
    private EditText editDesc;

    private Button btnSubmit;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_spare_part);

        // set action bar
        ActionBar actionBar= getSupportActionBar();
        actionBar.setTitle("Add Spare Part");

        // set resources
        editName = findViewById(R.id.edit_name);
        editBrand = findViewById(R.id.edit_brand);
        editModel = findViewById(R.id.edit_model);
        editPrice = findViewById(R.id.edit_price);
        editDesc = findViewById(R.id.edit_desc);
        btnSubmit = findViewById(R.id.btn_add);
        btnCancel = findViewById(R.id.btn_cancel_add);

        DAOSpareParts dao = new DAOSpareParts();

        btnSubmit.setOnClickListener( view -> {
            String regexStr = "^[0-9]*$";
            if (this.isEmpty(editName) || this.isEmpty(editBrand) || this.isEmpty(editModel) || this.isEmpty(editPrice) || this.isEmpty(editDesc)){
                Toast.makeText(AddSparePart.this, "Please fill mandatory fields", Toast.LENGTH_SHORT).show();
            }
            else if(!editPrice.getText().toString().trim().matches(regexStr))
            {
                Toast.makeText(AddSparePart.this, "Please enter valid price", Toast.LENGTH_SHORT).show();
            }
            else {
                SparePart sparePart = new SparePart(
                        editName.getText().toString(),
                        editBrand.getText().toString(),
                        editModel.getText().toString(),
                        Double.parseDouble(editPrice.getText().toString()),
                        editDesc.getText().toString());

                dao.add(sparePart).addOnSuccessListener( success -> {
                    Toast.makeText(this, "Spare Part Inserted", Toast.LENGTH_SHORT).show();

                    // TODO: set the correct direction
                    Intent intent = new Intent(AddSparePart.this, DashBoard.class);
                    startActivity(intent);
                    finish();
                }).addOnFailureListener( error -> {
                    Toast.makeText(this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }

        });

        btnCancel.setOnClickListener(view -> {
            Intent intent = new Intent(AddSparePart.this, DashBoard.class);
            startActivity(intent);
            finish();
        });

        editName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        editModel.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        editBrand.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        editDesc.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        editPrice.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}