package io.a2xe.experiments.pokemondeck.views.decks

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.a2xe.experiments.pokemondeck.R

class DecksFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("onCreate DecksFragment")

    }

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        println("onCreateView, Inflate the layout for DecksFragment")
        return inflater?.inflate(R.layout.fragment_decks, container, false)
    }
}
