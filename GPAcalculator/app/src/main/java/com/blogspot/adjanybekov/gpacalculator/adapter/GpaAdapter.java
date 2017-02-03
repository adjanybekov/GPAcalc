package com.blogspot.adjanybekov.gpacalculator.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.adjanybekov.gpacalculator.R;

/**
 * Created by User on 13/08/2016.
 */
public class GpaAdapter extends RecyclerView.Adapter<GpaAdapter.ViewHolder> {

    Cursor cursor;
    int nameColumnIndex = 1;
    int creditColumnIndex = 2;
    int gradeColumnIndex = 3;
    int idColumnIndex =0 ;

    String[] array  = {"1 ", "2","3", "4" };
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_course, parent, false);

        // wrap it in a ViewHolder
        return new ViewHolder(v);
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Context context = holder.cardView.getContext();
        final long id = getItemId(position);
        cursor.moveToFirst();

        holder.courseNameView.setText(array[position]);
       /* holder.creditView.setText(cursor.getString(creditColumnIndex));
        holder.gradeView.setText(cursor.getString(gradeColumnIndex));*/

    }

    @Override
    public long getItemId(int position) {
//        array[position];
//        cursor.moveToPosition(position);
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return array.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView courseNameView;
        TextView creditView;
        TextView gradeView;


        public ViewHolder(CardView itemView) {
            super(itemView);
            cardView = itemView;
            creditView     = (TextView) itemView.findViewById(R.id.text1);
            gradeView      = (TextView) itemView.findViewById(R.id.text2);
            courseNameView = (TextView) itemView.findViewById(R.id.text3);

        }
    }
}
