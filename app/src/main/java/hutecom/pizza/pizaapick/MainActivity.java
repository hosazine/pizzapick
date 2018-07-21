package hutecom.pizza.pizaapick;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startorder,btncontact,btnexit;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startorder =findViewById(R.id.btnstart);
        btncontact =findViewById(R.id.btncontact);
        btnexit =findViewById(R.id.btnexit);

        //strat intent of order

        startorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),OrderActivity.class);
                startActivity(intent);
            }
        });

        //start allertdielog of contact

        btncontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogecontact();
            }
        });

        //exit application

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);

            }
        });
    }

    public void dialogecontact() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context, R.style.MyDialogTheme);
        //alertDialogBuilder.setTitle("contact me on:");
        alertDialogBuilder.setMessage("Phone me on : +21206....\n"+ "Whatsapp Me on : +21264168...\n"+"Email Me on : ----")
                .setCancelable(false)

                .setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
        TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
        textView.setTextSize(18);

    }
}
