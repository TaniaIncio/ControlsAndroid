package com.tincio.controls.adapter;

import android.content.Context;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tincio.controls.R;

import java.util.List;

/**
 * Created by innovagmd on 03/09/16.
 */
public class AdapterRecyclerGridLayout extends  RecyclerView.Adapter<AdapterRecyclerGridLayout.ViewHolderItem> {

    List arrayString;
    Context context;

    public AdapterRecyclerGridLayout(List arrayString) {
        this.arrayString = arrayString;
    }

    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_grid_layout, parent, false);
        ViewHolderItem viewHolder = new ViewHolderItem(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        holder.txtItemRecycler.setText(arrayString.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return arrayString.size();
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder {

        TextView txtItemRecycler;
        ImageView iconfavorito;
        String favoritoOff= "ic_favorite_border_white_24dp";
        String favoritoOn= "ic_favorite_white_24dp";
        int imagen ;

        public ViewHolderItem(View itemView) {
            super(itemView);
            txtItemRecycler = (TextView) itemView.findViewById(R.id.activity_gridlayout_txt);
            iconfavorito = (ImageView)itemView.findViewById(R.id.activity_gridlayout_iconfavorito);
            iconfavorito.setTag(favoritoOff);
            iconfavorito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(iconfavorito.getTag().equals(favoritoOff)){
                        imagen = context.getResources().getIdentifier(favoritoOn,"mipmap",context.getPackageName());
                        iconfavorito.setTag(favoritoOn);
                    }else{
                        imagen = context.getResources().getIdentifier(favoritoOff,"mipmap",context.getPackageName());
                        iconfavorito.setTag(favoritoOff);
                    }
                    iconfavorito.setImageDrawable(context.getResources().getDrawable(imagen));
                }
            });
        }
    }
}