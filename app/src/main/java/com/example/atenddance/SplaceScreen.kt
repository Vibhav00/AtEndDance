package com.example.atenddance

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Layout
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener
import androidx.room.Room
import com.example.atenddance.database.Databaseroom
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class SplaceScreen : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)

    lateinit var  databasee:Databaseroom
    private  var player:MediaPlayer?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace_screen)
        // databasee= Room.databaseBuilder(applicationContext,Databaseroom::class.java,"tablelist").build()
             databasee= Databaseroom.getdatabase(this)
        GlobalScope.launch {
            DayList.daymainlist=databasee.DawDatabasevalafun().getalldata() as ArrayList<Day>
        }
        try {
            val soundURI= Uri.parse("android.resource://com.example.atenddance/"+R.raw.birdsound)
            player= MediaPlayer.create(applicationContext,soundURI)
            player?.isLooping=false
            player?.start()

        }catch (e: Exception)
        {

            e.printStackTrace()
        }

        //***********************************************
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
           window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

           val attrib = window.attributes
           attrib.layoutInDisplayCutoutMode =
               WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
       }
        //**********************************************************************************
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }, 3000


            )


        }
    }

