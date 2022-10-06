package com.firstapp.portrait_mode_to_landscape_mode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Currency;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    DataAdapter dataAdapter;
//    TextView diplay;

    ArrayList<DataModel> dataModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        diplay=findViewById(R.id.redghfsd);


        recyclerView=findViewById(R.id.recylcer_view_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        dataModelArrayList = new ArrayList<>();
        recyclerView.setHasFixedSize(true);

//        dataAdapter=new DataAdapter(this,dataModelArrayList);
//        recyclerView.setAdapter(dataAdapter);

        Cursor cursor=new HelperClass(this).readallData();
        dataModelArrayList=new ArrayList<>();

        while(cursor.moveToNext())
        {
            DataModel dataModel=new DataModel(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
            dataModelArrayList.add(dataModel);

            dataAdapter=new DataAdapter(this,dataModelArrayList);
           recyclerView.setAdapter(dataAdapter);
//

        }

//        dataAdapter=new DataAdapter(this,dataModelArrayList);
//        recyclerView.setAdapter(dataAdapter);
//



        floatingActionButton=findViewById(R.id.add_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDilaogFragment popup=new MyDilaogFragment();
                popup.show(getSupportFragmentManager(),"popup");




            }
        });

    }
}