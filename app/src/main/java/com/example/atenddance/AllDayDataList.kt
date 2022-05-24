package com.example.atenddance

import android.util.Log

object AllDayDataList {

    var Oopj: Int=0
    var Oopjclass: Int=0

    var Coa:Int=0
    var CoaClass: Int=0




    var Daa: Int=0
    var Daaclass: Int=0

    var Eec: Int=0
    var EecClass: Int=0


    var Ds: Int=0
    var Dsclass: Int=0


    var cg: Int=0
    var cgclass: Int=0


    var dse: Int=0
    var dseclass: Int=0


    var coal: Int=0
    var coalclass: Int=0


    var oopjl: Int=0
    var oopjlclass: Int=0


    var daal: Int=0
    var daaLclass: Int=0

    var  lib : Int=0
    var libclass: Int=0


    var alldaydatalist = ArrayList<OneDayData>()
    fun getalldaydatalist(): ArrayList<OneDayData> {
        getsubpa()
        return alldaydatalist
    }

    fun getsubpa() {
        alldaydatalist.clear()
        Oopj = 0;Oopjclass = 0;
        Coa = 0;CoaClass = 0;
        Daa = 0;Daaclass = 0;
        Eec = 0;EecClass = 0;
        Ds = 0;Dsclass = 0;
        cg=0;cgclass=0;
        dse=0;dseclass=0;
        coal=0;coalclass=0;
        oopjl=0;oopjlclass=0;
        daaLclass=0;daal=0;
        lib=0;libclass=0;



        for (i in DayList.daymainlist) {


            if (i.Oopj)//oopj
                Oopj++
            if (i.Oopjclass)
                Oopjclass++


            if (i.Coa)//coa
                Coa++
            if (i.CoaClass)
                CoaClass++

            if (i.Daa)//daa
                Daa++
            if (i.Daaclass)
                Daaclass++

            if (i.Eec)//EEc
                Eec++
            if (i.EecClass)
                EecClass++

            if (i.Ds)//ds
                Ds++
            if (i.Dsclass)
                Dsclass++


            if (i.cg)//ds
                cg++
            if (i.cgclass)
                cgclass++


            if (i.dse)//ds
                dse++
            if (i.dseclass)
                dseclass++


            if (i.CoaLab)//ds
                coal++
            if (i.CoaLabClass)
                coalclass++

            if (i.OopjLab)//ds
                oopjl++
            if (i.OopjLabClass)
                oopjlclass++


            if (i.DaaLab)//ds
                daal++
            if (i.DaaLabClass)
                daaLclass++

            if (i.Lib)//ds
                lib++
            if (i.LibClass)
                libclass++



        }

        alldaydatalist.add(
            OneDayData(
                "OOPJ", caldayremaining(Oopj, Oopjclass,"Object Oriented programming Using java "), 6, getpercentage(
                    Oopj, Oopjclass
                ), Oopjclass, Oopj
            )
        )

        alldaydatalist.add(
            OneDayData(
                "COA", caldayremaining(Coa, CoaClass,"Computer Organisation And Architecture"), 2, getpercentage(
                    Coa, CoaClass
                ), CoaClass, Coa
            )
        )

        alldaydatalist.add(
            OneDayData(
                "DAA", caldayremaining(Daa, Daaclass,"Design And Analysis Of Algorithm"), 1, getpercentage(
                    Daa, Daaclass
                ), Daaclass, Daa
            )
        )

        alldaydatalist.add(
            OneDayData(
                "EEC", caldayremaining(Eec, EecClass,"Engineering Economics And Costing"), 5, getpercentage(
                    Eec, EecClass
                ), EecClass, Eec
            )
        )



        alldaydatalist.add(
            OneDayData(
                "DS", caldayremaining(Ds, Dsclass,"Discrete Structure"), 3, getpercentage(
                    Ds, Dsclass
                ), Dsclass, Ds
            )
        )

        alldaydatalist.add(
            OneDayData(
                "CG", caldayremaining(cg, cgclass,"Computer Graphics"), 3, getpercentage(
                    cg, cgclass
                ), cgclass, cg
            )

        )


        alldaydatalist.add(
            OneDayData(
                "DSE", caldayremaining(dse, dseclass,"Data Science Engineering"), 3, getpercentage(
                    dse, dseclass
                ), dseclass, dse
            )
        )

        alldaydatalist.add(
            OneDayData(
                "COA_L", caldayremaining(coal, coalclass,"Computer Organisation And Architecture lab"), 3, getpercentage(
                    coal, coalclass
                ), coalclass, coal
            )
        )


        alldaydatalist.add(
            OneDayData(
                "OOP_L", caldayremaining(oopjl, oopjlclass,"Object Oriented programming Using java lab"), 3, getpercentage(
                    oopjl, oopjlclass
                ), oopjlclass, oopjl
            )
        )

        alldaydatalist.add(
            OneDayData(
                "DAA_L", caldayremaining(daal, daaLclass,"Design And Analysis Of Algorithm lab"), 3, getpercentage(
                    daal, daaLclass
                ), daaLclass, daal
            )
        )

        alldaydatalist.add(
            OneDayData(
                "LIB", caldayremaining(lib, libclass,"library"), 3, getpercentage(
                    lib, libclass
                ), libclass, lib
            )
        )


    }

    fun getpercentage(pre: Int, tot: Int) = ((pre.toFloat() / tot.toFloat()) * 100)
    fun caldayremaining(pre: Int, tot: Int,sub:String): String {


        var k = 3 * tot - 4 * pre;
        return if (k >= 0) {
          //  Log.i("k ka va 1=", "$tot,$pre,$k")
              if(k==1 || k==0) {
                  " attend $k class of $sub "
              }
              else
                  " attend $k classes of $sub "

        } else {
            k = (4 * pre - 3 * tot) / 3;
          //  Log.i("k ka val 2=", "$tot,$pre,$k")
          return  if(k==1 || k==0)
              " absent  $k class of $sub "
            else
                " absent  $k classes of $sub "

        }


    }
}