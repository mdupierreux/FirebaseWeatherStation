package be.maximedupierreux.weatherstationcompanion.pressure

import android.support.v7.widget.RecyclerView
import android.view.View
import be.maximedupierreux.firebasehelper.PressureItem
import be.maximedupierreux.weatherstationcompanion.R
import kotlinx.android.synthetic.main.pressure_item.view.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Maxime on 3/08/17.
 */
class PressureViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {


    private val BAROMETER_RANGE_SUNNY = 1010f
    private val BAROMETER_RANGE_RAINY = 990f

    fun bindPressure(pressureItem: PressureItem) {
        with(pressureItem) {
            itemView.tvPressure.text = pressure.toString()
            itemView.tvDate.text = getdate(time)
            itemView.ivWeather.setImageResource(getWeatherResource(pressure))
        }
    }

    fun getdate(millis: Long): String {
        val sdf = SimpleDateFormat("yyyy/MM/dd hh:MM:SS")
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = millis
        return sdf.format(calendar.time)
    }

    private fun getWeatherResource(pressure: Float) : Int{
        when {
            pressure >= BAROMETER_RANGE_SUNNY -> return R.drawable.ic_sunny
            pressure < BAROMETER_RANGE_RAINY -> return R.drawable.ic_rainy
            else -> return R.drawable.ic_cloudy
        }
    }
}