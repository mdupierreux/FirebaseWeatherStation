package be.maximedupierreux.firebasehelper

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query

/**
 * Created by Maxime on 31/07/17.
 */

class FirebaseHelper {
    internal var mDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
    val TEMPERATURE = "temperature"
    val PRESSURE = "pressure"
    fun writeTemperatureData(temp: Float, time: Long) {
        val ref = mDatabase.getReference(TEMPERATURE)
        val temperatureObject = TemperatureItem(temp, time)
        ref.push().setValue(temperatureObject)
    }

    fun writePressureData(pressure: Float, time: Long) {
        val ref = mDatabase.getReference(PRESSURE)
        val pressureObject = PressureItem(pressure, time)
        ref.push().setValue(pressureObject)
    }

    fun getTemperaturePath() : Query{
        return mDatabase.getReference(TEMPERATURE)
    }

    fun getPressurePath(): Query {
        return mDatabase.getReference(PRESSURE)
    }
}
