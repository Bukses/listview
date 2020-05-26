package layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listview.R

class CustomAdapter(val userList:ArrayList<User>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName=itemView.findViewById(R.id.newsPaper) as TextView
        val iconsimage=itemView.findViewById(R.id.newsPaperlogo) as ImageView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: User=userList[position]

        holder.textViewName.text=user.text
        holder.iconsimage.setImageResource(user.image)
    }

}