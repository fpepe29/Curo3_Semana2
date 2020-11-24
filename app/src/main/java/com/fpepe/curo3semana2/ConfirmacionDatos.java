package com.fpepe.curo3semana2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmacionDatos extends AppCompatActivity {
    TextView tvNombreCoger;
    TextView tvTelefonoCoger;
    TextView tvFechaCoger;
    TextView tvEmailCoger;
    TextView tvDescripcionCoger;
    TextView tvEditar;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);

         Bundle parametros1 = getIntent().getExtras();
         String name1 = parametros1.getString(getResources().getString(R.string.pnombre));
         String data1 = parametros1.getString(getResources().getString(R.string.pfecha_nacimiento));
         String phone1 = parametros1.getString(getResources().getString(R.string.ptelefono));
         String e_mail1 = parametros1.getString(getResources().getString(R.string.pemail));
         String description1 = parametros1.getString(getResources().getString(R.string.pdescripcion));

         tvNombreCoger = (TextView) findViewById(R.id.tvNombre_completo);
         tvFechaCoger = (TextView) findViewById(R.id.tvFecha);
         tvTelefonoCoger = (TextView) findViewById(R.id.tvTelefono) ;
         tvEmailCoger = (TextView) findViewById(R.id.tvEmail);
         tvDescripcionCoger = (TextView) findViewById(R.id.tvDescripcion_contacto);
         tvEditar =(TextView) findViewById(R.id.tvEditarDatos) ;

         tvNombreCoger.setText(name1);
         tvFechaCoger.setText(getResources().getString(R.string.Cfecha)+" "+data1);
         tvTelefonoCoger.setText(getResources().getString(R.string.Ctel)+" "+phone1);
         tvEmailCoger.setText(getResources().getString(R.string.Cemail)+" "+ e_mail1);
         tvDescripcionCoger.setText(getResources().getString(R.string.Cdescripcion)+" "+ description1);


         tvEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name2 = tvNombreCoger.getText().toString();
                    if(!name2.equals("")){
                       onBackPressed();
                    }
                }});
     }

}
