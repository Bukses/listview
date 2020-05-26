package com.example.listview

import android.content.ComponentName
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsClient
import androidx.browser.customtabs.CustomTabsServiceConnection
import androidx.browser.customtabs.CustomTabsSession
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import layout.User

class MainActivity : AppCompatActivity() {

    private var mCustomTabsServiceConnection: CustomTabsServiceConnection? = null
    private var mClient: CustomTabsClient? = null
    private var mCustomTabsSession: CustomTabsSession? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCustomTabs()
        //Use RecyclerView.VERTICAL not LinearLayout.VERTICAL
        listView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

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

    override fun onResume() {
        super.onResume()
        showWebView("https://thevoicenews.com.ng/")
    }

    private fun initCustomTabs() {
        mCustomTabsServiceConnection = object : CustomTabsServiceConnection() {
            override fun onCustomTabsServiceConnected(componentName: ComponentName, customTabsClient: CustomTabsClient) {
                //Pre-warming
                mClient = customTabsClient
                mClient?.warmup(0L)
                mCustomTabsSession = mClient?.newSession(null)
            }

            override fun onServiceDisconnected(name: ComponentName) {
                mClient = null
            }
        }

        CustomTabsClient.bindCustomTabsService(this, CUSTOM_TAB_PACKAGE_NAME, mCustomTabsServiceConnection as CustomTabsServiceConnection)
    }

    companion object {
        val CUSTOM_TAB_PACKAGE_NAME = "com.android.chrome";
    }
}
