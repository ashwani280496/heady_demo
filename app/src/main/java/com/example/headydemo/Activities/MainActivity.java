package com.example.headydemo.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.headydemo.Models.BookModel;
import com.example.headydemo.Adapters.BooksAdapter;
import com.example.headydemo.ViewModels.BookViewModel;
import com.example.headydemo.R;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BooksAdapter adapter;

    List<BookModel> booksList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BookViewModel model = ViewModelProviders.of(this).get(BookViewModel.class);

        model.getHeroes().observe(this, new Observer<List<BookModel>>() {
            @Override
            public void onChanged(@Nullable List<BookModel> booksList) {
                adapter = new BooksAdapter(MainActivity.this, booksList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
