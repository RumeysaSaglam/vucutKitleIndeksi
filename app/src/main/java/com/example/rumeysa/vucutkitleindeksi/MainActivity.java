package com.example.rumeysa.vucutkitleindeksi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView tvseekbar,tvidealkilo2,tvdurum2;
    EditText etboy;
    CheckBox cbkadin,cberkek;
    Button button;
    int boy,kilo,sonuc;
    double bki,boyu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar=findViewById(R.id.seekBar);
        tvseekbar=findViewById(R.id.tvseekbar);
        tvidealkilo2=findViewById(R.id.tvidealkilo2);
        tvdurum2=findViewById(R.id.tvdurum2);
        etboy=findViewById(R.id.etboy);
        cbkadin= findViewById(R.id.cbkadin);
        cberkek= findViewById(R.id.cberkek);
        button=findViewById(R.id.button);




        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setMax(200);
                 kilo=seekBar.getProgress();
                 tvseekbar.setText(" "+kilo);
                 boyu=Double.parseDouble(etboy.getText().toString());
                 boyu=boyu*0.01;
                 bki=kilo/(boyu*boyu);
                 if(bki<18.8){
                     tvdurum2.setText("Çok zayıf");
                 }
                 else if(bki>=18.5 && bki<24.5){
                     tvdurum2.setText("Normal kilolu");
                 }
                 else if(bki>=24.5 && bki<30){
                     tvdurum2.setText("Hafif şişman");

                 }
                 else if(bki>30){
                     tvdurum2.setText("Şişman(Obez)");

                 }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boy=(int)Math.ceil(Double.parseDouble(etboy.getText().toString()));



                if(cbkadin.isChecked()) {

                    sonuc = (int) Math.ceil((boy - 100) * (0.85));


                    tvidealkilo2.setText(""+sonuc);
                }

                if(cberkek.isChecked()) {

                    sonuc = (int) Math.ceil((boy - 100) * (0.9));

                    tvidealkilo2.setText(""+sonuc);
                }

            }
        });






    }
}

