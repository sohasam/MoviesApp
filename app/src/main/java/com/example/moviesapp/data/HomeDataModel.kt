package com.example.moviesapp.data

import android.util.Log
import com.example.moviesapp.contracts.IHomeContract
import com.example.moviesapp.data.pojos.MoviesModel
import com.example.moviesapp.data.retrofit.ApiClient
import retrofit2.Callback
import retrofit2.Response

class HomeDataModel(var presenter :IHomeContract.IHomePresenter) :IHomeContract.IHomeModel{
    override fun getMoviesWithTitleFromApi(title: String) {
        ApiClient.client?.search("cf52c65b5b064bd7282d2382cfe9768d",title)?.enqueue(object :
            Callback<MoviesModel> {
            override fun onFailure(call: retrofit2.Call<MoviesModel>, t: Throwable) {
                presenter.onFailedToRetrieveMovies()


            }

            override fun onResponse(call: retrofit2.Call<MoviesModel>, response: Response<MoviesModel>) {
//                Log.i("soha","onResponse");
//                Log.i("soha", "onResponse${response.body()?.results}");
                if(response.body() !=null) {
                    presenter.onSuccessRetrieveMovies(response.body()!!)
                }
                else
                {
                    presenter.onFailedToRetrieveMovies()
                }

            }

        }

        )
    }
}