package com.liliane.contactbook

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.liliane.contactbook.databinding.ContactListItemBinding
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class ContactRvAdapter (var ContactList:List<Contact>):
    RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding= ContactListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
//        var contactViewHolder=contactViewHolder(binding)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact=ContactList.get(position)
        holder.binding.tvName.text=currentContact.name
        holder.binding.tvPhone.text=currentContact.phone
        holder.binding.tvEmail.text=currentContact.email
        holder.binding.tvAddress.text=currentContact.address

        Picasso.get()
            .load(currentContact.image).error(R.drawable.ic_baseline_person_24)
            .resize(300,300)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_person_24)
            .networkPolicy(NetworkPolicy.OFFLINE)
            .into(holder.binding.ivContact)
        val context=holder.itemView.context
        holder.binding.ivContact.setOnClickListener{
            Toast
                .makeText(context,"You have clicked the image", Toast.LENGTH_SHORT)
                .show()
        }
        holder.binding.cvContact.setOnClickListener {
            val intent= Intent(context,ViewContactActivity::class.java)
            intent.putExtra("NAME",currentContact.name)
            intent.putExtra("ADDRESS",currentContact.address)
            intent.putExtra("PHONE",currentContact.phone)
            intent.putExtra("IMAGE",currentContact.image)
            intent.putExtra("EMAIL",currentContact.email)
            context.startActivity(intent)
        }
    }




    override fun getItemCount(): Int {
        return ContactList.size
    }
}

class  ContactViewHolder(val binding:ContactListItemBinding):
    RecyclerView.ViewHolder(binding.root){


}


