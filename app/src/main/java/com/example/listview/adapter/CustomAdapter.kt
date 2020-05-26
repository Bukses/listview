package com.example.listview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listview.R
import com.example.listview.`interface`.ClickListener
import layout.User

class CustomAdapter(private val userList:ArrayList<User>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var img_icon: ImageView
        internal var txt_desc: TextView

        private var clicklistener: ClickListener? = null

        init {
            img_icon = itemView.findViewById(R.id.newsPaperlogo) as ImageView
            txt_desc = itemView.findViewById(R.id.newsPaper) as TextView

            setOnClickListener()
        }

        public fun onClick(v: View?) {
            clicklistener?.onCartItemClick(v, adapterPosition)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: User = userList[position]

        holder.txt_desc.text = user.text
        holder.img_icon.setImageResource(user.image)
    }

}

private fun setOnClickListener() {

}
