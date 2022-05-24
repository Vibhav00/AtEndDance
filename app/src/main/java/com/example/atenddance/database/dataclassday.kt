package com.example.atenddance.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="dataofday")
data class dataclassday(
    @PrimaryKey(autoGenerate = true)
    var Id:Int,
    var Oopj:Boolean,
    var Oopjclass:Boolean,

    var Coa:Boolean,
    var CoaClass:Boolean,

    var Daa:Boolean,
    var Daaclass:Boolean,

    var Eec:Boolean,
    var EecClass:Boolean,

    var Ds:Boolean,
    var Dsclass:Boolean,

    var cg:Boolean,
    var cgclass:Boolean,

    var dse:Boolean,
    var dseclass:Boolean,

    var CoaLab:Boolean,
    var CoaLabClass:Boolean,

    var OopjLab:Boolean,
    var OopjLabClass:Boolean,

    var DaaLab:Boolean,
    var DaaLabClass:Boolean,

    var Lib:Boolean,
    var LibClass:Boolean,






    var day:String,
    var date:String
)
