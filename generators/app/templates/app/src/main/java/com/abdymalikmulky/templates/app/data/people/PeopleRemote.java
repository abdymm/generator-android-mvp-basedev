package com.abdymalikmulky.templates.app.data.people;

import com.abdymalikmulky.templates.helper.ApiHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by abdymalikmulky on 9/5/17.
 */

public class PeopleRemote implements PeopleDataSource {

    PeopleApi peopleApi;

    public PeopleRemote() {
        peopleApi = ApiHelper.client().create(PeopleApi.class);
    }


    @Override
    public void load(final LoadCallback callback) {
        Call<List<People>> call = peopleApi.getAll();
        call.enqueue(new Callback<List<People>>() {
            @Override
            public void onResponse(Call<List<People>> call, Response<List<People>> response) {
                if(response.isSuccessful()) {
                    List<People> peoples = response.body();
                    callback.onLoaded(peoples);
                } else {
                    callback.onFailed(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<People>> call, Throwable t) {
                callback.onFailed(t.getLocalizedMessage());
            }
        });
    }
}
