package com.example.atenddance

object DayList {
     var daymainlist=ArrayList<Day>()
       fun getdaymainlist():ArrayList<Day>
    {
           return  daymainlist

       }
    fun insertdaymainlist(day:Day)
    {
           daymainlist.add(day)
    }

}