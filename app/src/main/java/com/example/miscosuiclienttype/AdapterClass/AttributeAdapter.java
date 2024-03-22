package com.example.miscosuiclienttype.AdapterClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miscosuiclienttype.ModalDataClass.AttributeModalClass;
import com.example.miscosuiclienttype.R;

import java.util.List;

public class AttributeAdapter extends RecyclerView.Adapter<AttributeAdapter.ViewHolder> {
    private List<AttributeModalClass> attributeList;

    public AttributeAdapter(List<AttributeModalClass> attributeList) {
        this.attributeList = attributeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_attribute, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AttributeModalClass attribute = attributeList.get(position);

        // Set the text for the attributeTextView
        holder.attributeTextView.setText(attribute.getAttributeName());

        // Set up the Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(holder.itemView.getContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Add hint and options to the adapter
        String hint = holder.itemView.getResources().getString(R.string.LOALOI);
        String male = holder.itemView.getResources().getString(R.string.LOA);
        String female = holder.itemView.getResources().getString(R.string.LOI);
        adapter.add(hint);
        adapter.add(male);
        adapter.add(female);

        // Set the adapter for the autocomplete Spinner
        holder.autocomplete.setAdapter(adapter);

        // Set attribute name for accessibility
        holder.autocomplete.setContentDescription(attribute.getAttributeName());
    }


    @Override
    public int getItemCount() {
        return attributeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView attributeTextView;
        Spinner autocomplete;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.context = context;
            attributeTextView = itemView.findViewById(R.id.idNecessaryAttributes);
            autocomplete = itemView.findViewById(R.id.autocomplete);
        }
    }



}

