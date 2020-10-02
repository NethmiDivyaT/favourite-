package com.lab.myfavlist;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadpter extends FirebaseRecyclerAdapter<Favourite, myadpter.myviewholder> {

    public myadpter(@NonNull FirebaseRecyclerOptions<Favourite> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myadpter.myviewholder holder, int position, @NonNull Favourite model) {
        holder.txtName.setText(model.getName());
        holder.txtAge.setText(model.getAge());

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView txtName, txtAge;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            /*txtName = itemView.findViewById(R.id.txtName);
            txtAge = itemView.findViewById(R.id.txtAge);*/
        }
    }


}
