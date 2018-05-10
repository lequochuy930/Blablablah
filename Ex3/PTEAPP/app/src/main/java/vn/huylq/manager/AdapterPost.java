package vn.khoapham.manager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by QUOC HUY on 08-May-17.
 */

public class AdapterPost extends BaseAdapter {
    Activity context;
    ArrayList<td> list;

    public AdapterPost(Activity context, ArrayList<td> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listview_post, null);
        ImageView imgHinhDaiDien = (ImageView) row.findViewById(R.id.imgHinhDaiDien);
        TextView txtAddress = (TextView) row.findViewById(R.id.show_address);
        TextView txtPrice = (TextView) row.findViewById(R.id.show_price);
        TextView txtType = (TextView) row.findViewById(R.id.show_type);
        TextView txtArea = (TextView) row.findViewById(R.id.show_area);

        final td post = list.get(position);
        txtAddress.setText(post.getDiachi());
        txtArea.setText(post.getDientich() + " m2");
        txtPrice.setText(post.getGia() + " tỉ đồng");
        txtType.setText(post.getLoai());
        Picasso.with(context).load(post.getImage()).into(imgHinhDaiDien);
        return row;
    }


}
