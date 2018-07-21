package hutecom.pizza.pizaapick;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    Spinner spinner1,spinner2;
    TextView text1,text2,texttotal,textnumber1,textnumber2;
    int Quantity1,Quantity2;
    double prixpiza,prixcafe,prixtotal,totale1,totale2;
    String piza,cafe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        /*
        Definition of variables
         */
        prixpiza = 0;
        prixcafe = 0;
        prixtotal = 0;
        Quantity1 = 0;
        Quantity2 = 0;
        spinner1=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);
        text1=findViewById(R.id.txttotalpiza);
        text2=findViewById(R.id.txttotalcafe);
        texttotal=findViewById(R.id.txttotalorder);
        textnumber1 = findViewById(R.id.editetxtpiza);
        textnumber2 = findViewById(R.id.editetxtcafe);



        // Initializing a String Array piza
        List<String> lestpiza = new ArrayList<>();
        lestpiza.add("Pizza aux 3 fromages");
        lestpiza.add("Pizza blanche");
        lestpiza.add("Pizza aux champignons");

        // Initializing an ArrayAdapter
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_item,lestpiza
        );

        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(spinnerArrayAdapter);

        //When clicking on spinner executes this code

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                piza = (adapterView.getItemAtPosition(position).toString());
            piza = (adapterView.getItemAtPosition(position).toString());
            if (piza=="Pizza aux 3 fromages"){
                prixpiza = 122;
            }
            else  if (piza=="Pizza blanche"){
                prixpiza = 100;
            }
            else if (piza=="Pizza aux champignons"){
                prixpiza = 80;
            }
            else {prixpiza = 00;}

            text1.setText(Double.toString(prixpiza)+"$");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Initializing a String Array cafe
        List<String> lestSoftdrinks = new ArrayList<>();
        lestSoftdrinks.add("Coca cola");
        lestSoftdrinks.add("Pepsi");
        lestSoftdrinks.add("Fanta");

        // Initializing an ArrayAdapter

        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_item,lestSoftdrinks);
        spinnerArrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(spinnerArrayAdapter2);

        //When clicking on spinner executes this code

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                text2.setText(adapterView.getItemAtPosition(position).toString());
             cafe =  (adapterView.getItemAtPosition(position).toString());
             if (cafe=="Pepsi"){
                 prixcafe = 19 ;
             }
             else if (cafe =="Coca cola"){
                 prixcafe = 12 ;
             }
             else if (cafe=="Fanta"){
                 prixcafe = 7;
             }
             else { prixcafe = 0;}
             text2.setText(prixcafe +"$");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    //Function when pressed button  to increase the quantity piza

    public void increment(View view) {
        if (Quantity1==100){
            Toast.makeText(this,"imposible de selection +100 cop",Toast.LENGTH_SHORT).show();
            return;
        }
        Quantity1 = Quantity1+1;
        display1(Quantity1);

        totale1 = Quantity1*prixpiza ;
        text1.setText(Double.toString(totale1)+"$");
    }

    //Function when pressed button  to decrease the quantity piza


    public void decrement(View view) {
        if (Quantity1==1){
            Toast.makeText(this,"imposible de selection -1 cop",Toast.LENGTH_SHORT).show();
            return;
        }
        Quantity1 = Quantity1 - 1;
        display1(Quantity1);
        totale1 = Quantity1*prixpiza ;
        text1.setText(Double.toString(totale1)+"$");
    }


    //Function when pressed button  to increase the quantity cafe

    public void decrement2(View view) {
        if (Quantity2==1){
            Toast.makeText(this,"imposible de selection -1 cop",Toast.LENGTH_SHORT).show();
            return;
        }
        Quantity2 = Quantity2 - 1;
        display2(Quantity2);
        totale2 = Quantity2*prixcafe ;
        text2.setText(Double.toString(totale2));
    }

    //Function when pressed button  to decrease the quantity cafe

    public void increment2(View view) {
        if (Quantity2==100){
            Toast.makeText(this,"imposible de selection +100 cop",Toast.LENGTH_SHORT).show();
            return;
        }
        Quantity2 = Quantity2+1;
        display2(Quantity2);
        totale2 = Quantity2*prixcafe ;
        text2.setText(Double.toString(totale2));
    }

    private void display1(int number) {
        textnumber1.setText(""+number);
    }
    private void display2(int number) {
        textnumber2.setText(""+number);
    }

    //Function when pressed button  clear .clear all text of price and number

    public void clear(View view) {
        texttotal.setText("$00.00");
        text1.setText("00.00$");
        text2.setText("00.00$");
        textnumber2.setText("1");
        textnumber1.setText("1");

    }
    //Function when pressed button order now .Collect the total account

    public void order(View view) {
        double totale = ((totale1+totale2)*1.2)+4;
        texttotal.setText(Double.toString(totale));
    }
}
