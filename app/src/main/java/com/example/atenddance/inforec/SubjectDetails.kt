package com.example.atenddance.inforec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.atenddance.MainActivity
import com.example.atenddance.R

class SubjectDetails : AppCompatActivity() {
    var re:RecyclerView?=null
    var pos:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_details)
        re=findViewById(R.id.recclysub)
        pos=intent.getIntExtra("viii",1)+1

        re?.adapter=SubjectDetailsAdapter(SubjectDetailsdclist.getsubjectdetailsList(pos!!))
        re?.layoutManager=LinearLayoutManager(this)
        Toast.makeText(this,"${(pos).toString()}",Toast.LENGTH_SHORT).show()






    }
}