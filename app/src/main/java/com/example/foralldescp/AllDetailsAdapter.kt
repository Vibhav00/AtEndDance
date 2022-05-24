package com.example.foralldescp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.atenddance.Day
import com.example.atenddance.R
import kotlinx.android.synthetic.main.all_details_adapter.view.*
import kotlinx.android.synthetic.main.layout_subjectdetails_element.view.*

class AllDetailsAdapter(var iii:ArrayList<Day> ):RecyclerView.Adapter<AllDetailsAdapter.viewholser>() {
    class  viewholser(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val oopjall=itemView.oopjall
        val coaall=itemView.coaall
        val daaall=itemView.daaall
        val eecall=itemView.eecall
        val dsall=itemView.dsall
        val cgall=itemView.cgall
        val dseall=itemView.dseall
        val coalall=itemView.coalaball
        val oopjlall=itemView.oopjlaball
        val daalaball=itemView.daalaball
        val liball=itemView.liball
        val dateall=itemView.dateall
        val dayall=itemView.dayall


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholser {
    var view=LayoutInflater.from(parent.context).inflate(R.layout.all_details_adapter,parent,false)
        Log.i("vibahav","haaa ho gya inflate ")
        return viewholser(view)

    }

    override fun onBindViewHolder(holder: viewholser, position: Int) {
        if(iii[position].Oopjclass)
            holder.oopjall.text=tf(iii[position].Oopj)
        if(iii[position].CoaClass)
            holder.coaall.text=tf(iii[position].Coa)
        if(iii[position].Daaclass)
           holder.daaall.text=tf(iii[position].Daa)
        if(iii[position].EecClass)
           holder.eecall.text=tf(iii[position].Eec)
        if(iii[position].Dsclass)
           holder.dsall.text=tf(iii[position].Ds)
        if(iii[position].cgclass)
           holder.cgall.text=tf(iii[position].cg)
        if(iii[position].dseclass)
          holder.dseall.text=tf(iii[position].dse)
        if(iii[position].CoaLabClass)
            holder.coalall.text=tf(iii[position].CoaLab)
        if(iii[position].DaaLabClass)
           holder.daalaball.text=tf(iii[position].DaaLab)
        if(iii[position].OopjLabClass)
            holder.oopjlall.text=tf(iii[position].OopjLab)
        if(iii[position].LibClass)
           holder.liball.text=tf(iii[position].Lib)
      holder.dateall.text=iii[position].date
       holder.dayall.text=iii[position].day
  //      Log.i("vibahav","haaa ho gya bind ")
    }

    override fun getItemCount(): Int {
      return  iii.size
    }

    fun tf(b: Boolean): String {
        if (b == true)
            return "P"
        else
            return "A"
    }
}