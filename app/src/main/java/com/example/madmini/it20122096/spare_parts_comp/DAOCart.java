package com.example.madmini.it20122096.spare_parts_comp;

import com.example.madmini.it20122096.models.Cart;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOCart {

    private DatabaseReference databaseReference;

    public DAOCart() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Cart.class.getSimpleName());
    }

    public Task<Void> add(Cart cart) {
        return databaseReference.push().setValue(cart);
    }

}
