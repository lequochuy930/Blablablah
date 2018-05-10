package vn.khoapham.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen Huu Kim on 5/4/2017.
 */

public class custom_td extends ArrayAdapter<td> {

    private Activity context;
    private int resource;
    private ArrayList<td> arrtd;

    public custom_td(@NonNull Activity context, @LayoutRes int resource, @NonNull ArrayList<td> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrtd=objects;
    }

    //@NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        convertView= context.getLayoutInflater().inflate(resource,null);
            if(arrtd.size()>0 && position>=0) {
                TextView tv_gia = (TextView) convertView.findViewById(R.id.tv1);
                TextView tv_loai = (TextView) convertView.findViewById(R.id.tv2);
                TextView tv_dientich = (TextView) convertView.findViewById(R.id.tv3);
                TextView tv_diachi = (TextView) convertView.findViewById(R.id.tv4);
                ImageView tv_im=(ImageView)  convertView.findViewById(R.id.imageView);
                td p = arrtd.get(position);
                tv_gia.setText(p.getGia());
                tv_loai.setText(p.getLoai());
                tv_dientich.setText(p.getDientich());
                tv_diachi.setText(p.getDiachi());
                Picasso.with(getContext()).load(p.getImage()).into(tv_im);
            }
        return convertView;
    }
}
