package vn.khoapham.manager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivityViewPost extends AppCompatActivity  {
    Button btncontact;
    Button btn_SMS;
    String key1;
    TextView text_mota, text_gia,text_diachi, text_dientich, text_loainha,text_lienhe;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainviewpost);
        Bundle key = getIntent().getExtras();
        if (key != null){
            key1 = key.getString("khoa");
        }

        text_mota= (TextView) findViewById(R.id.textView3);
        text_gia=(TextView) findViewById(R.id.textView5);
        text_dientich=(TextView) findViewById(R.id.textView7);
        text_diachi=(TextView) findViewById(R.id.textView9);
        text_loainha=(TextView) findViewById(R.id.textView11);
        image=(ImageView) findViewById(R.id.imageView);
        text_lienhe=(TextView) findViewById(R.id.textView14);

        btncontact = (Button) findViewById(R.id.button2);

        btncontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(MainActivityViewPost.this,ContactInterface.class);
                startActivity(nextScreen);

            }
        });

        btn_SMS = (Button)findViewById(R.id.sendSMS);
        btn_SMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextScreen = new Intent(MainActivityViewPost.this,MySMSActivity.class);
                startActivity(nextScreen);
            }
        });
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new goiservice().execute("https://pteapp.000webhostapp.com/post.php?baidang="+key1);
            }
        });
        Picasso.with(this).load("https://pteapp.000webhostapp.com/getimage.php?key="+key1).into(image);

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
    class goiservice extends AsyncTask<String,Integer,String>
    {

        @Override
        protected String doInBackground(String... params) {
            return docnoidung(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {


            try {

                JSONArray postphp=new JSONArray(s);
                for(int i=0;i<postphp.length();i++)
                {
                    JSONObject jo=postphp.getJSONObject(i);
                    String mota=jo.getString("mota");
                    String gia=jo.getString("gia");
                    String loai=jo.getString("loai");
                    String dientich=jo.getString("dientich");
                    String diachi=jo.getString("diachi");
                    String lienhe=jo.getString("lienhe");
                    String khoa=jo.getString("khoa");

                    text_mota.setText(mota);
                    text_gia.setText(gia);
                    text_dientich.setText(dientich);
                    text_diachi.setText(diachi);
                    text_loainha.setText(loai);
                    text_lienhe.setText(lienhe);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
}





