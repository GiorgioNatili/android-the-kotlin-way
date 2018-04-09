package io.a2xe.experiments.pokemondeck.views.decks

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.a2xe.experiments.pokemondeck.R
import io.a2xe.experiments.pokemondeck.model.repositories.DecksRepository
import io.a2xe.experiments.pokemondeck.model.repositories.LocalDecksRepository
import io.a2xe.experiments.pokemondeck.views.decks.adatpers.DecksAdapter
import kotlinx.android.synthetic.main.fragment_decks.*

class DecksFragment : Fragment() {

    lateinit var decks: DecksRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("onCreate DecksFragment")

        decks = LocalDecksRepository(this.activity)
    }

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        println("onCreateView, Inflate the layout for DecksFragment")
        return inflater?.inflate(R.layout.fragment_decks, container, false)
    }

    override fun onStart() {
        super.onStart()

        val adapter = DecksAdapter(this.activity, decks.items)
        list_of_decks.adapter = adapter
    }
}
