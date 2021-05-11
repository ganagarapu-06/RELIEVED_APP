package com.bae.relieved;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    public CardView meditation,yoga,nutrition,sleep,nature,shine,interact,faq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        meditation=(CardView) findViewById(R.id.meditation);
        yoga=(CardView) findViewById(R.id.yoga);
        nutrition=(CardView) findViewById(R.id.nutrition);
        sleep=(CardView) findViewById(R.id.sleep);
        nature=(CardView) findViewById(R.id.nature);
        shine=(CardView) findViewById(R.id.shine);
        interact=(CardView) findViewById(R.id.interact);
        faq=(CardView) findViewById(R.id.faq);


        meditation.setOnClickListener(this);
        yoga.setOnClickListener(this);
        nutrition.setOnClickListener(this);
        sleep.setOnClickListener(this);
        nature.setOnClickListener(this);
        shine.setOnClickListener(this);
        interact.setOnClickListener(this);
        faq.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()){
            case R.id.meditation:
                i=new Intent(this,MeditationActivity.class);
                startActivity(i);
                break;
            case R.id.yoga:
                i= new Intent(this,YogaActivity.class);
                startActivity(i);
                break;
            case R.id.nutrition:
                i=new Intent(this,NutritionActivity.class);
                startActivity(i);
                break;
            case R.id.sleep:
                i= new Intent(this,SleepActivity.class);
                startActivity(i);
                break;
            case R.id.nature:
                i=new Intent(this,NatureActivity.class);
                startActivity(i);
                break;
            case R.id.shine:
                i= new Intent(this,ShineBotActivity.class);
                startActivity(i);
                break;
            case R.id.interact:
                i=new Intent(this,InteractActivity.class);
                startActivity(i);
                break;
            case R.id.faq:
                i= new Intent(this,FAQActivity.class);
                startActivity(i);
                break;
        }



    }
}