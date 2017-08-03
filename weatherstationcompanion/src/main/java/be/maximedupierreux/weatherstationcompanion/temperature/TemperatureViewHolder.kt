package be.maximedupierreux.weatherstationcompanion.temperature

import android.support.v7.widget.RecyclerView
import android.view.View
import be.maximedupierreux.firebasehelper.TemperatureItem
import kotlinx.android.synthetic.main.temperature_item.view.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Maxime on 31/07/17.
 */

class TemperatureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bindTemperature(temperature : TemperatureItem){
        with(temperature){
            itemView.tvTemp.text = temp.toString()
            itemView.tvDate.text = getdate(time)
        }
    }

    fun getdate(millis : Long) : String{
        val sdf = SimpleDateFormat("yyyy/MM/dd hh:MM:SS")
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = millis
        return sdf.format(calendar.time)
    }
}
