package com.example.nurul.uts;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    private Context context;
    private List<MenuModel> myMenu;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView id, nama, jenis, harga, bahan, tipe;
        public MyViewHolder(View v) {
            super(v);
            nama = itemView.findViewById(R.id.namalaptop);
//            jenis = itemView.findViewById(R.id.jenis);
            harga = itemView.findViewById(R.id.harga);
//            bahan = itemView.findViewById(R.id.bahan);
            tipe = itemView.findViewById(R.id.tipe);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MenuAdapter(List<MenuModel> myMenu) {
        this.myMenu = myMenu;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MenuAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_list, parent, false);
        return new MyViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        MenuModel menu = myMenu.get(position);
//        holder.id.setText(menu.getId());
        holder.nama.setText(menu.getNamalaptop());
//        holder.jenis.setText(menu.getJenis());
        holder.harga.setText(menu.getHarga());
//        holder.bahan.setText(menu.getBahan());
        holder.tipe.setText(menu.getTipe());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return myMenu.size();
    }
}

