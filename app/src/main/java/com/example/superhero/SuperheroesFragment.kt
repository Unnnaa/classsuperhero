package com.example.superhero

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.superhero.R.drawable.spiderman

class SuperheroesFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1

//    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_superheroes_list, container, false)
        val names = listOf("Superman","Spiderman","Wonderwoman","Thor","Batman")
        val powers = listOf(100,90,89,92,70)
        val genders = listOf("M","M","F","M","M")
        val image = listOf(R.drawable.superman, spiderman)

        val superheroes = ArrayList<HashMap<String, Any>>()

        for(i in 0 until names.size) {

            val heroHashMap:HashMap<String, Any> = HashMap()

            heroHashMap["name"] = names[i]
            heroHashMap["power"] = powers[i]
            heroHashMap["gender"] = genders[i]
            heroHashMap["image"] = image[i]

            superheroes.add(heroHashMap)
        }

//        val superheroes = arrayOf<String>("Superman", "Spider man", "Wonder woman", "Thor", "Black Panther", "Batman", "Cat", "Invisible Woman", "Iron man", "Hulk", "Aquaman")
//        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = MySuperheroesRecyclerViewAdapter(activity as MainActivity,superheroes)
            }
        }
        return view
    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is OnListFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        listener = null
//    }

//    interface OnListFragmentInteractionListener {
//        // TODO: Update argument type and name
//        fun onListFragmentInteraction(item: DummyItem?)
//    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

    }
}
