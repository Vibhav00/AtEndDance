package com.example.atenddance.inforec

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.atenddance.AdapterClassList
import com.example.atenddance.R
import kotlinx.android.synthetic.main.layout_subjectdetails_element.view.*

class SubjectDetailsAdapter(var sl:ArrayList<SubjectDetaildataclass>):RecyclerView.Adapter<SubjectDetailsAdapter.SubjectDetaislvh>() {
    class SubjectDetaislvh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var subjectname = itemView.subjn
        var pa = itemView.pa

        var day = itemView.day
        var date = itemView.date

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectDetaislvh {
        var myView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_subjectdetails_element, parent, false)
        return SubjectDetaislvh(myView)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: SubjectDetaislvh, position: Int) {
        holder.subjectname.text = sl[position].sub
        if(sl[position].pa)
            holder.pa.setTextColor(Color.parseColor("#3FE345"))
        else
            holder.pa.setTextColor(Color.parseColor("#CD3C3C"))
        holder.pa.text = tf(sl[position].pa)

        holder.date.text = sl[position].Date
        holder.day.text = sl[position].Day
    }

    override fun getItemCount(): Int {
        return sl.size
    }

    fun tf(b: Boolean): String {
        if (b == true)
            return "P"
        else
            return "A"
    }


}