package com.example.customspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    String[] countryList, capitalList, anthemList, popuList, languageList;
    int[] flags1;
    Spinner stateSelect;
    TextView country, capital, anthem, popu, lang;
    boolean easter_egg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stateSelect = (Spinner) findViewById(R.id.spinner2);
        country = (TextView) findViewById(R.id.country);
        capital = (TextView) findViewById(R.id.capital1);
        anthem = (TextView) findViewById(R.id.anthem);
        popu = (TextView) findViewById(R.id.population);
        lang = (TextView) findViewById(R.id.language);





        countryList = new String[]{"Select\nCountry", "Israel", "USA", "UK", "Russia", "Morocco", "Japan", "Canada"};
        capitalList = new String[]{"","Jerusalem", "Washington DC", "London", "Moscow", "Rabat", "Tokyo", "Ottawa"};
        flags1 = new int[]{R.drawable.choose, R.drawable.is, R.drawable.us, R.drawable.uk, R.drawable.ru, R.drawable.mo, R.drawable.ja, R.drawable.ca};

        anthemList = new String[]{"Hatikva", "The Star-Spangled Banner", "God Save the Queen", "State Anthem of the Russian Federation", "Cherifian Anthem", "Kimigayo", "O Canada"};
        popuList = new String[]{"9.217M", "329.5M", "67.22M", "144.1M", "36.91M", "125.8M", "38.01M"};
        languageList = new String[]{"Hebrew, Arabic, English", "English", "English", "Russian", "Arabic, Tamazight", "Japanese", "English, French"};



        stateSelect.setOnItemSelectedListener(this);

        CustomAdapter customadp1 = new CustomAdapter(getApplicationContext(), countryList, capitalList, flags1);
        stateSelect.setAdapter(customadp1);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       if (position!=0)
       {
           country.setText("Country Name: " + countryList[position]);
           capital.setText("Capital Name: " + capitalList[position]);
           anthem.setText("Offical Anthem Name: "+ anthemList[position-1]);
           popu.setText("Population: " + popuList[position-1]);
           lang.setText("Official Language/s: " + languageList[position-1]);
           easter_egg = true;

       }
       else if (easter_egg)
           {
               country.setText("Albert");
               capital.setText("Can");
               anthem.setText("I");
               popu.setText("Get");
               lang.setText("100");
           }




    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}