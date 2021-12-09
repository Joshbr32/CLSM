package com.example.clsm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class StorageAdapter extends RecyclerView.Adapter<StorageAdapter.InventoryViewHolder>{

    Context context;
    ArrayList<InventoryActivity.inventoryObject>inventoryObjects;


    public StorageAdapter(InventoryActivity ct, ArrayList<InventoryActivity.inventoryObject> invObjects) {
        context = ct;
        inventoryObjects = invObjects;
    }


    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.inventory_row, parent, false);
        return new InventoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryViewHolder holder, int position) {

        InventoryActivity.inventoryObject tempInventoryObject = inventoryObjects.get(position);

        holder.setObject_name(tempInventoryObject);
        holder.updateCount(tempInventoryObject);

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempInventoryObject.addCount();
                holder.updateCount(tempInventoryObject);
            }
        });
        holder.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempInventoryObject.subCount();
                holder.updateCount(tempInventoryObject);
            }
        });

    }

    @Override
    public int getItemCount() {
            return inventoryObjects.size();
    }

    public class InventoryViewHolder extends RecyclerView.ViewHolder{

        TextView object_name, object_count;
        ConstraintLayout inventoryLayout;
        Button add, sub;

        public InventoryViewHolder(@NonNull View itemView) {
            super(itemView);
                object_name = itemView.findViewById(R.id.storage_form_type);
                object_count = itemView.findViewById(R.id.inventory_object_count);

                inventoryLayout = itemView.findViewById(R.id.inventoryLayout);
                add = inventoryLayout.findViewById(R.id.add_object_count);
                sub = inventoryLayout.findViewById(R.id.sub_object_count);
        }
        public void setObject_name(InventoryActivity.inventoryObject invObject){
            object_name.setText(invObject.getObjectName());
        }

        public void updateCount(InventoryActivity.inventoryObject invObject){
            object_count.setText(invObject.getObjectCount());
        }
    }


}