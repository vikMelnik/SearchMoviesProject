package come.geekbrains.vitekm.searchmovies

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import come.geekbrains.vitekm.searchmovies.services.MainBroadcastReceiver
import come.geekbrains.vitekm.searchmovies.ui.main.ListFragment


class MainActivity : AppCompatActivity() {

    private val receiver = MainBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListFragment.newInstance())
                .commitNow()
        }


        val bottomNavigationView: BottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavigationView.setOnItemSelectedListener(object :
            NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.action_home -> {

                        return true
                    }
                    R.id.action_favorites -> {

                        return true
                    }
                    R.id.action_ratings -> {

                        return true
                    }
                }
                return false
            }
        })
        registerReceiver(receiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))


    }
    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }
}