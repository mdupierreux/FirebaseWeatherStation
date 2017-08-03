package be.maximedupierreux.weatherstationcompanion.temperature

import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.Query

import be.maximedupierreux.firebasehelper.TemperatureItem

/**
 * Created by Maxime on 31/07/17.
 */

class TemperatureFirebaseAdapter(modelClass: Class<TemperatureItem>, modelLayout: Int, viewHolderClass: Class<TemperatureViewHolder>, query: Query) : FirebaseRecyclerAdapter<TemperatureItem, TemperatureViewHolder>(modelClass, modelLayout, viewHolderClass, query) {

    override fun populateViewHolder(viewHolder: TemperatureViewHolder, model: TemperatureItem, position: Int) {
        viewHolder.bindTemperature(model)
    }
}
