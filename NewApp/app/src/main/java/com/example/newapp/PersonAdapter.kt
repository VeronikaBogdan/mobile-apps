package com.example.newapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(val plist: MutableList<Person>): RecyclerView.Adapter<PersonViewHolder>() {
    class PersonViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return flater = LayoutInflater.from(parent.context)
        val holder = PersonViewHolder(inflater.inflate(R.layout.item_layout, parent, ))
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val fName = holder.itemView.findViewById<TextView>(R.id.name)
        val fSecondView = holder.itemView.findViewById<TextView>(R.id.secondName)
        val fAge = holder.itemView.findViewById<TextView>(R.id.age)
        val fImage = holder.itemView.findViewById<TextView>(R.id.imageView)

        fName.text = plist(position).name
        fSecondView = plist(position).secondName
        fAge = plist(position).age
        fImage = plist(position).
    }

    override fun getItemCount(): Int {
        return plist.size
    }
}