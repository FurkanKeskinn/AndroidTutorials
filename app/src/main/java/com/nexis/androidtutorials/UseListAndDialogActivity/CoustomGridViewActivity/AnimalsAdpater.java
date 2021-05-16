package com.nexis.androidtutorials.UseListAndDialogActivity.CoustomGridViewActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nexis.androidtutorials.R;

public class AnimalsAdpater extends ArrayAdapter<String> {
    private String[] animals;
    private int[] fotos;
    private Context context;
    private ImageView animalFoto;
    private TextView animalName;

    public AnimalsAdpater(String[] animals,int[] fotos,Context context){
        super(context, R.layout.animals_item,animals);
        this.animals =animals;
        this.fotos = fotos;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.animals_item, null);

        if(v!=null){
            animalFoto = v.findViewById(R.id.animals_item_imageViewResim);
            animalName = v.findViewById(R.id.animals_item_textViewIsim);

            animalName.setText(animals[position]);
            animalFoto.setBackgroundResource(fotos[position]);

        }
        return v;
    }
}
