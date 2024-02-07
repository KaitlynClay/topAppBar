package com.example.topappbar

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // up/back button - home navigation enabled/disabled
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        setSupportActionBar(findViewById(R.id.my_toolbar))

    }
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            // User chooses the "Settings" item. Show the app settings UI.
            true
        }

        R.id.action_favorite -> {
            // User chooses the "Favorite" action. Mark the current item as a
            // favorite.
            true
        }

        else -> {
            // The user's action isn't recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_res, menu)

        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView

        // Configure the search info and add any event listeners.

        //Define the listener.
        val expandListener = object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                // Do something when the action item collapses.
                return true // Return true to collapse the action view.
            }

            override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                // Do something when it expands.
                return true // Return true to expand the action view.
            }
        }

        // Get the MenuItem for the action item.
        val actionMenuItem = menu?.findItem(R.id.action_settings)

        // Assign the listener to that action item.
        actionMenuItem?.setOnActionExpandListener(expandListener)

        // For anything else you have to do when creating the options menu,
        // do the following:

        return true
            }

}
