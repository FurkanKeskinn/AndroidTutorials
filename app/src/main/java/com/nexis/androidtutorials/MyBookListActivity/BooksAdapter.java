package com.nexis.androidtutorials.MyBookListActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nexis.androidtutorials.R;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.booksHolder> {

    private ArrayList<Books> booksList;
    private Context context;
    private OnItemClickListener listener;


    public BooksAdapter(ArrayList<Books> booksList, Context context) {
        this.booksList = booksList;
        this.context = context;
    }

    @NonNull
    @Override
    public booksHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false);
        return new booksHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.booksHolder holder, int position) {

        Books book = booksList.get(position);
        holder.setData(book);

    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

    class booksHolder extends RecyclerView.ViewHolder {
        TextView textBookName, textBookWriter, textBookSummery;
        ImageView imageBookFoto;

        public booksHolder(@NonNull View itemView) {
            super(itemView);

            textBookName = (TextView) itemView.findViewById(R.id.book_item_textViewBookName);
            textBookWriter = (TextView) itemView.findViewById(R.id.book_item_textViewBookWriter);
            textBookSummery = (TextView) itemView.findViewById(R.id.book_item_textViewBookSummery);
            imageBookFoto = (ImageView) itemView.findViewById(R.id.book_item_imageViewBookFoto);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION)
                        listener.onItemClick(booksList.get(position));

                }
            });
        }

        public void setData(Books book) {
            this.textBookName.setText(book.getKitapAdi());
            this.textBookWriter.setText(book.getKitapYazari());
            this.textBookSummery.setText(book.getKitapOzeti());
            this.imageBookFoto.setImageBitmap(book.getKitapResim());
        }
    }

    public interface  OnItemClickListener{
        void onItemClick(Books books);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }


}
