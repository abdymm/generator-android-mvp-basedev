package com.abdymalikmulky.templates.app.ui.people.main;

import com.abdymalikmulky.templates.app.data.people.People;
import com.abdymalikmulky.templates.app.data.people.PeopleDataSource;
import com.abdymalikmulky.templates.app.data.people.PeopleRepo;

import java.util.List;

/**
 * Created by abdymalikmulky on 9/5/17.
 */

public class PeoplePresenter implements PeopleContract.Presenter {

    private PeopleContract.View peopleView;
    private PeopleRepo peopleRepo;

    public PeoplePresenter(PeopleContract.View peopleView, PeopleRepo peopleRepo) {
        this.peopleView = peopleView;
        this.peopleView.setPresenter(this);

        this.peopleRepo = peopleRepo;
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void load() {
        peopleRepo.load(new PeopleDataSource.LoadCallback() {
            @Override
            public void onLoaded(List<People> peoples) {
                peopleView.shows(peoples);
            }

            @Override
            public void onFailed(String msg) {
                peopleView.showError(msg);
            }
        });
    }
}
