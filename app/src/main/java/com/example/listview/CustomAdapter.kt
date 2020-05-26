package layout

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listview.R
import com.example.listview.WebView

class CustomAdapter(private val userList:ArrayList<User>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var img_icon: ImageView = itemView.findViewById(R.id.newsPaperlogo)
        var txt_desc: TextView = itemView.findViewById(R.id.newsPaper)
        private var clicklistener: Clicklistener? = null

        init{
            itemView.setOnClickListener(this)
        }

        fun setClicklistener(clicklistener: Clicklistener){
        this.clicklistener = clicklistener }

        override fun onClick(v: View?) {
            clicklistener?.setOnClickListener(adapterPosition)
        }


    }
    private lateinit var clicklistener: Clicklistener

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

        holder.itemView.setOnClickListener(object: Clicklistener {
            override fun setOnClickListener(position: Int) {
                val intent = Intent (itemView.context, WebView::class.java)
                itemView.context.StartActivity(intent)
            }


        }

        }
    }


}



