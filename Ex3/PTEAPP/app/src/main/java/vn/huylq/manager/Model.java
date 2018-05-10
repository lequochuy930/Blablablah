package vn.khoapham.manager;

import android.app.Activity;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

import static android.util.Base64.URL_SAFE;


public class Model extends Activity {
    FindPost v;
    public void mTypeArea(String s,FindPost fp) {
        this.v=fp;
        final String low=(((s.split(" "))[0]).split("m2"))[0];
        final String up=(((s.split(" "))[2]).split("m2"))[0];
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new goiservice().execute("https://pteapp.000webhostapp.com/dientich.php?thap="+low+"&cao="+up);
            }
        });
    }
    public void mTypeLocation(String s,FindPost fp) {
        this.v=fp;
        final String dc=s;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    new goiservice().execute("https://pteapp.000webhostapp.com/diachi.php?diachi="+URLEncoder.encode(dc, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public void mTypeHouse(String s,FindPost fp) {

        this.v=fp;
        final String ln=s;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    new goiservice().execute("https://pteapp.000webhostapp.com/loainha.php?loainha="+URLEncoder.encode(ln, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        });


    }
    public void mTypePrice(String s,FindPost fp){

        this.v=fp;
        final String low=(s.split(" "))[0];
        final String up=(s.split(" "))[2];

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new goiservice().execute("https://pteapp.000webhostapp.com/giaca.php?thap="+low+"&cao="+up);
            }
        });
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

            ArrayList<td> trave=new ArrayList<>();
            try {

                JSONArray layphp=new JSONArray(s);
                for(int i=0;i<layphp.length();i++)
                {
                    JSONObject jo=layphp.getJSONObject(i);
                    String gia=jo.getString("gia");
                    String loai=jo.getString("loai");
                    String dientich=jo.getString("dientich");
                    String diachi=jo.getString("diachi");
                    String khoa=jo.getString("khoa");
                    String hinhanh= "https://pteapp.000webhostapp.com/getimage.php?key="+khoa;
                    td them=new td(gia,loai,dientich,diachi,khoa,hinhanh);
                    trave.add(them);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            v.vShowData(trave);

        }
    }

}
