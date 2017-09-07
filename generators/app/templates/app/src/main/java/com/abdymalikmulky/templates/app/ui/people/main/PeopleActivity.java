package <%= appPackage %>.app.ui.people.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import <%= appPackage %>.R;
import <%= appPackage %>.app.data.people.People;
import <%= appPackage %>.app.data.people.PeopleLocal;
import <%= appPackage %>.app.data.people.PeopleRemote;
import <%= appPackage %>.app.data.people.PeopleRepo;
import <%= appPackage %>.app.ui.people.detail.PeopleDetailActivity;
import <%= appPackage %>.util.ConstantsUtil;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class PeopleActivity extends AppCompatActivity implements PeopleContract.View {
    //Repo
    private PeopleLocal peopleLocal;
    private PeopleRemote peopleRemote;
    private PeopleRepo peopleRepo;

    //Presenter
    private PeopleContract.Presenter peoplePresenter;

    //Layout
    @BindView(R.id.content_people)
    ConstraintLayout contentPeople;
    @BindView(R.id.list_people)
    RecyclerView listPeople;

    //Data
    private List<People> peoples;
    private PeopleAdapter peopleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        ButterKnife.bind(this);

        initList();
        initPresenterAndRepo();
    }

    private void initPresenterAndRepo() {
        //Init Repo
        peopleLocal = new PeopleLocal();
        peopleRemote = new PeopleRemote();
        peopleRepo = new PeopleRepo(getApplicationContext(), peopleLocal, peopleRemote);

        //Init Presenter
        peoplePresenter = new PeoplePresenter(this, peopleRepo);

    }

    private void initList() {
        peoples = new ArrayList<>();
        listPeople.setHasFixedSize(true);

        listPeople.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManagerIngredient = new LinearLayoutManager(this);
        listPeople.setLayoutManager(mLayoutManagerIngredient);

        peoples = new ArrayList<>();
        peopleAdapter = new PeopleAdapter(peoples, this);
        listPeople.setAdapter(peopleAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        peoplePresenter.load();
    }



    @Override
    public void setPresenter(PeopleContract.Presenter presenter) {
        this.peoplePresenter = presenter;
    }

    @Override
    public void shows(List<People> peoples) {
        this.peoples = peoples;
        Timber.d("PeoplesData %s", peoples.toString());
        peopleAdapter.refresh(this.peoples);
    }

    @Override
    public void showError(String msg) {
        Snackbar.make(contentPeople, msg, Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void onListClicked(People people) {
        Intent detailIntent = new Intent(this, PeopleDetailActivity.class);
        detailIntent.putExtra(ConstantsUtil.INTENT_PEOPLE, Parcels.wrap(people));
        startActivity(detailIntent);
    }


}
