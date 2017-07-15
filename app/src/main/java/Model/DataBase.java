package Model;

import android.provider.BaseColumns;
import android.text.Editable;

/**
 * Created by ZIPPER on 7/14/2017.
 */
public class DataBase {

    private String Name;
    private String Age;

    public DataBase(String Dname, String Dage){
        Name = Dname;
        Age = Dage;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }


}
