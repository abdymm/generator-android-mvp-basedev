package com.abdymalikmulky.templates.app.data.people;

import java.util.List;

/**
 * Created by abdymalikmulky on 9/5/17.
 */

public interface PeopleDataSource {

    interface LoadCallback {
        void onLoaded(List<People> peoples);
        void onFailed(String msg);
    }

    void load(LoadCallback callback);
}
