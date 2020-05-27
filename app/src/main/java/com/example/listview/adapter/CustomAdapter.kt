package com.example.listview.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.listview.R
import com.example.listview.User
import com.example.listview.interfaces.Clicklistener
import kotlinx.android.synthetic.main.list_layout.view.*
import java.util.*
import kotlin.collections.ArrayList

@Suppress("UNCHECKED_CAST")
class CustomAdapter(private val userList: ArrayList<User>, private val listener: Clicklistener) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>(), Filterable {

    var filterList = userList

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: User) = with(itemView) {
            newsPaperlogo.setImageResource(item.image)
            newsPaper.apply {
                text = item.text
                isSelected = true
            }
            setOnClickListener {
                listener.setOnClickListener(item.url)
            }
            if (item.text.equals("independent", true) || item.text.equals("daily post", true) || item.text.equals("The Nation", true)) {
                cardView.setCardBackgroundColor(Color.parseColor("#CFCFCF"))
            } else {
                cardView.setCardBackgroundColor(Color.parseColor("#FAFAFA"))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) =
        holder.bind(userList[position])

    override fun getFilter(): Filter {
        return object : Filter(){

            override fun performFiltering(charString: CharSequence?): FilterResults {
                val charSearch = charString.toString()
                if  (charSearch.isEmpty())
                    filterList=userList
                else
                {
                    val resultList = ArrayList<User>()
                    for(row in userList) {
                        if (row.text.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(
                                Locale.ROOT
                            )
                            )
                        )
                        resultList.add(row)
                    }
                    filterList=resultList
                }
                val filterResults = Filter.FilterResults()
                filterResults.values = filterList
                return filterResults

            }

            override fun publishResults(charSquence: CharSequence?, filterResults: FilterResults?) {
               filterList = filterResults!!.values as ArrayList<User>
                notifyDataSetChanged()
            }

        }
    }


}

