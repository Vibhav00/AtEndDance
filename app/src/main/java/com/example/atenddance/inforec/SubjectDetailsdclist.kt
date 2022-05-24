package com.example.atenddance.inforec

import com.example.atenddance.Day
import com.example.atenddance.DayList

object SubjectDetailsdclist {

      var palist=ArrayList<SubjectDetaildataclass>()
      fun getsubjectdetailsList(id:Int):ArrayList<SubjectDetaildataclass>
      {

            palist.clear()

            if(id==1)
            {
                  for (i in DayList.daymainlist)
                  {
                        if(i.Oopjclass)
                        palist.add(SubjectDetaildataclass(1,"OOPJ",i.Oopj,i.Oopjclass,i.date,i.day))
                  }
            }
            else if(id==2)
            {
                  for (i in DayList.daymainlist)
                  {
                         if(i.CoaClass)
                        palist.add(SubjectDetaildataclass(2,"COA",i.Coa,i.CoaClass,i.date,i.day))
                  }
            }
            else if(id==3)
            {
                  for (i in DayList.daymainlist)
                  {
                         if(i.Daaclass)
                        palist.add(SubjectDetaildataclass(3,"DAA",i.Daa,i.Daaclass,i.date,i.day))
                  }
            }
            else if(id==4)
            {
                  for (i in DayList.daymainlist)
                  {
                        if(i.EecClass)
                        palist.add(SubjectDetaildataclass(4,"EEC",i.Eec,i.EecClass,i.date,i.day))
                  }
            }
            else if(id==5)
            {
                  for (i in DayList.daymainlist)
                  {
                        if(i.Dsclass)
                        palist.add(SubjectDetaildataclass(5,"DS",i.Ds,i.Dsclass,i.date,i.day))
                  }
            }
            else if(id==6)
            {
            for (i in DayList.daymainlist)
            {
                  if(i.cgclass)
                  palist.add(SubjectDetaildataclass(6,"CG",i.cg,i.cgclass,i.date,i.day))
            }
            }


            else if(id==7)
            {
                  for (i in DayList.daymainlist)
                  {
                        if(i.dseclass)
                        palist.add(SubjectDetaildataclass(6,"DSE",i.dse,i.dseclass,i.date,i.day))
                  }
            }

            else if(id==8)
            {
                  for (i in DayList.daymainlist)
                  {
                        if(i.CoaLabClass)
                        palist.add(SubjectDetaildataclass(6,"COA_L",i.CoaLab,i.CoaLabClass,i.date,i.day))
                  }
            }

            else if(id==9)
            {
                  for (i in DayList.daymainlist)
                  {
                        if(i.OopjLabClass)
                        palist.add(SubjectDetaildataclass(6,"OOP_J",i.OopjLab,i.OopjLabClass,i.date,i.day))
                  }
            }

            else if(id==10)
            {
                  for (i in DayList.daymainlist)
                  {
                        if(i.DaaLabClass)
                        palist.add(SubjectDetaildataclass(6,"DAA_L",i.DaaLab,i.DaaLabClass,i.date,i.day))
                  }
            }
            else if(id==11)
            {
                  for (i in DayList.daymainlist)
                  {
                        if(i.LibClass)
                        palist.add(SubjectDetaildataclass(6,"LIB",i.Lib,i.LibClass,i.date,i.day))
                  }
            }

         return palist

      }

      }


