package com.abdymalikmulky.templates.app.ui.people.main;

import com.abdymalikmulky.templates.app.BasePresenter;
import com.abdymalikmulky.templates.app.BaseView;
import com.abdymalikmulky.templates.app.data.people.People;

import java.util.List;

/**
 * Created by abdymalikmulky on 9/5/17.
 */

public class PeopleContract {

    interface View extends BaseView<Presenter> {
        void shows(List<People> peoples);
        void showError(String msg);

        void onListClicked(People people);
    }

    interface Presenter extends BasePresenter {
        void load();
    }

}
