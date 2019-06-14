package com.example.headydemo.Adapters;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.headydemo.Models.BookModel;
import com.example.headydemo.R;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {

    Context context;
    List<BookModel> bookList;

    public BooksAdapter(Context context, List<BookModel> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_layout, parent, false);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        BookModel book = bookList.get(position);
        if(book.getMultimedia() != null && book.getMultimedia().size() > 0) {
            Glide.with(context)
                    .load(book.getMultimedia().get(4).getUrl())
                    .into(holder.imageView);
        }else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                holder.imageView.setBackground(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
            }
        }

        holder.textView.setText(book.getTitle());
    }

    @Override
    public int getItemCount() {
        // item count is the number of rows in recycler view
        return bookList.size();
    }

    class BooksViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public BooksViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
