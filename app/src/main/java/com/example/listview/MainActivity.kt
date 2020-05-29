package com.example.listview

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Filterable
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listview.adapter.CustomAdapter
import com.example.listview.interfaces.Clicklistener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Clicklistener {

    var searchView:SearchView?=null
    lateinit var adapter : CustomAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.apply {
            this.themedContext.setTheme(R.style.MyToolBarStyle)

        }
        val listView = findViewById<RecyclerView>(R.id.listView)
        listView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(this@MainActivity, RecyclerView.VERTICAL).apply {
                this.setDrawable(resources.getDrawable(R.drawable.item_divider))
            })
        }

        populate()
    }

    private fun populate() {

        val users=ArrayList<User>()

        users.add(User("The Voice Newspaper", R.drawable.ic_the_voice,"https://thevoicenews.com.ng/"))
        users.add(User("Blueprint Newspaper", R.drawable.ic_blueprint,"https://www.blueprint.ng/"))
        users.add(User("Business Day", R.drawable.ic_business_day,"https://businessday.ng/"))
        users.add(User("Compass Newspaper", R.drawable.ic_compass,"https://www.compassnewspaper.com.ng/"))
        users.add(User("Complete Sports", R.drawable.ic_complete_sport,"https://www.completesports.com/"))
        users.add(User("Daily Post", R.drawable.ic_daily_post,"https://dailypost.ng/"))
        users.add(User("Daily Times of Nigeria", R.drawable.ic_daily_times,"https://dailytimes.ng/"))
        users.add(User("Daily Trust", R.drawable.ic_daily_trust,"https://www.dailytrust.com.ng/"))
        users.add(User("Daylight Nigeria", R.drawable.ic_daylight,"https://daylightng.com/"))
        users.add(User("Entertainment Express", R.drawable.ic_express,"https://expressng.com/" ))
        users.add(User("Guardian", R.drawable.ic_guardian, "https://guardian.ng/"))
        users.add(User("Independent", R.drawable.ic_independent , "https://www.independent.ng/"))
        users.add(User("Leadership", R.drawable.ic_leadership, "https://leadership.ng/"))
        users.add(User("Mirror", R.drawable.ic_national_mirror, "https://www.nationalmirroronline.net/"))
        users.add(User("The Nation", R.drawable.ic_the_nation, "https://thenationonlineng.net/"))
        users.add(User("National Network", R.drawable.ic_national_network, "https://nationalnetworkonline.com/en/"))
        users.add(User("Punch", R.drawable.ic_punch, "https://punchng.com/"))
        users.add(User("Sahara Reporters", R.drawable.ic_sahara, "https://saharareporters.com/"))
        users.add(User("Tribune", R.drawable.ic_tribune, "https://tribuneonlineng.com/"))
        users.add(User("Vanguard", R.drawable.ic_vanguard, "https://www.vanguardngr.com/"))
        users.add(User("Premium Times", R.drawable.ic_premium_times, "https://www.premiumtimesng.com/"))
        users.add(User("Osun Defender", R.drawable.ic_osun, "http://www.osundefender.com/"))
        users.add(User("P.M. News", R.drawable.ic_pm_news, "https://www.pmnewsnigeria.com/"))
        users.add(User("Peoples Daily", R.drawable.ic_peoples_daily, "https://www.peoplesdailyng.com/"))
        users.add(User("Observer", R.drawable.ic_observer, "https://nigerianobservernews.com/"))
        users.add(User("Newswatch", R.drawable.ic_news_watch, "https://www.newswatch.ng/"))
        users.add(User("New Telegraph", R.drawable.ic_new_telegraph, "https://www.newtelegraphng.com/"))
        users.add(User("Nigerian Entertainment Today", R.drawable.ic_net, "https://thenet.ng/"))
        users.add(User("Tell Magazine", R.drawable.ic_tell, "https://tell.ng/"))
        users.add(User("The Cable", R.drawable.ic_thecable, "https://www.thecable.ng/"))
        users.add(User("Thisday", R.drawable.ic_this_day, "https://www.thisdaylive.com/"))
        users.add(User("The Sun", R.drawable.ic_the_sun, "https://www.sunnewsonline.com/?p=*****"))

        adapter = CustomAdapter (users,this)
        listView.adapter= adapter

    }

    override fun setOnClickListener(url: String) {
        showWebView(url)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)


        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu!!.findItem(R.id.action_search).actionView as SearchView
        searchView!!.setSearchableInfo(searchManager.getSearchableInfo((componentName)))
        searchView!!.maxWidth = Int.MAX_VALUE

        searchView!!.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_search){
            true
        }  else super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (!searchView!!.isIconified()) {
            searchView!!.onActionViewCollapsed();
        }else{
            super.onBackPressed();
        }
    }

}


