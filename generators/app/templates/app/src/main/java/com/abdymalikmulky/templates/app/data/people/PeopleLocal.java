package com.abdymalikmulky.templates.app.data.people;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

/**
 * Created by abdymalikmulky on 9/5/17.
 */

public class PeopleLocal implements PeopleDataSource {

    @Override
    public void load(LoadCallback callback) {
        List<People> peoples = SQLite.select()
                .from(People.class).queryList();

        callback.onLoaded(peoples);
    }

    public boolean save(People people){
        return (people.insert() > 0) ? true : false;
    }

    public boolean isExist(String id){
        long rowCount = SQLite.select()
                .from(People.class)
                .where(People_Table.id.eq(id))
                .count();
        return (rowCount > 0) ? true : false;
    }

    public void delete(){
        SQLite.delete(People.class)
                .execute();
    }
}
