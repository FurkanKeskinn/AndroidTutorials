package com.nexis.androidtutorials;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FruitsAdapter extends RecyclerView.Adapter<FruitsAdapter.FruitsHolder> {
    private ArrayList<Fruits> fruitsList;
    private Context context;
    private OnItemClickListener listener;

    public FruitsAdapter(ArrayList<Fruits> fruitsList, Context context) {
        this.fruitsList = fruitsList;
        this.context = context;

    }

    @NonNull
    @Override
    public FruitsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fruit_item, parent,false);
        return new FruitsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitsAdapter.FruitsHolder holder, int position) {
    Fruits fruits = fruitsList.get(position);
    holder.setData(fruits);
    }

    @Override
    public int getItemCount() {
        return fruitsList.size();
    }

    class FruitsHolder extends RecyclerView.ViewHolder{
        TextView fruitName, fruitCalorie;
        ImageView fruitFoto;


        public FruitsHolder(@NonNull View itemView) {
            super(itemView);
            fruitName = (TextView)itemView.findViewById(R.id.fruit_item_textViewFruitName);
            fruitCalorie = (TextView)itemView.findViewById(R.id.fruit_item_textViewFruitCalorie);
            fruitFoto = (ImageView)itemView.findViewById(R.id.fruit_item_imageViewFruitFoto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION)
                        listener.OnItemClick(fruitsList.get(position), position);
                }
            });
        }

        public void setData(Fruits fruits){
            this.fruitName.setText(fruits.getFruitName());
            this.fruitCalorie.setText(String.valueOf(fruits.getFruitCalorie()));
            this.fruitFoto.setBackgroundResource(fruits.getFruitFoto());
        }
    }

    public interface OnItemClickListener{
        void OnItemClick(Fruits fruits, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;

    }
}
