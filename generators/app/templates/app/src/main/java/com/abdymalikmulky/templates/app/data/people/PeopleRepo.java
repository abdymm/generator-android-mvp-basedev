package <%= appPackage %>.app.data.people;

import android.content.Context;

import <%= appPackage %>.MyApplication;
import <%= appPackage %>.util.NetworkUtil;

import java.util.List;

/**
 * Created by abdymalikmulky on 9/5/17.
 */

public class PeopleRepo implements PeopleDataSource {

    private PeopleLocal peopleLocal;
    private PeopleRemote peopleRemote;

    private Context context;

    public PeopleRepo(Context context, PeopleLocal peopleLocal, PeopleRemote peopleRemote) {
        this.context = context;

        this.peopleLocal = peopleLocal;
        this.peopleRemote = peopleRemote;
    }

    @Override
    public void load(final LoadCallback callback) {
        //Check if network is available
        if(NetworkUtil.isNetworkAvailable(context)) {
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
