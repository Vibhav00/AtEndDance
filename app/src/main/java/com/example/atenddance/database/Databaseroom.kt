package com.example.atenddance.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [dataclassday::class],version = 1)
abstract class Databaseroom :RoomDatabase() {

     abstract fun    DawDatabasevalafun():Daw

     companion object{

      private var Instance:Databaseroom?=null
       fun getdatabase(context: Context):Databaseroom
       {

                if(Instance==null)
                {
                     synchronized(this)
                     {
                          Instance= Room.databaseBuilder(context.applicationContext,Databaseroom::class.java,"tablelist").build()
                     }


                }
            return Instance!!
       }


     }






}