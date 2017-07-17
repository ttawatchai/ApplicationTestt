package Model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zipper.applicationtest.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by ZIPPER on 7/16/2017.
 */

public class ApiAdapter extends ArrayAdapter<DataApi> {
    ArrayList<DataApi> dataApis;
    Context context;
    int resource;

    public ApiAdapter(Context context, int resource, ArrayList<DataApi> dataApis) {
        super(context, resource, dataApis);
        this.dataApis = dataApis;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_api, null, true);

        }
        DataApi dataApi = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.pic);
        Picasso.with(context).load(dataApi.getImg()).into(imageView);

        TextView Title = (TextView) convertView.findViewById(R.id.title);
        Title.setText(dataApi.getTitle());

        TextView Des = (TextView) convertView.findViewById(R.id.Des);
        Des.setText(dataApi.getDes());

        return convertView;
    }
}
