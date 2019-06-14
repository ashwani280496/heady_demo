package com.example.headydemo.ViewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import java.util.List;
import com.example.headydemo.APIRequestHandler.GETBookDataApi;
import com.example.headydemo.Models.BookModel;
import com.example.headydemo.Models.ResponseModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<BookModel>> bookList;

    private ResponseModel mainResponse;

    //we will call this method to get the data
    public LiveData<List<BookModel>> getHeroes() {
        //if the list is null
        if (bookList == null) {
            bookList = new MutableLiveData<>();
            //we will load it asynchronously from server in this method
            loadBooks();
        }

        //finally we will return the list
        return bookList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadBooks() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GETBookDataApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GETBookDataApi api = retrofit.create(GETBookDataApi.class);
        Call<ResponseModel> call = api.getAllResults();

        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                mainResponse = response.body();
                bookList.setValue(mainResponse.getResults());
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
            }
        });
    }
}
