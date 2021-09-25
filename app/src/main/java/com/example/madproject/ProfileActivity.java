package com.example.madproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    ImageButton imgHomeBtn;
    ImageButton imgCart;
    ImageButton imgProfile;
    TextView viewEmail;
    Button editProfile;
    Button wishlist;
    Button admin;
    Button addressBook;
    ImageView logout;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Profile");

        imgHomeBtn = findViewById(R.id.imageButtonHome);
        imgCart = findViewById(R.id.imageButtonCart);
        imgProfile = findViewById(R.id.imageButtonProfile);
        viewEmail = findViewById(R.id.textViewEmailDisplay);
        editProfile = findViewById(R.id.buttonEditProfile);
        wishlist = findViewById(R.id.buttonWishList);
        addressBook = findViewById(R.id.buttonAddressBook);
        logout = findViewById(R.id.imageViewLogOut);
        admin = findViewById(R.id.buttonAdmin);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        viewEmail.setText(firebaseUser.getEmail());
        String uit = firebaseUser.getUid().toString();
        if(uit.equals("OFY5xaJt4dgvV0vaYcU7dttw63v2")){
            admin.setVisibility(Button.VISIBLE);
        }else{
            admin.setVisibility(Button.GONE);
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                Toast.makeText(ProfileActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, EditProfileActivity.class));

            }
        });

        addressBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, AddressBookActivity.class));
                finish();
            }
        });


        imgHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
        });
        imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, CartActivity.class));
            }
        });


    }
}