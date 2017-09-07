package <%= appPackage %>.app.data.people;

import <%= appPackage %>.app.data.DatabaseConfig;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.parceler.Parcel;

/**
 * Created by abdymalikmulky on 9/5/17.
 */
@Table(database = DatabaseConfig.class)
@Parcel
public class People extends BaseModel {
    @Column
    @PrimaryKey(autoincrement = false)
    String id;

    @Column
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
