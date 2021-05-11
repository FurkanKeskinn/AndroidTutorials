package com.nexis.androidtutorials;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class ContextMenuActivity extends AppCompatActivity {

    private EditText edit1,edit2;
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       switch (v.getId()) {
           case R.id.editText_ContextMenu1:
               this.getMenuInflater().inflate(R.menu.color_menu, menu);
               break;

           case R.id.editText_ContextMenu2:
               this.getMenuInflater().inflate(R.menu.font_menu, menu);
               break;


       }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            //Color Menüsü
            case R.id.color_menu_blue:
                edit1.setTextColor(Color.BLUE);
                break;

            case R.id.color_menu_green:
                edit1.setTextColor(Color.GREEN);
                break;

            case R.id.color_menu_red:
                edit1.setTextColor(Color.RED);
                break;

                //Font Menüsü
            case R.id.font_color_f1:
                edit2.setTextSize(13);
                break;

            case R.id.font_color_f2:
                edit2.setTextSize(17);
                break;

            case R.id.font_color_f3:
                edit2.setTextSize(23);
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

         edit1 = (EditText)findViewById(R.id.editText_ContextMenu1);
         edit2 = (EditText)findViewById(R.id.editText_ContextMenu2);

        this.registerForContextMenu(edit1);
        this.registerForContextMenu(edit2);
    }
}