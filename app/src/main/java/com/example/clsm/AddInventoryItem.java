package com.example.clsm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddInventoryItem extends AppCompatActivity {

    String data, name, count, description;
    EditText nameInput, countInput, descriptionInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);

        nameInput = findViewById(R.id.new_item_name_input);
        countInput = findViewById(R.id.new_item_count_input);
        descriptionInput = findViewById(R.id.new_item_description_input);
    }

    public void createItem(View view) {
        name = nameInput.getText().toString();
        count = countInput.getText().toString();
        description = descriptionInput.getText().toString();
        data = "";

        Intent addItem = new Intent(this, InventoryActivity.class);
        startActivity(addItem);

    }
}