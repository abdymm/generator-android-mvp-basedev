package com.abdymalikmulky.templates.app.data.people;

import com.abdymalikmulky.templates.MyApplication;
import com.abdymalikmulky.templates.util.NetworkUtil;

import java.util.List;

/**
 * Created by abdymalikmulky on 9/5/17.
 */

public class PeopleRepo implements PeopleDataSource {

    private PeopleLocal peopleLocal;
    private PeopleRemote peopleRemote;

    public PeopleRepo(PeopleLocal peopleLocal, PeopleRemote peopleRemote) {
        this.peopleLocal = peopleLocal;
        this.peopleRemote = peopleRemote;
    }

    @Override
    public void load(final LoadCallback callback) {
        //Check if network is available
        if(NetworkUtil.isNetworkAvailable(MyApplication.getInstance())) {
            peopleRemote.load(new LoadCallback() {
                @Override
                public void onLoaded(List<People> peoples) {
                    saveOnLocal(peoples);
                    callback.onLoaded(peoples);
                }

                @Override
                public void onFailed(String errorMessage) {
                    callback.onFailed(errorMessage);
                }
            });
        } else {
            peopleLocal.load(new LoadCallback() {
                @Override
                public void onLoaded(List<People> movies) {
                    callback.onLoaded(movies);
                }

                @Override
                public void onFailed(String errorMessage) {
                    callback.onFailed(errorMessage);
                }
            });
        }
    }
    private void saveOnLocal(List<People> peoples) {
        for (People people : peoples) {
            //if exist on db local, dont save
            if(!peopleLocal.isExist(people.getId())) {
                peopleLocal.save(people);
            }
        }
    }
}
