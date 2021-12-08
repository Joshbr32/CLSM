package com.example.clsm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.InventoryViewHolder>{

    String data1[], data2[];
    Context context;

    public InventoryAdapter(Context ct, String s1[], String s2[]){
        context = ct;
        data1 = s1;
        data2 = s2;
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
        holder.object_name.setText(data1[position]);
        holder.object_count.setText(data2[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class InventoryViewHolder extends RecyclerView.ViewHolder{

        TextView object_name, object_count;

        public InventoryViewHolder(@NonNull View itemView) {
            super(itemView);
            object_name = itemView.findViewById(R.id.inventory_object_name);
            object_count = itemView.findViewById(R.id.inventory_object_count);
        }
    }
}
