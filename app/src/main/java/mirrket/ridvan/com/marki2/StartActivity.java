package mirrket.ridvan.com.marki2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ozan on 1.05.2016.
 */
public class StartActivity extends AppCompatActivity {

    Button yeni,sorgu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        yeni=(Button)findViewById(R.id.yeniRota);
        sorgu=(Button)findViewById(R.id.sorgulama);

        yeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent yeniAc=new Intent(getBaseContext(),MapsActivity.class);
                startActivity(yeniAc);
            }
        });

        sorgu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent cardAc=new Intent(getBaseContext(),MainActivity.class);
                startActivity(cardAc);
            }
        });
    }
}
