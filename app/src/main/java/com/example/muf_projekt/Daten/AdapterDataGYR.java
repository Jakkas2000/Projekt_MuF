package com.example.muf_projekt.Daten;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.muf_projekt.R;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class AdapterDataGYR extends RecyclerView.Adapter<AdapterDataGYR.DataGYRViewHolder>{
    public DataGYRViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_datagyr, parent, false);
        return new DataGYRViewHolder(v);
    }

    private List<DataGYR> listDG = new ArrayList<>();

    @Override
    public void onBindViewHolder(@NonNull DataGYRViewHolder holder, int position) {
        DataGYR dg = listDG.get(position);
        //DecimalFormat decimalFormat = new DecimalFormat("0.######");
        //%-Operator um den Timestamp zu kürzen, hier jetzt 1000 s Spannbreite der Werte
        // Wenn mehr gewünscht ist, diesen Schritt evtl. weglassen
        //Dient nur der besseren Anzeige in diesem Beispiel
        //String time = decimalFormat.format(dg.getTimestamp());
        //String x = decimalFormat.format(dg.getGyr_x());
        //String y = decimalFormat.format(dg.getGyr_y());
        //String z = decimalFormat.format(dg.getGyr_z());

        /*Durch Formating keine Umwandlung mehr zu String notwendig
        //holder.textViewAccDataTime.setText(String.valueOf(accData.getTimestamp()));
        holder.textViewDataACCX.setText(String.valueOf(DataACC.getAcc_x()));
        holder.textViewDataACCY.setText(String.valueOf(DataACC.getAcc_y()));
        holder.textViewDataACCZ.setText(String.valueOf(DataACC.getAcc_z()));*/
        holder.textViewDataGYRTime.setText(String.valueOf(dg.getTimestamp()));
        holder.textViewDataGYRX.setText(String.valueOf(dg.getGyr_x()));
        holder.textViewDataGYRY.setText(String.valueOf(dg.getGyr_y()));
        holder.textViewDataGYRZ.setText(String.valueOf(dg.getGyr_z()));
    }

    @Override
    public int getItemCount() {
        return listDG.size();
    }

    static class DataGYRViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewDataGYRX;
        private TextView textViewDataGYRY;
        private TextView textViewDataGYRZ;
        private TextView textViewDataGYRTime;

        public DataGYRViewHolder(@NonNull View itemView) {
            super(itemView);
            //Verweise auf accdata_Layout textViews
            textViewDataGYRX = itemView.findViewById(R.id.textViewDataGYRX);
            textViewDataGYRY = itemView.findViewById(R.id.textViewDataGYRY);
            textViewDataGYRZ = itemView.findViewById(R.id.textViewDataGYRZ);
            textViewDataGYRTime = itemView.findViewById(R.id.textViewDataGYRTime);
        }
    }

    public void setlistDG(List<DataGYR> gyrDataList){

        this.listDG = gyrDataList;
        notifyDataSetChanged();
    }
}

