package com.example.carla_pc.beacons_piloto;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class BeaconsActivity extends AppCompatActivity {
    Button labDigital;
    Button depComercial;
    Button RecursosHumanos;
    TextView titulo;
    Button buscarBeacons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beacons);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        labDigital = (Button) findViewById(R.id.btnLaboratorioDigital);
        depComercial = (Button) findViewById(R.id.btnDepartamentoComercial);
        RecursosHumanos = (Button) findViewById(R.id.btnRecursosHumanos);
        titulo = (TextView) findViewById(R.id.titulo);
        buscarBeacons = (Button) findViewById(R.id.btnBuscBeacons);

        Typeface customfont = Typeface.createFromAsset(getAssets(), "fonts/weblysleekuil.ttf");
        labDigital.setTypeface(customfont);
        depComercial.setTypeface(customfont);
        RecursosHumanos.setTypeface(customfont);
        titulo.setTypeface(customfont);

        labDigital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent labDigital = new Intent(BeaconsActivity.this, LaboratorioDigital.class);
                //labDigital.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(labDigital);
            }

        });
        depComercial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent depComerc = new Intent(BeaconsActivity.this, DepartamentoComercial.class);
                //labDigital.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(depComerc);
            }

        });
        RecursosHumanos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recHumanos = new Intent(BeaconsActivity.this, RecursosHumanos.class);
                //labDigital.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(recHumanos);
            }

        });

        buscarBeacons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recHumanos = new Intent(BeaconsActivity.this, BuscarBeacons.class);
                //labDigital.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(recHumanos);
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_beacons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent beacon = new Intent(BeaconsActivity.this, BuscarBeacons.class);
            //labDigital.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(beacon);
        }
        return super.onOptionsItemSelected(item);
    }

}
