package com.example.headydemo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.example.headydemo.Utils.Constants;
import com.example.headydemo.Utils.DateHelper;

import java.util.Date;
import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {

    private Context context;
    private List<BookModel> bookList;
    private int position;


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

    // binding each ViewHolder with respective data
    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        BookModel book = bookList.get(position);
        this.position = position;
        if(book.getMultimedia() != null && book.getMultimedia().size() > 0) {
            Glide.with(context)
                    .load(book.getMultimedia().get(2).getUrl())
                    .into(holder.imageView);
        }else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                holder.imageView.setBackground(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
            }
        }

        holder.tvBookTitle.setText(book.getTitle());
        if (book.getByline()!= null && !book.getByline().equals("")) {
            holder.tvAuthorName.setText(book.getByline());
        } else {
            holder.tvAuthorName.setText(" NA ");

        }

        Date publishedDate = DateHelper.getDateObj(book.getPublished_date(), Constants.defaultDateFormate);
        holder.tvPublishedDate.setText(DateHelper.getDateString(publishedDate,Constants.defaultDateFormate));
        holder.tvBookAbstract.setText(book.getAbstractText());
    }

    @Override
    public int getItemCount() {
        // item count is the number of rows in recycler view
        return bookList.size();
    }

    class BooksViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvBookTitle;
        TextView tvAuthorName;
        TextView tvPublishedDate;
        TextView tvMoreDetails;
        TextView tvBookAbstract;


        public BooksViewHolder(final View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvAuthorName = itemView.findViewById(R.id.tv_author_name);
            tvPublishedDate = itemView.findViewById(R.id.tv_published_date);
            tvBookTitle = itemView.findViewById(R.id.tv_book_name);
            tvMoreDetails = itemView.findViewById(R.id.tv_more_details);
            tvBookAbstract = itemView.findViewById(R.id.tv_abstract);


            tvMoreDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvBookTitle = itemView.findViewById(R.id.tv_book_name);
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(bookList.get(getAdapterPosition()).getUrl()));
                    context.startActivity(i);
                }
            });

        }
    }
}
