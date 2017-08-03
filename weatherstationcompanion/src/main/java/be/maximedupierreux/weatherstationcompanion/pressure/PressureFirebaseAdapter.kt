package be.maximedupierreux.weatherstationcompanion.pressure

import be.maximedupierreux.firebasehelper.PressureItem
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.Query

/**
 * Created by Maxime on 3/08/17.
 */
class PressureFirebaseAdapter(modelClass: Class<PressureItem>, modelLayout: Int, viewHolderClass: Class<PressureViewHolder>, query: Query) : FirebaseRecyclerAdapter<PressureItem, PressureViewHolder>(modelClass, modelLayout, viewHolderClass, query) {

    override fun populateViewHolder(viewHolder: PressureViewHolder, model: PressureItem, position: Int) {
        viewHolder.bindPressure(model)
    }
}
