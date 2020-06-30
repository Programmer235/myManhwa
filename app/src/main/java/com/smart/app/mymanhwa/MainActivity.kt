package com.smart.app.mymanhwa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = intent.getStringExtra("username")
        val userimage = intent.getStringExtra("userimage")

        Log.e("LOG", "USER_IMAGE: " + userimage)

        if(username != null){
            name_user.text = username
        }

        if(userimage != null){
            val options = RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)

            Glide.with(this)
                .load(userimage)//
                .apply(options)
                .into(image_user)
        }

        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_container_pager, DashBoardFragment(this))
            .commit()

        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_container_catalogue, CatalogueFragment(this))
            .commit();
    }
}
