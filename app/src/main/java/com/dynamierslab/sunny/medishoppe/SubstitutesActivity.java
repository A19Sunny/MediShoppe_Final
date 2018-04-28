package com.dynamierslab.sunny.medishoppe;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.Toast;

public class SubstitutesActivity extends AppCompatActivity {

    ListView listView;
    String[] items = {"Paracetamol","Disprine","Chrocine","Sinarest","Voverone","Nicardia Retard 10","Telma 40","Hajmola Emli"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substitutes);

        listView = (ListView) findViewById(R.id.medicineslistview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);

        ImageView img_back = (ImageView) findViewById(R.id.btn_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        Toast.makeText(getApplicationContext(),"Item:"+id,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
