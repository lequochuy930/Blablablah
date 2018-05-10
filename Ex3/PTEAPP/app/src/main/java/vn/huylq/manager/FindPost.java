package vn.khoapham.manager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView;

import java.util.ArrayList;

public class FindPost extends AppCompatActivity {
    private Button btn_home;
    private Button btn_find;
    private Button btn_post;
    private Button btn_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_post);

        btn_post = (Button)findViewById(R.id.post);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_post = new Intent(FindPost.this,ManagePost.class);
                startActivity(view_post);
            }
        });
        btn_home = (Button)findViewById(R.id.home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_home = new Intent(FindPost.this,HomeScreen.class);
                startActivity(view_home);
            }
        });

        btn_find = (Button)findViewById(R.id.find);
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_find = new Intent(FindPost.this,FindPost.class);
                startActivity(view_find);
            }
        });

        btn_set = (Button)findViewById(R.id.setting);
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent view_set = new Intent(FindPost.this,SettingApp.class);
                startActivity(view_set);
            }
        });
        findPost();
    }

    TextView textview1;
    TextView textview2;

    //EditText edittext;
    Spinner spin1;
    Spinner spin2;
    ListView listview;

    Button button1;

    ArrayAdapter addientich;
    ArrayAdapter advitri;
    ArrayAdapter adgiaca;
    ArrayAdapter adloai;
    AdapterPost adtd;

    ArrayList<String> ldientich;
    ArrayList<String> lvitri;
    ArrayList<String> lgiaca;
    ArrayList<String> lloai;

    ArrayList<td> listtd;


    Model m;

    private void findPost() {



        m=new Model();
        textview1=(TextView)findViewById(R.id.textView1);
        textview2=(TextView)findViewById(R.id.textView2);
        //edittext=(EditText)findViewById(R.id.editText);
        spin1=(Spinner)findViewById(R.id.spinner1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                textview2.setVisibility(View.VISIBLE);
                spin2.setVisibility(View.VISIBLE);

                switch (position){
                    case 0:
                        textview2.setText("Chọn diện tích");
                        spin2.setAdapter(addientich);
                        break;
                    case 1:
                        textview2.setText("Chọn loại nhà");
                        spin2.setAdapter(adloai);
                        break;
                    case 2:
                        textview2.setText("Chọn vị trí");
                        spin2.setAdapter(advitri);
                        break;
                    case 3:
                        textview2.setText("Chọn giá");
                        spin2.setAdapter(adgiaca);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin2=(Spinner)findViewById(R.id.spinner2);
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                button1.setVisibility(View.VISIBLE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        listview=(ListView)findViewById(R.id.l1);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent view_post = new Intent(FindPost.this,MainActivityViewPost.class);
                view_post.putExtra("khoa",listtd.get(i).getKhoa());
                startActivity(view_post);
            }
        });

        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<td> rt;
                String ls=spin2.getSelectedItem().toString();
                switch (spin1.getSelectedItem().toString()) {
                    case "Tìm kiếm theo diện tích":
                        m.mTypeArea(ls,FindPost.this);
                        break;
                    case "Tìm kiếm theo loại nhà":
                        m.mTypeHouse(ls,FindPost.this);
                        break;
                    case "Tìm kiếm theo vị trí":
                        m.mTypeLocation(ls,FindPost.this);
                        break;
                    case "Tìm kiếm theo giá cả":
                        m.mTypePrice(ls,FindPost.this);
                        break;

                }

            }
        });

        ArrayList<String> loaitk=new ArrayList<String>();

        loaitk.add("Tìm kiếm theo diện tích");
        loaitk.add("Tìm kiếm theo loại nhà");
        loaitk.add("Tìm kiếm theo vị trí");
        loaitk.add("Tìm kiếm theo giá cả");

        ldientich=new ArrayList<String>();
        ldientich.add("0m2 - 30m2");
        ldientich.add("30m2 - 60m2");
        ldientich.add("60m2 - 90m2");
        ldientich.add("90m2 - 120m2");
        ldientich.add("120m2 - 150m2");
        ldientich.add("150m2 - 180m2");
        ldientich.add("180m2 - 210m2");

        lvitri=new ArrayList<String>();
        lvitri.add("Quận 1");
        lvitri.add("Quận 2");
        lvitri.add("Quận 3");
        lvitri.add("Quận 4");
        lvitri.add("Quận 5");
        lvitri.add("Quận 6");
        lvitri.add("Quận 7");
        lvitri.add("Quận 8");
        lvitri.add("Quận 9");
        lvitri.add("Quận 10");
        lvitri.add("Quận 11");
        lvitri.add("Quận 12");
        lvitri.add("Quận Thủ Đức");
        lvitri.add("Quận Gò Vấp");
        lvitri.add("Quận Bình Thạnh");
        lvitri.add("Quận Tân Bình");
        lvitri.add("Quận Tân Phú");
        lvitri.add("Quận Phú Nhuận");
        lvitri.add("Quận Bình Tân");


        lgiaca=new ArrayList<String>();

        lgiaca.add("0 - 2 tỉ");
        lgiaca.add("2 - 4 tỉ");
        lgiaca.add("4 - 6 tỉ");
        lgiaca.add("6 - 8 tỉ");
        lgiaca.add("8 - 10 tỉ");
        lgiaca.add("10 - 12 tỉ");


        lloai=new ArrayList<String>();
        lloai.add("Nhà cấp 4");
        lloai.add("Nhà cấp 3");
        lloai.add("Nhà cấp 2");
        lloai.add("Nhà cấp 1");



        ArrayAdapter arrayadapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,loaitk);
        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        addientich=new ArrayAdapter(this,android.R.layout.simple_spinner_item,ldientich);
        addientich.setDropDownViewResource(android.R.layout.simple_spinner_item);
        advitri=new ArrayAdapter(this,android.R.layout.simple_spinner_item,lvitri);
        advitri.setDropDownViewResource(android.R.layout.simple_spinner_item);
        adgiaca=new ArrayAdapter(this,android.R.layout.simple_spinner_item,lgiaca);
        adgiaca.setDropDownViewResource(android.R.layout.simple_spinner_item);
        adloai=new ArrayAdapter(this,android.R.layout.simple_spinner_item,lloai);
        adloai.setDropDownViewResource(android.R.layout.simple_spinner_item);

        listtd=new ArrayList<td>();
        listview = (ListView)findViewById(R.id.l1);
        adtd=new AdapterPost(this,listtd);
        spin1.setAdapter(arrayadapter);
        listview.setAdapter(adtd);
    }
    public  void vShowData(ArrayList<td> d) {
        listtd.clear();
        for (int i=0;i<d.size();i++)
        {
            listtd.add(d.get(i));
        }
        adtd.notifyDataSetChanged();

    }
}
