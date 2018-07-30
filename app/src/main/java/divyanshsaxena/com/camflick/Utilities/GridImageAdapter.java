package divyanshsaxena.com.camflick.Utilities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.android.gms.dynamite.DynamiteModule;

import java.util.ArrayList;

import divyanshsaxena.com.camflick.R;

public class GridImageAdapter extends ArrayAdapter<String>{
private Context context;

private LayoutInflater mInflater;
private int layoutResource;
private String mAppend;
private ArrayList<String> imgURLs;

    public GridImageAdapter(Context context, LayoutInflater layoutInflater, int layoutResource, String mAppend, ArrayList<String> imgURLs) {
super(context,layoutResource,imgURLs);

        this.context = context;
        mInflater = layoutInflater;
        this.layoutResource = layoutResource;
        this.mAppend = mAppend;
        this.imgURLs = imgURLs;
    }

    private static class ViewHolder{
ImageView profileimage;
ProgressBar mProgressbar;
    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        final  ViewHolder viewHolder;
//
//        if(convertView == null){
//            convertView = mInflater.inflate(layoutResource,parent,false);
//            viewHolder = new ViewHolder();
////          viewHolder.mProgressbar = (ProgressBar) convertView.findViewById(R.id.profileProgressbar);
//
//            viewHolder.profileimage = (ImageView) convertView.findViewById(R.id.profileImage);
//        }
//
//
//
//    }
}
