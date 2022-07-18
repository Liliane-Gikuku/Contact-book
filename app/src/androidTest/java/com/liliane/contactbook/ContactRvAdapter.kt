package com.liliane.contactbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactRvAdapter(var contactList: List<Contact> ):RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_list_item,parent,false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact=contactList.get(position)
        holder.tvName.text=currentContact.name
        holder.tvPhone.text=currentContact.phone
        holder.tvEmail.text=currentContact.email
        holder.tvAddress.text=currentContact.address
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

}

class ContactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvPhone=itemView.findViewById<TextView>(R.id.tvPhone)
    var tvEmail=itemView.findViewById<TextView>(R.id.tvEmail)
    var tvAddress=itemView.findViewById<TextView>(R.id.tvAddress)

}