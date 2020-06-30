package com.smart.app.mymanhwa

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class ViewPagerAdapter() : PagerAdapter() {

    var mContext: Context? = null
    var mList: List<String>? = null

    constructor(mContext: Context, mList: List<String>) : this() {
        this.mContext = mContext
        this.mList = mList
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var linearLayout = LinearLayout(mContext)
        val imageView = ImageView(mContext)

         linearLayout.setBackgroundDrawable(mContext?.let { ContextCompat.getDrawable(it,R.drawable.border) })

        val options = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)

            Glide.with(this!!.mContext!!)
                .load(mList?.get(position))
                .apply(options)
                .into(imageView)

        linearLayout.addView(imageView)
        linearLayout.setOnClickListener {
            Log.e("LOG", "Click: " + position)
        }
        (container as ViewPager).addView(linearLayout, 0)

        return linearLayout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as LinearLayout)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout;
    }

    override fun getCount(): Int {
        Log.e("LOG", "List: " + mList?.size!!)
        return mList?.size!!
    }

}