package com.example.dialogflowbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Home_Activity extends AppCompatActivity {
    RecyclerView recyclerView;

    String s1[],s2[],s3[];
    int images[] ={R.drawable.meditation,R.drawable.yummy,R.drawable.exercise,R.drawable.sleep,R.drawable.travel,R.drawable.shinebot,R.drawable.alert2};
    int main_images[] = {R.drawable.mainmeditation,R.drawable.mainfood,R.drawable.mainexercise,R.drawable.mainsleep,R.drawable.mainnature};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.Relieving_Techniques);
        s2 = getResources().getStringArray(R.array.Describing_Techniques);
        s3 = getResources().getStringArray(R.array.fulldescription);
        MyAdapter myAdapter = new MyAdapter(this,s1,s2,s3,images,main_images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}