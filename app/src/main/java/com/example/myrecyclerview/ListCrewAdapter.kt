package com.example.myrecyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListCrewAdapter(private val listCrew: List<Crew>) : RecyclerView.Adapter<ListCrewAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_onepiece, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val context = holder.itemView.context
        val (name, description, power, weak, photo, photobg) = listCrew[position]
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.imgPhoto.setImageResource(photo)
        holder.itemView.setOnClickListener {
        val intent=Intent(context, DetailCharacter::class.java)
            intent.putExtra(DetailCharacter.extraname, name)
            intent.putExtra(DetailCharacter.extradesc, description)
            intent.putExtra(DetailCharacter.extrapower, power)
            intent.putExtra(DetailCharacter.extraweak, weak)
            intent.putExtra(DetailCharacter.extrapic, photo)
            intent.putExtra(DetailCharacter.extrabg, photobg)
            context.startActivity(intent)
        }

    }
    override fun getItemCount(): Int = listCrew.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Crew)
    }
}