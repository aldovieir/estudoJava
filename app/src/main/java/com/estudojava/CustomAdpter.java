package com.estudojava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdpter extends BaseAdapter {

    Context mContext;
    ArrayList<Modelcadastro> cadastro = new ArrayList<>();

    public CustomAdpter(Context context, ArrayList<Modelcadastro> cadastro) {
        mContext = context;
        this.cadastro = cadastro;
    }


    @Override
    public int getCount() {
        return cadastro.size();
    }

    @Override
    public Object getItem(int position) {
        return cadastro.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView ==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_lista,parent, false);
        }
          Modelcadastro tempCadastro = (Modelcadastro) getItem(position);
        TextView tvCpf = (TextView)convertView.findViewById(R.id.tvCpf);
        TextView tvDataNascimento = (TextView)convertView.findViewById(R.id.tvDatanascimento);
        TextView tvNomeMae = (TextView)convertView.findViewById(R.id.tvNomeMae);

        TextView tvGenero = (TextView)convertView.findViewById(R.id.tvGenero);

        tvCpf.setText(tempCadastro.getCpf());
        tvDataNascimento.setText(tempCadastro.getData_nascimento());
        tvNomeMae.setText(tempCadastro.getNome_mae());
        tvGenero.setText(tempCadastro.getGenero());
        return convertView;
    }
}
