package com.smart.app.mymanhwa

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import java.util.*

class LoginActivity : AppCompatActivity() {

    private lateinit var mFirebaseAuth : FirebaseAuth
    private  lateinit var mAuthsateListener : FirebaseAuth.AuthStateListener
    private val RC_SIGN_IN = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)

        mFirebaseAuth = FirebaseAuth.getInstance()

        mAuthsateListener = FirebaseAuth.AuthStateListener{
            val user = mFirebaseAuth.currentUser
            user?.let {
                val MainIntent = Intent(this, MainActivity::class.java)
                val userName = user.displayName
                val userImage = user.photoUrl
                MainIntent.putExtra("username", userName)
                MainIntent.putExtra("userimage", userImage)
                startActivity(MainIntent)
            }

            val MainIntent = Intent(this, MainActivity::class.java)
            startActivity(MainIntent)

            /*startActivityForResult(AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setIsSmartLockEnabled(false)
                .setTosAndPrivacyPolicyUrls("","")
                .setAvailableProviders(Arrays.asList(AuthUI.IdpConfig.EmailBuilder().build()))
                .build(), RC_SIGN_IN)*/

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == RC_SIGN_IN){
            if(resultCode == Activity.RESULT_OK){

            }
        }
    }

    override fun onResume() {
        super.onResume()
        mFirebaseAuth.addAuthStateListener(mAuthsateListener)
    }

    override fun onPause() {
        super.onPause()
        mAuthsateListener?.let{
            mFirebaseAuth.removeAuthStateListener(mAuthsateListener)
        }
    }
}
