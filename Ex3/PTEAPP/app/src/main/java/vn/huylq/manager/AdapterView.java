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

public class AdapterView extends BaseAdapter {
    Activity context;
    ArrayList<td> list;
    private Button btn_edit;
    private Button btn_view;

    public AdapterView(Activity context, ArrayList<td> list) {
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
        View row = inflater.inflate(R.layout.listview_view, null);
        ImageView imgHinhDaiDien = (ImageView) row.findViewById(R.id.image);
        TextView txtAddress = (TextView) row.findViewById(R.id.address);
        TextView txtPrice = (TextView) row.findViewById(R.id.price);
        TextView txtType = (TextView) row.findViewById(R.id.type);
        TextView txtArea = (TextView) row.findViewById(R.id.area);
        TextView txtPosition = (TextView) row.findViewById(R.id.position);
        TextView txtPhone = (TextView) row.findViewById(R.id.phone);
        TextView txtEmail = (TextView) row.findViewById(R.id.mail);
        TextView txtComment = (TextView) row.findViewById(R.id.comment);

        final td post = list.get(position);
        txtAddress.setText("Địa chỉ: "+post.getDiachi());
        txtArea.setText("Diện tích: "+post.getDientich() + " m2");
        txtPrice.setText("Giá: "+post.getGia() + " tỉ đồng");
        txtType.setText("Loại: "+post.getLoai());
//        txtComment.setText(post.getCmt());
        txtPosition.setText("Vị trí: "+post.getVitri());
        txtEmail.setText("Mail: "+post.getEmail());
        txtPhone.setText("Phone: "+post.getDt());

        btn_edit = (Button) row.findViewById(R.id.edit);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_edit = new Intent(context,EditPost.class);
                view_edit.putExtra("khoa", post.getKhoa());
                context.startActivity(view_edit);
            }
        });

        btn_view = (Button)row.findViewById(R.id.viewfull);
        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewf = new Intent(context,MainActivityViewPost.class);
                viewf.putExtra("khoa", post.getKhoa());
                context.startActivity(viewf);
            }
        });
        Picasso.with(context).load(post.getImage()).into(imgHinhDaiDien);
        return row;
    }
}
