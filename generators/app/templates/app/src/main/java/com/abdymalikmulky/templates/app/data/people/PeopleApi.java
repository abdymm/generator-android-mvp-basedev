package <%= appPackage %>.app.data.people;

import <%= appPackage %>.util.EndpointUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Bismillahirrahmanirrahim
 * Created by abdymalikmulky on 5/2/17.
 */

public interface PeopleApi {

    @GET(EndpointUtil.GET_PEOPLES)
    public Call<List<People>> getAll();


}
