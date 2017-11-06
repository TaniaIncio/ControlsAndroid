package com.tincio.controls.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.tincio.controls.R;

/**
 * Created by tincio on 22/07/2016.
 */
public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolderItem> {

    String[] arrayString;
    Context context;

    public AdapterRecycler(String[] arrayString) {
        this.arrayString = arrayString;
    }

    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler, parent, false);
        ViewHolderItem viewHolder = new ViewHolderItem(view);
        this.context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        holder.txtItemRecycler.setText(arrayString[position]);
        setAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return arrayString.length;
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder {

        TextView txtItemRecycler;

        public ViewHolderItem(View itemView) {
            super(itemView);
            txtItemRecycler = (TextView) itemView.findViewById(R.id.txt_item_recycler);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.setOnItemClickListener(getPosition());
                    }
                }
            });
        }
    }

    OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        public void setOnItemClickListener(int posicion);
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    int lastPosition = 0;

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public void onViewDetachedFromWindow(ViewHolderItem holder) {
        super.onViewDetachedFromWindow(holder);
        //((ViewHolderItem)holder).clearAnimation();
    }

    public void clearAnimation() {
        // mRootLayout.clearAnimation();
    }
}
