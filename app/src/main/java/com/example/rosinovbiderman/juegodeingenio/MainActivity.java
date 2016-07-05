package com.example.rosinovbiderman.juegodeingenio;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private FragmentTabHost tabHost;
    private String userName="";
    private String fondo="";
    private TextView navUserName;
    ArrayList<Jugadas> listjugadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        inicializarToolbar(); // Setear Toolbar como action bar
        inicializarTabs(); // Crear los tabs
        listjugadas = new ArrayList<Jugadas>();
    }

    private void inicializarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        setearListener(navigationView);
        navUserName = (TextView)navigationView.getHeaderView(0).findViewById(R.id.nav_iniciarsesion);

    }

    private void inicializarTabs() {
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        tabHost.addTab(
                tabHost.newTabSpec("tab1").setIndicator("Juego", null),
                FirstFragment.class, null);

        tabHost.addTab(
                tabHost.newTabSpec("tab2").setIndicator("Scores", null),
                SecondFragment.class, null);
    }


    private void setearListener(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                switch(item.getItemId()) {
                    case R.id.nav_fondo:
                        elegirColor().show();
                        break;
                    case R.id.nav_iniciarsesion:
                        FragmentManager fm = getSupportFragmentManager();
                        UserNameDialog userNameDialog = new UserNameDialog();
                        userNameDialog.show(fm, "fragment_edit_name");
                        break;
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    public Dialog elegirColor() {
        final String[] items = {"Rojo", "Azul", "Verde", "Amarillo", "Naranja"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Elija un color de fondo");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                Log.i("Dialogos", "Opción elegida: " + items[item]);
                switch (item){
                    case 0:
                        tabHost.getTabContentView().getChildAt(0).setBackgroundColor(getResources().getColor(R.color.Rojo));
                        break;
                    case 1:
                        tabHost.getTabContentView().getChildAt(0).setBackgroundColor(getResources().getColor(R.color.Azul));
                        break;
                    case 2:
                        tabHost.getTabContentView().getChildAt(0).setBackgroundColor(getResources().getColor(R.color.Verde));
                        break;
                    case 3:
                        tabHost.getTabContentView().getChildAt(0).setBackgroundColor(getResources().getColor(R.color.Amarillo));
                        break;
                    case 4:
                        tabHost.getTabContentView().getChildAt(0).setBackgroundColor(getResources().getColor(R.color.Naranja));
                        break;
                }
            }
        });

        return builder.create();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUserName (String userName) {
        this.userName = userName;  // Setear variable de clase
        navUserName.setText(userName); // Setear el texto en la cabecera del drawer
    }

    public String getUserName() {
        return userName;
    }

    public ArrayList<Jugadas> getLista(){ return listjugadas; }

    public void setLista(ArrayList<Jugadas> jugadas){
        listjugadas = jugadas;
    }
}
