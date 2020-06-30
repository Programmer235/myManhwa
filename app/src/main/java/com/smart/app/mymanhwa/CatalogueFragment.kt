package com.smart.app.mymanhwa

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import java.lang.ref.WeakReference


class CatalogueFragment(mContext: Context) : Fragment() {

    private val sectionAdapter = SectionedRecyclerViewAdapter()
    private lateinit var recyclerView_vertical: RecyclerView
    private lateinit var gridRecyclerView: RecyclerView
    private lateinit var mAdapter :GridRecyclerviewAdapter
    private  val mList: List<String> = listOf("Title 1",
        "Title 2", "Title 3",
        "Title 4", "Title 5",
        "Title 6", "Title 7",
        "Title 8", "Title 9",
        "Title 10", "Title 11",
        "Title 12", "Title 13",
        "Title 14", "Title 15",
        "Title 16", "Title 17",
        "Title 18", "Title 19",
        "Title 20", "Title 21",
        "Title 22", "Title 23",
        "Title 24", "Title 25",
        "Title 26", "Title 27",
        "Title 28", "Title 29", 
        "Title 30", "Title 31",
        "Title 32", "Title 33",
        "Title 34", "Title 35",
        "Title 36", "Title 37",
        "Title 38", "Title 39",
        "Title 40", "Title 41",
        "Title 42", "Title 43",
        "Title 44", "Title 45",
        "Title 46", "Title 47",
        "Title 48", "Title 49",
        "Title 50")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_catalogue, container, false)
        val layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        /*recyclerView_vertical = view.findViewById(R.id.vertical_rv)
        recyclerView_vertical.layoutManager = layoutManager
        recyclerView_vertical.adapter = sectionAdapter

        FetchDemoData(this.context as MainActivity, recyclerView_vertical, sectionAdapter).execute()*/
        configRecyclerview(view)
        return  view
    }

    fun configRecyclerview(mView: View){
        gridRecyclerView = mView.findViewById(R.id.grid_rv)
        gridRecyclerView.layoutManager = LinearLayoutManager(context)
        gridRecyclerView.layoutManager = GridLayoutManager(context, 3)
        mAdapter = context?.let { GridRecyclerviewAdapter(it, mList) }!!
        gridRecyclerView.adapter = mAdapter
    }


    private class FetchDemoData
    internal constructor(mContext: MainActivity, verticalRecyclerView: RecyclerView, sectionAdapter: SectionedRecyclerViewAdapter) :
        AsyncTask<Void, Void, Void>() {

        private val activityReference: WeakReference<MainActivity> = WeakReference(mContext)

        var verticalRv = verticalRecyclerView
        var secAdapter = sectionAdapter

        val colors = Colors().objectsArray

        override fun doInBackground(vararg params: Void): Void? {
            for (color in colors) {
                secAdapter.addSection(
                    Vertical_RVAdapter(
                        color.category,
                        color.subcategory,
                        color.colors
                    )
                )
            }
            return null
        }

        override fun onPostExecute(result: Void?) {
            // get a reference to the activity if it is still there
            val activity = activityReference.get()
            if (activity == null || activity.isFinishing) return
            verticalRv.adapter?.notifyDataSetChanged()
        }
    }

}