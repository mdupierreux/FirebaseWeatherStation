package be.maximedupierreux.weatherstationcompanion.temperature

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import be.maximedupierreux.firebasehelper.FirebaseHelper
import be.maximedupierreux.firebasehelper.TemperatureItem
import be.maximedupierreux.weatherstationcompanion.R


class TemperatureFragment : Fragment() {
    // TODO: Customize parameters
    private var mColumnCount = 1
    var mFirebaseHelper = FirebaseHelper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            mColumnCount = arguments.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_temperature_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()
            val recyclerView = view
            if (mColumnCount <= 1) {
                recyclerView.layoutManager = LinearLayoutManager(context)
            } else {
                recyclerView.layoutManager = GridLayoutManager(context, mColumnCount)
            }
            recyclerView.adapter = TemperatureFirebaseAdapter(
                    TemperatureItem::class.java,
                    R.layout.temperature_item,
                    TemperatureViewHolder::class.java,
                    mFirebaseHelper.getTemperaturePath()
            )
        }
        return view
    }


    override fun onDetach() {
        super.onDetach()
    }

    companion object {

        // TODO: Customize parameter argument names
        private val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        fun newInstance(columnCount: Int): TemperatureFragment {
            val fragment = TemperatureFragment()
            val args = Bundle()
            args.putInt(ARG_COLUMN_COUNT, columnCount)
            fragment.arguments = args
            return fragment
        }
    }
}
