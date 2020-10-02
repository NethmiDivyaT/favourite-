package com.lab.myfavlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNote extends AppCompatActivity {

    DatabaseReference dbref;
    Details details;
    Button btnAdd;
    TextView textDetails, textInf;

    private FirebaseRecyclerOptions<Details> options;
    private FirebaseRecyclerAdapter<Details, myAdapter> adapter;

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnAdd = findViewById(R.id.btnAdd);
        textDetails = findViewById(R.id.txtInf);
        textInf = findViewById(R.id.txtDisplay);


        details = new Details();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        Intent intent = getIntent();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbref = FirebaseDatabase.getInstance().getReference().child("Details");

                details.setDetails(textDetails.getText().toString());
                String key = dbref.push().getKey();
                dbref.child(key).child("Details").setValue(details);

                Toast.makeText(getApplicationContext(), "Add your Note Successfully", Toast.LENGTH_SHORT).show();
                clearControls();

            }
        });

        options = new FirebaseRecyclerOptions.Builder<Details>().setQuery(dbref, Details.class).build();
        adapter=new FirebaseRecyclerAdapter<Details, myAdapter>(options) {
            @Override
            protected void onBindViewHolder(@NonNull myAdapter holder, int position, @NonNull Details model) {
              /*holder.textInf.setText(Details);*/
            }

            @NonNull
            @Override
            public myAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_two,parent,false);
                return new myAdapter(view);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);


    }

    private void clearControls() {
        textDetails.setText("");
    }

}