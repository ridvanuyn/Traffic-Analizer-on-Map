package mirrket.ridvan.com.marki2;

import android.content.Context;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by admin on 30.4.2016.
 */
public class Data {


    static ArrayList<Info> data=new ArrayList<>();

    public static ArrayList<Info> getData(){

       final Info infoNesnesi=new Info();
        MainActivity ma=new MainActivity();

/*

        int [] images={
                R.drawable.magazine,
                R.drawable.magazine,


        };

        String[] title={"magazine","magazine"};

        for (int i=0;i<images.length;i++){


            infoNesnesi.imgId=images[i];
            infoNesnesi.title=title[i];

            data.add(infoNesnesi);



        }*/

        return data;
    }

    //Fonksiyon ile gelen verilerin eklenmesi

    /*
    public void eklenen(String ad, int images)
    {
        Info fonksiyon=new Info();
        fonksiyon.imgId=images;
        fonksiyon.title=ad;

        data.add(fonksiyon);

    }
*/
}

