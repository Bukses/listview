package com.example.listview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listview.R
import com.example.listview.User
import com.example.listview.interfaces.Clicklistener
import kotlinx.android.synthetic.main.list_layout.view.*

class CustomAdapter(private val userList: ArrayList<User>, private val listener: Clicklistener) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: User) = with(itemView) {
            newsPaperlogo.setImageResource(item.image)
            newsPaper.text = item.text
            setOnClickListener {
                listener.setOnClickListener(item.url)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(userList[position])


}



