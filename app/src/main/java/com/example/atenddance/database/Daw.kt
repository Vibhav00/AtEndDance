package com.example.atenddance.database

import androidx.room.*
import com.example.atenddance.Day

@Dao
interface Daw {

    @Insert
     fun insertintodatabase(d:dataclassday)

     @Update
     fun updatetodatabase(ud:dataclassday)

     @Delete
     fun deletefromdatabase(dd:dataclassday)

    @Query("SELECT * FROM DATAOFDAY")
       fun getalldata():MutableList<Day>

}