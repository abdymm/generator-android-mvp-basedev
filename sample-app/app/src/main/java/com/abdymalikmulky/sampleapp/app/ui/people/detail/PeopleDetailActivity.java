package com.abdymalikmulky.sampleapp.app.ui.people.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.abdymalikmulky.sampleapp.R;
import com.abdymalikmulky.sampleapp.app.data.people.People;
import com.abdymalikmulky.sampleapp.util.ConstantsUtil;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

//TODO: You can make this to mvp
public class PeopleDetailActivity extends AppCompatActivity {

    //Layout
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.detail_people_id)
    TextView detailPeopleId;
    @BindView(R.id.detail_people_name)
    TextView detailPeopleName;

    //Data
    private People people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try {
            people = (People) Parcels.unwrap(getIntent().getParcelableExtra(ConstantsUtil.INTENT_PEOPLE));
            showData(people);
        } catch (NullPointerException e) {
            Timber.e(e.toString());
        }

    }

    private void showData(People people) {
        detailPeopleId.setText(people.getId());
        detailPeopleName.setText(people.getName());
    }
}
