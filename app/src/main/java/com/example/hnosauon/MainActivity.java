package com.example.hnosauon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mail,pass;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = (EditText) findViewById(R.id.eMail);
        pass = (EditText) findViewById(R.id.ePass); //relacion parte grafica con logica
        button = findViewById(R.id.button);

        cargarPreferencias(mail,pass);
    }

    public void bt_empezar(View view) {

        String final_mail = mail.getText().toString();
        String final_pass = pass.getText().toString();


        //----------------- --PASAMOS A LA SEGUNDA ACTIVITY---------------------
        if (!final_mail.equals("") && !final_pass.equals("")) {
            guardarPreferencias(final_mail, final_pass);
        }
    }

    private void guardarPreferencias(String final_mail, String final_pass) {
        SharedPreferences preferencias = getSharedPreferences("DatosLogin", Context.MODE_PRIVATE); //Creamos el archivo sharedpreferences

        SharedPreferences.Editor editor = preferencias.edit();//objeto editor que nos permite editar el archivo creado(preferences)
        editor.putString("mail",final_mail);
        editor.putString("pass",final_pass); //almacenamos los datos


        editor.commit();
    }

    private void cargarPreferencias(EditText mail, EditText pass) {
        SharedPreferences preferencias = getSharedPreferences("DatosLogin", Context.MODE_PRIVATE);

        String correo = preferencias.getString("mail", "");
        String contrasenia = preferencias.getString("pass", "");//obtenemos los datos

        mail.setText(correo);
        pass.setText(contrasenia);
    }
}