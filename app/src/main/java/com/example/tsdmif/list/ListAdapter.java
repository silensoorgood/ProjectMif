package com.example.tsdmif.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tsdmif.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private  LayoutInflater inflater;
    private  List<ListViewModel> models;
    private ListItemCallBack listItemCallBack;

    public ListAdapter(Context context, List<ListViewModel> models, ListItemCallBack listItemCallBack) {
        this.models = models;
        this.inflater = LayoutInflater.from(context);
        this.listItemCallBack = listItemCallBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        view.setClickable(true);


        if (models.get(0).a == null) {
            TextView textView = view.findViewById(R.id.name);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            textView.setLayoutParams(layoutParams);
            view.findViewById(R.id.data).setVisibility(View.INVISIBLE);
        }
        return new ViewHolder(view, listItemCallBack);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        ListViewModel model = models.get(position);// Получаем позицию и заполняем

        holder.nameView.setText(model.a);
        holder.dataView.setText(model.b);
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, dataView;
        private Integer position;
        public void setPosition(Integer position){
            this.position=position;
        }

        ViewHolder(View view, ListItemCallBack listItemCallBack) {
            super(view);
            position=0;
            nameView = view.findViewById(R.id.data);
            dataView = view.findViewById(R.id.name);
            view.setOnClickListener(view1 -> {
                Animation animRotate = AnimationUtils.loadAnimation(view.getContext(), R.xml.anim);
                view.startAnimation(animRotate);
                TextView s= view1.findViewById(R.id.data);
                listItemCallBack.click( this.position);


            });
        }


    }
}