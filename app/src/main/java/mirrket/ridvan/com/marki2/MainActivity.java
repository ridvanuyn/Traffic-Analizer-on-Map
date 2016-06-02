package mirrket.ridvan.com.marki2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.maps.model.LatLng;

import java.util.Random;


/**
 * Created by admin on 30.4.2016.
 */
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog progress;
    MapsActivity maps;

    LatLng cardLocation,cardLocation2 ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MultiDex.install(this);

        cardLocation=new LatLng(40.900469, 31.186365);
        Data dat=new Data();


        for (int x=0;x<=5;x++){

            final Info infoNesnesi=new Info();
            Firebase.setAndroidContext(this);
            Firebase gir = new Firebase("https://warki.firebaseio.com/");

            gir.child("firebase-h"+x ).child("l").child("0").addValueEventListener(new ValueEventListener()

            {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    System.out.println(snapshot.getValue());

               /* Toast.makeText(this, snapshot.getValue().toString(), Toast.LENGTH_SHORT).show();*/

                    infoNesnesi.konumX =  "Konum ="+snapshot.getValue().toString();
}

                @Override
                public void onCancelled(FirebaseError error) {
                }
            });
            gir.child("firebase-h" +x).child("l").child("1").addValueEventListener(new ValueEventListener()

            {
                @Override
                public void onDataChange(DataSnapshot snapshot) {

                    infoNesnesi.konumY = "Konum ="+snapshot.getValue().toString();


                }

                @Override
                public void onCancelled(FirebaseError error) {
                }
            });

            Random rnd = new Random();

            int a = rnd.nextInt(45) ;
            infoNesnesi.speed="Hız = "+a+"";



    //double valueX2 = Double.parseDouble(infoNesnesi.konumX);
    //double valueY2 = Double.parseDouble(infoNesnesi.konumY);


    //cardLocation2=new LatLng(valueX2,valueY2);
    Random rnd2= new Random();
    int distance=rnd2.nextInt(920);
    double time =distance/a;

infoNesnesi.time="Yolculuk Zamanı = "+time+""+" saniye";

        infoNesnesi.distance="Uzaklık ="+distance;

        dat.data.add(infoNesnesi);


        }


        progress = new ProgressDialog(this);progress.setMessage("Rota Alınıyor");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();

final int totalProgressTime = 100;
final Thread t = new Thread() {
@Override
public void run() {
        int jumpTime = 0;

        while(jumpTime < totalProgressTime) {
        try {
        sleep(2000);
        jumpTime += 50;
        progress.setProgress(jumpTime);
        }
        catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }


        }progress.dismiss();
        }
        };
        t.start();


        // Verileri fonksiyon ile ekleme

        recyclerView=(RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new CustomAdapter(this,Data.getData());
        recyclerView.setAdapter(adapter);

        //Firebase Connection
     /*


        Firebase openFire=new Firebase("https://denemeridvan.firebaseio.com/");
        openFire.child("Gunler").child("haftasonu").child("gunduz").child("konum").setValue("Hız");*/

        }
        }
