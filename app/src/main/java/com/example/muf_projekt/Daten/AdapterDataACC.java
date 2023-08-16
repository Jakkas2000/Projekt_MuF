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

public class AdapterDataACC extends RecyclerView.Adapter<AdapterDataACC.DataACCViewHolder>{
    public DataACCViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_dataacc, parent, false);
        return new DataACCViewHolder(v);
    }

    private List<DataACC> listDA = new ArrayList<>();

    @Override
    public void onBindViewHolder(@NonNull DataACCViewHolder holder, int position) {
        DataACC da = listDA.get(position);
        DecimalFormat decimalFormat = new DecimalFormat("#");
        //%-Operator um den Timestamp zu kürzen, hier jetzt 1000 s Spannbreite der Werte
        // Wenn mehr gewünscht ist, diesen Schritt evtl. weglassen
        //Dient nur der besseren Anzeige in diesem Beispiel
        String time = decimalFormat.format(da.getTimestamp());
        String x = decimalFormat.format(da.getAcc_x());
        String y = decimalFormat.format(da.getAcc_y());
        String z = decimalFormat.format(da.getAcc_z());

        /*Durch Formating keine Umwandlung mehr zu String notwendig
        //holder.textViewAccDataTime.setText(String.valueOf(accData.getTimestamp()));
        holder.textViewDataACCX.setText(String.valueOf(DataACC.getAcc_x()));
        holder.textViewDataACCY.setText(String.valueOf(DataACC.getAcc_y()));
        holder.textViewDataACCZ.setText(String.valueOf(DataACC.getAcc_z()));
        holder.textViewDataACCTime.setText(String.valueOf(DataACC.getTimestamp()));
        /*holder.textViewAccDataX.setText(x);
        holder.textViewAccDataY.setText(y);
        holder.textViewAccDataZ.setText(z);*/
    }

    @Override
    public int getItemCount() {
        return listDA.size();
    }

    static class DataACCViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewDataACCX;
        private TextView textViewDataACCY;
        private TextView textViewDataACCZ;
        private TextView textViewDataACCTime;

        public DataACCViewHolder(@NonNull View itemView) {
            super(itemView);
            //Verweise auf accdata_Layout textViews
            textViewDataACCX = itemView.findViewById(R.id.textViewDataACCX);
            textViewDataACCY = itemView.findViewById(R.id.textViewDataACCY);
            textViewDataACCZ = itemView.findViewById(R.id.textViewDataACCZ);
            textViewDataACCTime = itemView.findViewById(R.id.textViewDataACCTime);
        }
    }

    public void setlistDA(List<DataACC> accDataList){

        this.listDA = accDataList;
        notifyDataSetChanged();
    }
}

