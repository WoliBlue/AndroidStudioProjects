package com.example.recycleviewpractica;

import android.annotation.SuppressLint;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder>  {
    private List<UserModel> userModelList;
    public ArticleAdapter(List<UserModel> userModelList) {
        this.userModelList = userModelList;

    }
    //creamos el viewHolder con la vista de un elemento sin personalizar
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }
    //usamos como base el viewHolder y lo personalizamos con los datos segun la posicion
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String name = userModelList.get(position).toString();
        holder.name1.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Id: "
                        +userModelList.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(),"click mantenido",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
    //indicamos el numero de elementos de la lista
    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    //creamos nuestro viewHolder con los tipos de elementos a modificar de un elemento (por ejemplo 2 textView)
    //obtenemos los elementos del layout_item que queremos que se vayan cambiado
    //esto es lo que vamos a ir reciclando
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name1;
        public ViewHolder(View v) {
            super(v);
            name1 = (TextView) v.findViewById(R.id.article_title);


        }
    }


}



