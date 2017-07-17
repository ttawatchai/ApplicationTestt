package Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.zipper.applicationtest.R;

import java.util.ArrayList;

/**
 * Created by ZIPPER on 7/15/2017.
 */

public class ListViewAdapter extends ArrayAdapter<DataBase> {
    private LayoutInflater mInflater;
    private ArrayList<DataBase> databases;
    private int mViewResourceId;

    public ListViewAdapter(Context context, int textViewResourceId, ArrayList<DataBase> databases) {
        super(context, textViewResourceId, databases);
        this.databases = databases;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);
       DataBase database = databases.get(position);

        if (database != null) {
            TextView Tname = (TextView) convertView.findViewById(R.id.nameList);
            TextView Tage = (TextView) convertView.findViewById(R.id.ageList);

            if (Tname != null) {
                Tname.setText(database.getName());
            }
            if (Tage != null) {
                Tage.setText((database.getAge()));
            }
        }

        return convertView;
    }
}