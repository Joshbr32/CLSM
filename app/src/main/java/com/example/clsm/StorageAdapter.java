package com.example.clsm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class StorageAdapter extends RecyclerView.Adapter<StorageAdapter.StorageViewHolder>{

    Context context;
    ArrayList<Forms> forms;


    public StorageAdapter(FormStorageActivity ct, ArrayList<Forms> storageObj) {
        context = ct;
        forms = storageObj;
    }


    @NonNull
    @Override
    public StorageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.storage_row, parent, false);
        return new StorageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StorageViewHolder holder, int position) {

        Forms tempForm = forms.get(position);
        holder.setFormDataLabels(tempForm);
        boolean ts = true;
        boolean ws = true;


        /*



         */

    }

    @Override
    public int getItemCount() {
        return forms.size();
    }

    public class StorageViewHolder extends RecyclerView.ViewHolder{

        TextView storage_form_type, storage_form_main_identifier, storage_form_date;
        ConstraintLayout storageLayout;
        CheckBox showTimesheets, showWorksheets;

        public StorageViewHolder(@NonNull View itemView) {
            super(itemView);

            storage_form_type = itemView.findViewById(R.id.storage_form_type);
            storage_form_main_identifier = itemView.findViewById(R.id.storage_form_main_identifier);
            storage_form_date = itemView.findViewById(R.id.storage_form_date);

            storageLayout = itemView.findViewById(R.id.storageLayout);

            showTimesheets = itemView.findViewById(R.id.formstorage_form_type_timesheet_button);
            showWorksheets = itemView.findViewById(R.id.formstorage_form_type_worksheet_button);
        }

        public void setFormDataLabels(Forms form){
            storage_form_type.setText(form.getType());
            storage_form_main_identifier.setText(form.getMainIdentifier());
            storage_form_date.setText(form.getDate());

        }
    }


}