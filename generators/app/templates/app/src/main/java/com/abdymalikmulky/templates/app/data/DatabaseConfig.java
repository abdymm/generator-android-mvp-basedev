package <%= appPackage %>.app.data;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Bismillahirrahmanirrahim
 * Created by abdymalikmulky on 5/2/17.
 */
@Database(name = DatabaseConfig.NAME, version = DatabaseConfig.VERSION)
public class DatabaseConfig {

    public static final String NAME = "<%= appSimpleName %>";

    public static final int VERSION = 1;
}
