package com.example.atenddance

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import com.example.atenddance.database.Databaseroom
import com.example.atenddance.database.dataclassday
import com.example.atenddance.databinding.ActivityAddDayDetailsBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class AddDayDetails : AppCompatActivity() {
    var binding:ActivityAddDayDetailsBinding?=null
    var classdata:Day?=null
    private var selecteddate:String?=null
    private var selectedday:String?=null
    lateinit var  databasee: Databaseroom
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddDayDetailsBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        databasee= Databaseroom.getdatabase(this)
       // databasee= Room.databaseBuilder(applicationContext,Databaseroom::class.java,"tablelist").build()
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }

        //***********************************************
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

            val attrib = window.attributes
            attrib.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        }
        selecteddate=intent.getStringExtra("dateinstring")
        selectedday=intent.getStringExtra("dayinstring")
        set_class_enable_false()
        set_pa_enable_false()
        //********************************************
       binding?.oopjClass?.setOnClickListener{
           binding?.oopjPa?.isEnabled = binding?.oopjClass?.isChecked==true
       }

        binding?.coaClass?.setOnClickListener{
            binding?.coaPa?.isEnabled = binding?.coaClass?.isChecked==true
        }

        binding?.daaClass?.setOnClickListener{
            binding?.daaPa?.isEnabled = binding?.daaClass?.isChecked==true
        }


        binding?.eecClass?.setOnClickListener{
            binding?.eecPa?.isEnabled = binding?.eecClass?.isChecked==true
        }

        binding?.dsClass?.setOnClickListener{
            binding?.dsPa?.isEnabled = binding?.dsClass?.isChecked==true
        }


        binding?.cgClass?.setOnClickListener{
            binding?.cgPa?.isEnabled = binding?.cgClass?.isChecked==true
        }

        binding?.dseClass?.setOnClickListener{
            binding?.dsePa?.isEnabled = binding?.dseClass?.isChecked==true
        }
        binding?.coaLClass?.setOnClickListener{
            binding?.coaLPa?.isEnabled = binding?.coaLClass?.isChecked==true
        }

        binding?.oopjLClass?.setOnClickListener{
            binding?.oopjlPa?.isEnabled = binding?.oopjLClass?.isChecked==true
        }

        binding?.daalClass?.setOnClickListener{
            binding?.daalPa?.isEnabled = binding?.daalClass?.isChecked==true
        }

        binding?.libClass?.setOnClickListener{
            binding?.libPa?.isEnabled = binding?.libClass?.isChecked==true
        }


















        binding?.switchclass?.setOnClickListener{
            if(binding?.switchclass?.isChecked==true)
            {
                classdata= Day(false,false,false,false,false,false,false,false,
                    false,false,false,false,false,false,false,false,false
                    ,false,false,false,false,false,"","")
                set_class_enable_true()
               // set_pa_enable_true()
            }
            else
            {
                set_class_enable_false()
                set_pa_enable_false()

            }

        }



        binding?.submitalldetails?.setOnClickListener{
            make_Day_element()
            setdatatolist()
            Log.i("datalist",DayList.getdaymainlist().toString())
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    fun make_Day_element()
    {
        val cal:Calendar= Calendar.getInstance()
        val day=cal.get(Calendar.DAY_OF_MONTH)
        val month=cal.get(Calendar.MONTH)
        val year=cal.get(Calendar.YEAR)
        val dayOfWeek=cal.get(Calendar.DAY_OF_WEEK)
        val selectdate="$day/${month+1}/$year"

        if(binding?.oopjClass?.isChecked==true)
        {
            classdata?.Oopjclass = true
            if (binding?.oopjPa?.isChecked == true)
                classdata?.Oopj = true
        }



        if(binding?.coaClass?.isChecked==true) {
            classdata?.CoaClass = true
            if (binding?.coaPa?.isChecked == true)
                classdata?.Coa = true
        }

        if(binding?.daaClass?.isChecked==true) {
            classdata?.Daaclass = true
            if (binding?.daaPa?.isChecked == true)
                classdata?.Daa = true
        }

        if(binding?.eecClass?.isChecked==true) {
            classdata?.EecClass = true
            if (binding?.eecPa?.isChecked == true)
                classdata?.Eec = true
        }

        if(binding?.dsClass?.isChecked==true) {
            classdata?.Dsclass = true
            if (binding?.dsPa?.isChecked == true)
                classdata?.Ds = true
        }

        if(binding?.cgClass?.isChecked==true) {
            classdata?.cgclass = true
            if (binding?.cgPa?.isChecked == true)
                classdata?.cg = true
        }
        if(binding?.dseClass?.isChecked==true) {
            classdata?.dseclass = true
            if (binding?.dsePa?.isChecked == true)
                classdata?.dse = true
        }


            if (binding?.coaLClass?.isChecked == true){
                classdata?.CoaLabClass = true
        if(binding?.coaLPa?.isChecked==true)
            classdata?.CoaLab = true
        }

        if(binding?.oopjLClass?.isChecked==true) {
            classdata?.OopjLabClass = true
            if (binding?.oopjlPa?.isChecked == true)
                classdata?.OopjLab = true
        }

        if(binding?.daalClass?.isChecked==true) {
            classdata?.DaaLabClass = true
            if (binding?.daalPa?.isChecked == true)
                classdata?.DaaLab = true
        }




        if(binding?.libClass?.isChecked==true) {
            classdata?.LibClass = true
            if (binding?.libPa?.isChecked == true)
                classdata?.Lib = true
        }


         if(selecteddate==null) {
             classdata?.day = getdayof(dayOfWeek)
             classdata?.date = selectdate
         }
        else
         {
             classdata?.day = selectedday!!
             classdata?.date = selecteddate!!

         }
     //   Log.i("vibhav ",classdata!!.toString())

    }

    fun setdatatolist() {

        DayList.insertdaymainlist(classdata!!)
        GlobalScope.launch {
            databasee.DawDatabasevalafun().insertintodatabase(
                dataclassday(0
                ,classdata!!.Oopj,
                    classdata!!.Oopjclass
                    ,classdata!!.Coa, classdata!!.CoaClass,
                    classdata!!.Daa, classdata!!.Daaclass,
                    classdata!!.Eec, classdata!!.EecClass
                    ,classdata!!.Ds, classdata!!.Dsclass,
                    classdata!!.cg,classdata!!.cgclass,
                    classdata!!.dse,classdata!!.dseclass
                ,classdata!!.CoaLab,classdata!!.CoaLabClass
                    ,classdata!!.OopjLab,classdata!!.OopjLabClass,
                    classdata!!.DaaLab,classdata!!.DaaLabClass,
                classdata!!.Lib,classdata!!.LibClass,
                    classdata!!.day,classdata!!.date)



            )



        }

    }





    fun set_pa_enable_false()
    {
        binding?.oopjPa?.isEnabled=false
        binding?.coaPa?.isEnabled=false
        binding?.daaPa?.isEnabled=false
        binding?.dsPa?.isEnabled=false
        binding?.eecPa?.isEnabled=false
        binding?.cgPa?.isEnabled=false
        binding?.dsePa?.isEnabled=false
        binding?.coaLPa?.isEnabled=false
        binding?.oopjlPa?.isEnabled=false
        binding?.daalPa?.isEnabled=false
        binding?.libPa?.isEnabled=false
        binding?.submitalldetails?.isEnabled=false



    }
    fun set_class_enable_false()
    {
        binding?.oopjClass?.isEnabled=false
        binding?.coaClass?.isEnabled=false
        binding?.daaClass?.isEnabled=false
        binding?.dsClass?.isEnabled=false
        binding?.eecClass?.isEnabled=false
        binding?.cgClass?.isEnabled=false
        binding?.dseClass?.isEnabled=false
        binding?.coaLClass?.isEnabled=false
        binding?.oopjLClass?.isEnabled=false
        binding?.daalClass?.isEnabled=false
        binding?.libClass?.isEnabled=false
        binding?.submitalldetails?.isEnabled=false


    }
    fun set_pa_enable_true()
    {
        binding?.oopjPa?.isEnabled=true
        binding?.coaPa?.isEnabled=true
        binding?.daaPa?.isEnabled=true
        binding?.dsPa?.isEnabled=true
        binding?.eecPa?.isEnabled=true
        binding?.cgPa?.isEnabled=true
        binding?.dsePa?.isEnabled=true
        binding?.coaLPa?.isEnabled=true
        binding?.oopjlPa?.isEnabled=true
        binding?.daaPa?.isEnabled=true
        binding?.libPa?.isEnabled=true
        binding?.submitalldetails?.isEnabled=true


    }
    fun set_class_enable_true()

    {
        binding?.oopjClass?.isEnabled=true
        binding?.coaClass?.isEnabled=true
        binding?.daaClass?.isEnabled=true
        binding?.dsClass?.isEnabled=true
        binding?.eecClass?.isEnabled=true
        binding?.cgClass?.isEnabled=true
        binding?.dseClass?.isEnabled=true
        binding?.coaLClass?.isEnabled=true
        binding?.oopjLClass?.isEnabled=true
        binding?.daalClass?.isEnabled=true
        binding?.libClass?.isEnabled=true
        binding?.submitalldetails?.isEnabled=true


    }

    fun getdayof(i: Int):String {
        when (i) {
            1 -> return  "Sunday"
            2 -> return "Monday"
            3 -> return  "Tuesday"
            4 -> return "Wednesday"
            5 -> return "Thursday"
            6 -> return  "Friday"
            7 -> return  "Saturday"
        }

        return "not any day"
    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }


}