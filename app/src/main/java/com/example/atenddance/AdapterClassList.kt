package com.example.atenddance

import android.content.Context
import android.content.Intent
import android.os.Build
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.atenddance.inforec.SubjectDetails
import kotlinx.android.synthetic.main.progresselement.view.*
import java.util.*
import kotlin.collections.ArrayList

class AdapterClassList(var cll:ArrayList<OneDayData>):RecyclerView.Adapter<AdapterClassList.ViewHoldre>() , TextToSpeech.OnInitListener{
    var tts:TextToSpeech?=null
    var ioi:Context?=null
    class  ViewHoldre(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var progressele=itemView.progresbar
        var progresstext=itemView.progresstext
        var presentclass=itemView.present
        var totalclass=itemView.total
        var subjectname=itemView.subjectnamexml
        var soundout=itemView.soundout
        var more=itemView.moreabout


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldre {
        var myView= LayoutInflater.from(parent.context).inflate(R.layout.progresselement,parent,false)
        tts= TextToSpeech(parent.context,this)
        ioi=parent.context
        return  ViewHoldre(myView)

    }

    override fun onBindViewHolder(holder: ViewHoldre, position: Int) {
      holder.progressele.progress=cll[position].percentage.toInt()
        holder.progresstext.text=cll[position].percentage.toInt().toString()
        holder.presentclass.text="present=${cll[position].present.toString()}"
        holder.totalclass.text="totalclass=${cll[position].total.toString()}"
        holder.subjectname.text=cll[position].subjectname

         holder.soundout.setOnClickListener{
                 speakout(cll[position].speakout)
         }
        holder.more.setOnClickListener{
            val intent=Intent(holder.itemView.context,SubjectDetails::class.java)
            intent.putExtra("viii",position)
            holder.itemView.context.startActivity(intent)
        }




    }

    override fun getItemCount(): Int {
       return  cll.size
    }

    override fun onInit(status: Int) {
        if(status==TextToSpeech.SUCCESS)
        {
            val result=tts!!.setLanguage(Locale ("en", "IN"))

            if(result==TextToSpeech.LANG_MISSING_DATA  || result==TextToSpeech.LANG_NOT_SUPPORTED)
            {
                Log.e("vk","not supported ")
            }
        }
        else
        {
            Log.e("vk","initialisation failed")
        }
    }
    private fun speakout(text:String)
    {
        tts?.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
       // Toast.makeText(,"play kr chuka $text", Toast.LENGTH_SHORT).show()

    }
}