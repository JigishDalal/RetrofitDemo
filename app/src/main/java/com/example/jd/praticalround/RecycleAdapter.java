package com.example.jd.praticalround;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jd.praticalround.Model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JD on 01-07-2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Myviewholder> {
   private List<Contact> contacts;
    Context ctx;
    MainActivity activity;
    public RecycleAdapter(List<Contact> contacts,Context context) {
        this.contacts = contacts;
        this.ctx=context;
    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);

        return new Myviewholder(view,ctx,contacts);
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, final int position) {
        holder.firstname.setText(contacts.get(position).getFirstName());
        holder.lastname.setText(contacts.get(position).getLastName());
        holder.designation.setText(contacts.get(position).getDesignation());
        holder.lati.setVisibility(View.GONE);
        holder.logi.setVisibility(View.GONE);
        String path=Config.imges_path+contacts.get(position).getImage();
//        Toast.makeText(ctx,"path="+path,Toast.LENGTH_SHORT).show();
        Glide.with(ctx).load(path).placeholder(R.mipmap.ic_launcher).error(R.mipmap.pic).into(holder.imageView);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(ctx,"Name "+ contacts.get(position).getFirstName(),Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public int getItemCount() {
       Log.d("size","" +contacts.size());

        return contacts.size();
    }
    public class Myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView firstname;
        TextView lastname;
        TextView designation;
        TextView lati,logi;
        ImageView imageView;
        List<Contact> list;
        Context context;
        CheckBox checkBox;

        public Myviewholder(View itemView,Context context,List<Contact> contacts) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.list=contacts;
            this.context=context;
            imageView=(ImageView)itemView.findViewById(R.id.user_pic);
            firstname=(TextView)itemView.findViewById(R.id.first_name);
            lastname=(TextView)itemView.findViewById(R.id.last_name);
            designation=(TextView)itemView.findViewById(R.id.designation);
            lati=(TextView)itemView.findViewById(R.id.lati);
            logi=(TextView)itemView.findViewById(R.id.longi);
            checkBox =(CheckBox)itemView.findViewById(R.id.checkBox);
        }

        @Override
        public void onClick(View view) {
            int postion=getAdapterPosition();
            Contact contact=this.list.get(postion);
           Intent i=new Intent(this.context,MapsActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.putExtra("lati",contact.getLattiitude().toString());
            i.putExtra("longi",contact.getLongitude().toString());
            i.putExtra("name",contact.getFirstName().toString());
            i.putExtra("lastname",contact.getLastName().toString());
            context.startActivity(i);
        }
    }
}
