package vn.khoapham.manager;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import static java.sql.Types.NULL;

public class NewPost extends AppCompatActivity {

    Context context;
    final int RESQUEST_TAKE_PHOTO = 123;
    final int REQUEST_CHOOSE_PHOTO = 321;

    ImageButton btnChupHinh;
    ImageView btnChonHinh;
    Button  btnThem, btnHuy;
    EditText edt_price, edt_area,edt_position,edt_comment,edt_type,edt_phone,edt_mail,edt_address;
    private Button btn_home;
    private Button btn_find;
    private Button btn_post;
    private Button btn_set;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        addControls();
        addEvents();

        btn_post = (Button)findViewById(R.id.post);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_post = new Intent(NewPost.this,ManagePost.class);
                startActivity(view_post);
            }
        });
        btn_home = (Button)findViewById(R.id.home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_home = new Intent(NewPost.this,MainActivity.class);
                startActivity(view_home);
            }
        });

        btn_find = (Button)findViewById(R.id.find);
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_find = new Intent(NewPost.this,FindPost.class);
                startActivity(view_find);
            }
        });

        btn_set = (Button)findViewById(R.id.setting);
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_set = new Intent(NewPost.this,SettingApp.class);
                startActivity(view_set);
            }
        });
    }
    private void addControls() {
        btnChonHinh = (ImageView) findViewById(R.id.imageView);
        btnChupHinh = (ImageButton) findViewById(R.id.image_button);
        btnThem = (Button) findViewById(R.id.posted);
        btnHuy = (Button) findViewById(R.id.delete);
        edt_address = (EditText) findViewById(R.id.txt_address);
        edt_area = (EditText) findViewById(R.id.txt_area);
        edt_comment = (EditText) findViewById(R.id.txt_comment);
        edt_mail = (EditText) findViewById(R.id.txt_email);
        edt_phone = (EditText) findViewById(R.id.txt_phone);
        edt_position = (EditText) findViewById(R.id.txt_position);
        edt_type = (EditText) findViewById(R.id.txt_type);
        edt_price = (EditText) findViewById(R.id.txt_price);
    }

    private void addEvents(){
        btnChonHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhoto();
            }
        });
        btnChupHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }

    private void takePicture(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, RESQUEST_TAKE_PHOTO);
    }

    private void choosePhoto(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_CHOOSE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CHOOSE_PHOTO){
                try {
                    Uri imageUri = data.getData();
                    InputStream is = getContentResolver().openInputStream(imageUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    btnChonHinh.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }else if(requestCode == RESQUEST_TAKE_PHOTO){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                btnChonHinh.setImageBitmap(bitmap);
            }
        }
    }

    private void insert(){
        final String price = edt_price.getText().toString();
        final String area = edt_area.getText().toString();
        final String comment = edt_comment.getText().toString();
        final String type = edt_type.getText().toString();
        final String position = edt_position.getText().toString();
        final String phone = edt_phone.getText().toString();
        final String email = edt_mail.getText().toString();
        final String address = edt_address.getText().toString();
        byte[] anh = getByteArrayFromImageView(btnChonHinh);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new goiserviceNew().execute("https://pteapp.000webhostapp.com/insert.php?compass="+area+"&price="+price+"&position="+position+"&contact="+"all"+"&phone="+phone+"&email="+email+"&address="+address+"&comment="+comment+"&type="+type+"&mota="+""+"&mem_post="+'1');

            }
        });
        Toast.makeText(getBaseContext(),"Da Them Vao Du Lieu",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ManagePost.class);
        startActivity(intent);

    }

    private static String docnoidung(String theurl)
    {
        StringBuilder content=new StringBuilder();


        try {

            URL url=new URL(theurl);
            URLConnection conn=url.openConnection();
            BufferedReader buffread=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line=buffread.readLine())!=null)
            {
                content.append(line+"\n");
            }
            buffread.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
    class goiserviceNew extends AsyncTask<String,Integer,String>
    {

        @Override
        protected String doInBackground(String... params) {
            return docnoidung(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONArray postphp=new JSONArray(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void cancel(){
        Intent intent = new Intent(this, ManagePost.class);
        startActivity(intent);
    }

    private byte[] getByteArrayFromImageView(ImageView imgv){

        BitmapDrawable drawable = (BitmapDrawable) imgv.getDrawable();
        Bitmap bmp = drawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
}
