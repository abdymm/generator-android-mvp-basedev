package com.abdymalikmulky.templates.app.ui.people.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abdymalikmulky.templates.R;
import com.abdymalikmulky.templates.app.data.people.People;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Bismillahirrahmanirrahim
 * Created by abdymalikmulky on 7/7/17.
 */

class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    private List<People> peoples;
    private Context context;
    private PeopleContract.View peopleView;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.list_people_id)
        TextView listPeopleId;
        @BindView(R.id.list_people_name)
        TextView listPeopleName;

        public People people;

        public ViewHolder(View root) {
            super(root);
            ButterKnife.bind(this, root);
        }

        @Override
        public void onClick(View view) {
            peopleView.onListClicked(people);
        }
    }

    public PeopleAdapter(List<People> peoples, PeopleContract.View peopleView) {
        this.peoples = peoples;
        peopleView = peopleView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View rootView = LayoutInflater.from(context).inflate(R.layout.list_people, parent, false);

        return new ViewHolder(rootView);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(holder);

        holder.people = peoples.get(position);

        holder.listPeopleId.setText(holder.people.getId());
        holder.listPeopleName.setText(holder.people.getName());
    }

    @Override
    public int getItemCount() {
        return peoples.size();
    }

    public void refresh(List<People> peoples) {
        this.peoples.clear();
        this.peoples = peoples;
        notifyDataSetChanged();
    }
}
