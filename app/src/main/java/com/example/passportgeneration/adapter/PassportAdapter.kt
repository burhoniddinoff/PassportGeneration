package com.example.passportgeneration.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.passportgeneration.database.Entity
import com.example.passportgeneration.databinding.ItemLayoutBinding

class PassportAdapter : RecyclerView.Adapter<PassportAdapter.PassportViewHolder>() {

    var passportList = mutableListOf<Entity>()
    lateinit var onItemClicked: (Entity) -> Unit
    lateinit var onDeleteClicked: (Entity, pos: Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassportViewHolder {
        return PassportViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PassportViewHolder, position: Int) {
        holder.bind(passportList[position])
    }


    override fun getItemCount(): Int = passportList.size

    inner class PassportViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(entity: Entity) {
            binding.textName.text = "${adapterPosition.plus(1)}. ${entity.lastName} ${entity.name}"
            itemView.setOnClickListener {
                onItemClicked.invoke(entity)
            }
            binding.btnMenu.setOnClickListener {
                onDeleteClicked(entity, adapterPosition)
            }
        }
    }

    fun updateList(list: MutableList<Entity>) {
        passportList = list
        notifyDataSetChanged()
    }
}