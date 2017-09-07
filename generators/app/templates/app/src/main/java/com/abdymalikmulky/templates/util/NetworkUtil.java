package <%= appPackage %>.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by abdymalikmulky on 1/28/17.
 */

public final class NetworkUtil {


    public static final boolean isNetworkAvailable(Context context){
        boolean isAvailable = false;

        ConnectivityManager ConnectionManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()==true )
        {
            isAvailable = true;
        }
        return isAvailable;
    }
}
