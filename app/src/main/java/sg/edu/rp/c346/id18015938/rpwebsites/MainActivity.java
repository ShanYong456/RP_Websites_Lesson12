package sg.edu.rp.c346.id18015938.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnGo;
    ArrayList<String> alCategory;
    ArrayAdapter<String> aaCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.buttonGo);

        //Initialise the ArrayList
        alCategory = new ArrayList<>();

        //Create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaCategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alCategory);
        //Bind the ArrayAdapter to the Spinner
        spn2.setAdapter(aaCategory);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                alCategory.clear();
                switch (position) {
                    case 0:
                        //Your code for item 1 selected
                        //Get the string-array and store as an Array
                        String[] strSub = getResources().getStringArray(R.array.sub_category_rp);

                        //Convert Array to List and add to the ArrayList
                        alCategory.addAll(Arrays.asList(strSub));

                        break;
                    case 1:
                        //Your code for item 1 selected
                        //Get the string-array and store as an Array
                        strSub = getResources().getStringArray(R.array.sub_category_soi);

                        //Convert Array to List and add to the ArrayList
                        alCategory.addAll(Arrays.asList(strSub));

                        break;
                }
                aaCategory.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }

        });

        /*
        spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                aaCategory.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
*/

        btnGo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int category = spn1.getSelectedItemPosition();
                int item = spn2.getSelectedItemPosition();
                Intent intent = new Intent(MainActivity.this, URL.class);
                String url = "";
                if (category==0) {

                    if (item == 0) {

                        url = "https://www.rp.edu.sg/";

                    } else if (item == 1) {

                        url = "https://www.rp.edu.sg/student-life";

                    }

                }else if (category==1){

                    if (item==0){

                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";

                    }
                    else if (item==1){

                        url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";

                    }

                }

                intent.putExtra("URL", url);

                startActivity(intent);

            }
        });

    }
}
