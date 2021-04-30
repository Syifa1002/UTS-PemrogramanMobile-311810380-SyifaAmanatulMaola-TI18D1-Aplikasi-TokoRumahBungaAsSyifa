package id.ac.pelitabangsa.uts_syifaamanatulmaola311810380;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ID, password;
    Button login;
    public Button btnEmail;
    public Button btnMap;
    public Button btnCall;
    public Button btnWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ID = (EditText) findViewById(R.id.ID);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        btnEmail = (Button) findViewById(R.id.btnEmail);
        btnCall = (Button) findViewById(R.id.btnCall);
        btnMap = (Button) findViewById(R.id.btnMap);
        btnWeb = (Button) findViewById(R.id.btnWeb);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ID.getText().toString();
                String pass = password.getText().toString();

                if (email.equals("Admin") && pass.equals("123456789")) {
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                }else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage(" ID dan Password Anda Salah").setNegativeButton("Coba Lagi", null).create().show();
                    ID.setText("");
                    password.setText("");


                }
            }
        });
    }
            public void onButtonTap(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"syifamaola@gmail.com"});
                intent.putExtra(Intent.EXTRA_CC, new String[] {"smaola17@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Email dari Aplikasi Android");
                intent.putExtra(Intent.EXTRA_TEXT, "Hai, ini adalah percobaan mengirim email dari aplikasi android");

                try {
                startActivity(Intent.createChooser(intent, "Ingin Mengirim Email ?"));
                } catch (android.content.ActivityNotFoundException ex) {
                //do something else
                }
            }

            public void showMap(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/dir/-6.3663483,107.0976767/McDonald's+Jababeka+II+Cikarang+McDonald's+Jababeka+II+Cikarang,+Jl.+Niaga+Raya+Metro+Boulevard+Kav.+CC3C,+Pasirsari,+Cikarang+Sel.,+Bekasi,+Jawa+Barat+17530/@-6.3316391,107.083604,13z/data=!3m1!4b1!4m8!4m7!1m0!1m5!1m1!1s0x2e698dd434ed7fb1:0x57673255225ef9c2!2m2!1d107.1520062!2d-6.3005491"));
                startActivity(intent);
            }

            public void callActivity(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:083823783714" ));
                startActivity(callIntent);
            }

            public void searchWeb(View view) {
                String url = "https://rumaysho.com/";
                Intent web =new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse(url));
                startActivity(web);
            }
}
