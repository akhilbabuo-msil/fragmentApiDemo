package com.subfire.fragmentapidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.subfire.fragmentapidemo.ui.main.DisplayFragment
import com.subfire.fragmentapidemo.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container2, MainFragment.newInstance())
                .commitNow()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1,DisplayFragment())
                .commitNow()
        }
    }
}