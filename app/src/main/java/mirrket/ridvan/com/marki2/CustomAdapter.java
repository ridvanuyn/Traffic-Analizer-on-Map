package mirrket.ridvan.com.marki2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;

import java.util.ArrayList;

/**
 * Created by admin on 30.4.2016.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {

    Context context;
    ArrayList<Info> data;
    LayoutInflater inflater;
    int currentItem;

    public CustomAdapter(Context context, ArrayList<Info> data) {

        this.context=context;
        this.data=data;
        inflater =LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view=inflater.inflate(R.layout.row_card,parent,false);

        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int position) {




        myViewHolder.txtX.setText(data.get(position).konumX);
        myViewHolder.txtY.setText(data.get(position).konumY);
        myViewHolder.txtS.setText(data.get(position).speed);
        myViewHolder.txtT.setText(data.get(position).time);
        myViewHolder.txtD.setText(data.get(position).distance);

        //Cardview tıklama event
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"sayısı "+position,Toast.LENGTH_SHORT).show();
                Intent in =new Intent(context,MapsActivity.class);
                context.startActivity(in);

            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtX,txtY,txtS,txtT,txtD;

        CardView cardView;




        public MyViewHolder(View itemView) {
            super(itemView);



            txtX=(TextView)itemView.findViewById(R.id.txtX);
            txtY=(TextView)itemView.findViewById(R.id.txtY);
            txtS=(TextView)itemView.findViewById(R.id.txtS);
            txtT=(TextView)itemView.findViewById(R.id.txtT);
            txtD=(TextView)itemView.findViewById(R.id.txtD);


            cardView=(CardView)itemView.findViewById(R.id.cardView);



        }
    }
}
