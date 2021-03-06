package com.example.christoap.shipinspectorc;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HullProperty extends AppCompatActivity {

    private Spinner spinner,spinner_jenis;
    private String[] jenis = new String[]{"Pelat Alas","Profil Alas","Center Girder","Side Girder","Strut","Pelat Wrang","Pelat Alas Dalam","Profil Alas Dalam"};
    private String[] jenis_sekat = new String[]{"Pelat Sekat","Profil Penegar"};
    private String[] main_deck =new String[]{"Pelat Geladak","Profil Deck Beam","Profil Strong Beam","Profil Deck Girder","Profil Deck Side Girder","Bracket"};
    private String[] side_shell =new String[]{"Pelat Sisi Atas","Profil Gading Besar","Profil Gading Biasa","Bracket"};
    private String[] tween_deck =new String[]{"Pelat Geladak","Profil Deck Beam","Profil Strong Beam","Profil Deck Girder","Profil Deck Side Girder","Bracket"};
    private String[] jenis_inspek = new String[]{"Material Identification","Preparation","Fabrication"};
    private String[] superstructure =new String[]{"Pelat Geladak","Profil Deck Beam","Profil Strong Beam","Profil Deck Girder","Profil Deck Side Girder","Bracket"};

    private Button next,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hull_property);
        spinner = (Spinner) findViewById(R.id.sp_hull_prop);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,jenis);

       /* spinner.setAdapter(arrayAdapter);*/
       /* ArrayList<String> lst = new ArrayList<String>(Arrays.asList(array));
        List<String> values = new ArrayList<String>(Arrays.asList());*/

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        spinner_jenis = (Spinner) findViewById(R.id.sp_jenis_inspek);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,jenis_inspek);
        spinner_jenis.setAdapter(arrayAdapter1);
        back = (Button) findViewById(R.id.hull_prop_back);
        back.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HullProperty.this,MainActivity.class);
                intent.putExtra("state","hull");
                startActivity(intent);
            }
        });
        next = (Button) findViewById(R.id.hull_prop_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HullProperty.this, Hull_Prop_Form.class);
                intent.putExtra("jenis",spinner_jenis.getSelectedItem().toString());
                startActivity(intent);
            }
        });
    }
}
