package com.example.atenddance

import java.text.SimpleDateFormat

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.atenddance.databinding.ActivityMainBinding
import com.example.foralldescp.AllDetails
import kotlinx.android.synthetic.main.layout_subjectdetails_element.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var binding:ActivityMainBinding?=null
    private var selecteddate:String?=null
    private var dayString:String?=null
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }

        //***********************************************
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

            val attrib = window.attributes
            attrib.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        }
        binding?.recycleview?.adapter=AdapterClassList(AllDayDataList.getalldaydatalist())
        binding?.recycleview?.layoutManager=LinearLayoutManager(this)
        binding?.btnSet?.setOnClickListener{
            val intent=Intent(this,AddDayDetails::class.java)
            startActivity(intent)
           // finish()
        }
        binding?.allXml?.setOnClickListener{

            val intent=Intent(this,AllDetails::class.java)
            startActivity(intent)
        }

        binding?.calendar?.setOnClickListener{
             datepickerdialog()



        }





    }
    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
    private fun datepickerdialog()
    {
        val cal=Calendar.getInstance()
        val day=cal.get(Calendar.DAY_OF_MONTH)
        val month=cal.get(Calendar.MONTH)
        val year=cal.get(Calendar.YEAR)
        val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener{
                view, selectedyear, selectedmonth, selecteddayOfMonth ->
             selecteddate="$selecteddayOfMonth/${selectedmonth+1}/$selectedyear"
            val simpleDateFormat = SimpleDateFormat("EEEE")
            val date = Date(selectedyear, selectedmonth, selecteddayOfMonth - 1)
             dayString = simpleDateFormat.format(date) //returns true day name
            Toast.makeText(this,dayString,Toast.LENGTH_SHORT).show()
            val intent=Intent(this,AddDayDetails::class.java)
            intent.putExtra("dateinstring",selecteddate)
            intent.putExtra("dayinstring",dayString)
            startActivity(intent)

        },year,month,day).show()
    }
//    fun getdayof(i: Int):String {
//        when (i) {
//            1 -> return  "Sunday"
//            2 -> return "Monday"
//            3 -> return  "Tuesday"
//            4 -> return "Wednesday"
//            5 -> return "Thursday"
//            6 -> return  "Friday"
//            7 -> return  "Saturday"
//        }
//
//        return "not any day"
//    }
}