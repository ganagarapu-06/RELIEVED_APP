package com.example.dialogflowbot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[],data2[],data3[];
    int images[];
    int main_images[];
    Context context;
    public MyAdapter(Context ct, String s1[], String s2[], String s3[],int img[] ,int mainimages[]){
        context=ct;
        data1=s1;
        data2=s2;
        data3=s3;
        images=img;
        main_images=mainimages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mytext1.setText(data1[position]);
        holder.mytext2.setText(data2[position]);
        holder.myimage1.setImageResource(images[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0){
                    Intent intent = new Intent(context, Meditation_Activity.class);

                    context.startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent(context,Exercise_Activity.class);
                    intent.putExtra("data1",data1[position]);
                    intent.putExtra("data3",data3[position]);
                    intent.putExtra("mainimageView",main_images[position]);
                    context.startActivity(intent);
                }
                else if(position==2){
                    Intent intent = new Intent(context, Food_Activity.class);
                    intent.putExtra("data1",data1[position]);
                    intent.putExtra("data3",data3[position]);
                    intent.putExtra("mainimageView",main_images[position]);
                    context.startActivity(intent);
                }
                else if(position==3){
                    Intent intent = new Intent(context, Sleep_Activity.class);
                    intent.putExtra("data1",data1[position]);
                    intent.putExtra("data3",data3[position]);
                    intent.putExtra("mainimageView",main_images[position]);
                    context.startActivity(intent);
                }
                else if(position==4){
                    Intent intent = new Intent(context, Nature_Activity.class);
                    intent.putExtra("data1",data1[position]);
                    intent.putExtra("data3",data3[position]);
                    intent.putExtra("mainimageView",main_images[position]);
                    context.startActivity(intent);
                }
                else if(position==5){
                    Intent intent = new Intent(context, Shinebot_Activity.class);
                    intent.putExtra("data1",data1[position]);
                    intent.putExtra("data3",data3[position]);
                    intent.putExtra("mainimageView",main_images[position]);
                    context.startActivity(intent);
                }
                else {
                    Intent intent = new Intent(context, Alert_Activity.class);
                    intent.putExtra("data1",data1[position]);
                    intent.putExtra("data3",data3[position]);
                    intent.putExtra("mainimageView",main_images[position]);
                    context.startActivity(intent);
                }
            }

        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView  mytext1,mytext2;
        ImageView myimage1;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mytext1 = itemView.findViewById(R.id.mytext1);
            mytext2 = itemView.findViewById(R.id.mytext2);
            myimage1 = itemView.findViewById(R.id.myimage1);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
