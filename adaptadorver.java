package adaptadores;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elbosquepractica2p2.R;
import com.example.elbosquepractica2p2.cardview;

import Global.info;

public class adaptadorver extends RecyclerView.Adapter<adaptadorver.MiniActivity> {
    public Context context;
    @NonNull
    @Override

    public MiniActivity onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v=View.inflate(context,R.layout.mi_vista,null);
        MiniActivity obj=new MiniActivity(v);
        return obj;
    }

    @Override
    public void onBindViewHolder(@NonNull MiniActivity miniActivity, int i) {
         final int pos=i;
         miniActivity.nombre.setText(info.lista.get(i).getNombre());
         miniActivity.nombre.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent card = new Intent(context, cardview.class);
                 card.putExtra("posicion",pos);
                 //card.putExtra("tipoUser",pos);
                 context.startActivity(card);
             }
         });

    }

    @Override
    public int getItemCount() {
        return info.lista.size();
    }

    public class MiniActivity extends RecyclerView.ViewHolder {
        public TextView nombre;
        public MiniActivity(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.txt_name_rv);
        }
    }
}
