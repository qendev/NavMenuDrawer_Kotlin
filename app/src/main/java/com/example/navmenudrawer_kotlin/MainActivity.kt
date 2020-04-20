package com.example.navmenudrawer_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import fragments.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var myProfileFragment: MyProfileFragment
    lateinit var tableOfContentsFragment: TableOfContentsFragment
    lateinit var contentDetailsFragment: ContentDetailsFragment
    lateinit var updateProfileFragment: UpdateProfileFragment
    lateinit var logOutFragment: LogOutFragment



    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,R.string. open_msg,R.string.closing_msg
        )

        //added the ActionBarDrawerToggle into our DrawerLayout view and synced it. Now it will display a drawer indicator in our app bar.
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)


    }




    // to detect user's interaction with the listed options in Navigation Drawer.
    //we'll need to implement a listener into our class using NavigationView.OnNavigationItemSelectedListener,
    // this will allow us to override onNavigationItemSelected() function.
    // Inside this function we can set what will happen after clicking which option.
    // And at the bottom of the function we closed the drawer using drawerLayout.closeDrawer(GravityCompat.START)
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_myprofile -> {
                myProfileFragment = MyProfileFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.linearlayout_content,myProfileFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_table -> {
               tableOfContentsFragment = TableOfContentsFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.linearlayout_content,tableOfContentsFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_details -> {
                contentDetailsFragment = ContentDetailsFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.linearlayout_content,contentDetailsFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.nav_update-> {
              updateProfileFragment = UpdateProfileFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.linearlayout_content,updateProfileFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

            R.id.nav_logout->{
                logOutFragment = LogOutFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.linearlayout_content,logOutFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(this,"Logout Clicked!",Toast.LENGTH_LONG).show()
            }
        }
        //closed the drawer using drawerLayout.closeDrawer(GravityCompat.START)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()

        }


    }



}