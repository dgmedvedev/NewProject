package by.itacademy.project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.itacademy.project.Note
import by.itacademy.project.R

class Adapter(private var items:List<Note>, private val listener: onClickListener):
RecyclerView.Adapter<Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notes,parent,false)
        val holder = Holder(view)

        holder.itemView.setOnClickListener {
            listener.onItemClick(items[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }


    override fun getItemCount(): Int {
        return items.size
    }

    fun updateList(newItems:List<Note>){
        items = newItems
        notifyDataSetChanged()
    }

    interface onClickListener {
        fun onItemClick(item: Note)
    }
}