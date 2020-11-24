package com.fpepe.curo3semana2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView siguiente;
    TextInputEditText tietNombre1;
    TextInputEditText tietFecha1;
    TextInputEditText tietTelefono1;
    TextInputEditText tietEmail1;
    TextInputEditText tietDescripcion1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tietNombre1 = (TextInputEditText) findViewById(R.id.tietNombre_completo);
        tietFecha1 = (TextInputEditText) findViewById(R.id.tietFecha_nacimiento);
        tietTelefono1 = (TextInputEditText) findViewById(R.id.tietTelefono);
        tietEmail1 = (TextInputEditText) findViewById(R.id.tietEmail);
        tietDescripcion1 = (TextInputEditText) findViewById(R.id.tietDescripcion_contacto);

        tietFecha1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.tietFecha_nacimiento:
                        showDatePickerDialog();
                        break;
                        }
            }}
        );

        siguiente =(TextView) findViewById(R.id.tvSiguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = tietNombre1.getText().toString();
                String date = tietFecha1.getText().toString();
                String phone = tietTelefono1.getText().toString();
                String e_mail = tietEmail1.getText().toString();
                String description = tietDescripcion1.getText().toString();
                if(!name.equals("")){
                    Intent screen1 = new Intent(MainActivity.this, ConfirmacionDatos.class);
                    screen1.putExtra(getResources().getString(R.string.pnombre),name);
                    screen1.putExtra(getResources().getString(R.string.pfecha_nacimiento),date);
                    screen1.putExtra(getResources().getString(R.string.ptelefono),phone);
                    screen1.putExtra(getResources().getString(R.string.pemail),e_mail);
                    screen1.putExtra(getResources().getString(R.string.pdescripcion),description);
                    startActivity(screen1);

                }else{
                    Toast.makeText(getBaseContext(),getResources().getString(R.string.aviso),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showDatePickerDialog(){
        DatePickerFragment fragment1 = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because january is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                tietFecha1.setText(selectedDate);
            }
        });
        fragment1.show(getSupportFragmentManager(), "datePicker");
    }
}
