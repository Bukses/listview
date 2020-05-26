package com.example.listview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import layout.CustomAdapter
import layout.User

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView= findViewById<RecyclerView>(R.id.listView)
        listView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL, false)


        val users=ArrayList<User>()

        users.add(User("The Voice Newspaper", image = R.drawable.contact_nb ))
        users.add(User("The Voice Newspaper", image = R.drawable.contact_nb ))
        users.add(User("The Voice Newspaper", image = R.drawable.contact_nb ))
        users.add(User("The Voice Newspaper", image = R.drawable.contact_nb ))
        users.add(User("The Voice Newspaper", image = R.drawable.contact_nb ))
        users.add(User("The Voice Newspaper", image = R.drawable.contact_nb ))
        users.add(User("The Voice Newspaper", image = R.drawable.contact_nb ))
        users.add(User("The Voice Newspaper", image = R.drawable.contact_nb ))
        users.add(User("The Voice Newspaper", image = R.drawable.contact_nb ))
        users.add(User("The Voice Newspaper", image = R.drawable.contact_nb ))

    }
}
