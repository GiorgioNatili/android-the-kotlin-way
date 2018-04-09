package io.a2xe.experiments.pokemondeck

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import io.a2xe.experiments.pokemondeck.utilities.replaceFragment
import io.a2xe.experiments.pokemondeck.views.cards.CardsFragment
import io.a2xe.experiments.pokemondeck.views.decks.DecksFragment
import io.a2xe.experiments.pokemondeck.views.help.HelpFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val fragment = when (item.itemId) {
            R.id.nav_cards -> CardsFragment()
            R.id.nav_decks -> DecksFragment()
            else -> HelpFragment()
        }

        replaceFragment(fragment, R.id.content_frame)

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
