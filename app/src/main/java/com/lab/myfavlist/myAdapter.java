package com.lab.myfavlist;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myAdapter extends RecyclerView.ViewHolder {
    TextView textInf;

    public myAdapter(@NonNull View itemView) {
        super(itemView);
        textInf=itemView.findViewById(R.id.txtDisplay);
    }
}
