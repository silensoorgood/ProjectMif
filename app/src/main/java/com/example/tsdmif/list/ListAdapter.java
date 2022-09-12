package com.example.tsdmif.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tsdmif.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private static LayoutInflater inflater;
    private static List<ListViewModel> models;
    private Adapter adapter;

    public ListAdapter(Context context, List<ListViewModel> models,Adapter adapter) {
        this.models = models;
        this.inflater = LayoutInflater.from(context);
        this.adapter = adapter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        if (models.get(0).a.equals("нуль")) {
            TextView textView = view.findViewById(R.id.name);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            textView.setLayoutParams(layoutParams);
            view.findViewById(R.id.data).setVisibility(View.INVISIBLE);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        ListViewModel model = models.get(position);// Получаем позицию и заполняем

        holder.nameView.setText(model.a);
        holder.dataView.setText(model.b);
        holder.nameView.setOnClickListener(v -> adapter.click());
        holder.dataView.setOnClickListener (v -> adapter.click());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, dataView;

        ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.data);
            dataView = view.findViewById(R.id.name);
        }
    }
}