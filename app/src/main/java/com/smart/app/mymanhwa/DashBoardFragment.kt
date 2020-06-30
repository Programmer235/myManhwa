package com.smart.app.mymanhwa

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator


class DashBoardFragment(context: Context) : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: ViewPagerAdapter

    private  val mList: List<String> = listOf("https://firebasestorage.googleapis.com/v0/b/lotr-deff3.appspot.com/o/b0.png?alt=media&token=c39bce8b-cf98-4fc4-929c-154211f8d877",
        "https://firebasestorage.googleapis.com/v0/b/lotr-deff3.appspot.com/o/b0.png?alt=media&token=c39bce8b-cf98-4fc4-929c-154211f8d877",
        "https://firebasestorage.googleapis.com/v0/b/lotr-deff3.appspot.com/o/b0.png?alt=media&token=c39bce8b-cf98-4fc4-929c-154211f8d877",
        "https://firebasestorage.googleapis.com/v0/b/lotr-deff3.appspot.com/o/b0.png?alt=media&token=c39bce8b-cf98-4fc4-929c-154211f8d877",
        "https://firebasestorage.googleapis.com/v0/b/lotr-deff3.appspot.com/o/b0.png?alt=media&token=c39bce8b-cf98-4fc4-929c-154211f8d877",
        "https://firebasestorage.googleapis.com/v0/b/lotr-deff3.appspot.com/o/b0.png?alt=media&token=c39bce8b-cf98-4fc4-929c-154211f8d877")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dash_board, container, false)
        viewPager = view.findViewById(R.id.myviewPager)
        viewPager.setClipToPadding(false);
        viewPager.setPadding(80, 0, 80, 0);
        viewPager.setPageMargin(30)

        val wormDotsIndicator = view.findViewById<WormDotsIndicator>(R.id.worm_dots_indicator)

        pagerAdapter = ViewPagerAdapter(this.context!!, mList)
        viewPager.adapter = pagerAdapter
        wormDotsIndicator.setViewPager(viewPager)

        return view
    }


}
