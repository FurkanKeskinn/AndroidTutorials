package com.nexis.androidtutorials.MyBookListActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.nexis.androidtutorials.R;

import static com.nexis.androidtutorials.MyBookListActivity.BooksAdapter.*;

public class MyBookListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private BooksAdapter adapter;
    static public BookDetail bookDetail;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.add_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_menu_add_book){
            //Intent Geçiş
            Intent addBookIntent = new Intent(this, AddBookActivity.class);
            startActivity(addBookIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_book_list);
        mRecyclerView =(RecyclerView)findViewById(R.id.my_book_listRecyclerView);
        adapter = new BooksAdapter(Books.getData(this), this);

        mRecyclerView.setHasFixedSize(true);
        GridLayoutManager manager = new GridLayoutManager(this, 1);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new GridManagerDecoration());
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Books books) {
            bookDetail = new BookDetail(books.getKitapAdi(), books.getKitapYazari(), books.getKitapOzeti(), books.getKitapResim());

            Intent detailIntent = new Intent(MyBookListActivity.this,MyBookListDetailsActivity.class);
            finish();
            startActivity(detailIntent);

            }
        });
        }

        private class GridManagerDecoration extends RecyclerView.ItemDecoration{
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.bottom = 15;
            }
        }
}