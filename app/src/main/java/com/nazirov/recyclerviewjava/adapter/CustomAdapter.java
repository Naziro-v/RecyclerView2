package com.nazirov.recyclerviewjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.nazirov.recyclerviewjava.R;
import com.nazirov.recyclerviewjava.model.Member;

import java.util.List;
import java.util.PrimitiveIterator;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_AVAILABLE_YES = 0;
    private static final int TYPE_AVAILABLE_NOT = 1;

    public Context context;
    public List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {
        if (members.get(position).isAvailable()) {
            return TYPE_AVAILABLE_YES;
        } else {
            return TYPE_AVAILABLE_NOT;
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_AVAILABLE_YES) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_loyaut_yes, parent, false);
            return new CustomViewYesHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_loyaut_not, parent, false);
        return new CustomViewNotHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof CustomViewYesHolder) {
            TextView first_name = ((CustomViewYesHolder) holder).first_name;
            TextView last_name = ((CustomViewYesHolder) holder).last_name;

            first_name.setText(member.getFirstName());
            last_name.setText(member.getLastName());

        }
 if (holder instanceof CustomViewNotHolder) {
            TextView first_name = ((CustomViewNotHolder) holder).first_name;
            TextView last_name = ((CustomViewNotHolder) holder).last_name;

            first_name.setText("This firstname is not available");
            last_name.setText("This lastname is not available");

        }


    }

    public class CustomViewYesHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView first_name, last_name;


        public CustomViewYesHolder(View v) {
            super(v);
            view = v;

            first_name= view.findViewById(R.id.first_name);
            last_name= view.findViewById(R.id.last_name);
        }
    }
    public class CustomViewNotHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView first_name, last_name;

        public CustomViewNotHolder( View v) {
            super(v);
            view=v;

            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);

        }
    }
}

