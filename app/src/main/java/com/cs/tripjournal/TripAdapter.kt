package com.cs.tripjournal

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.android.synthetic.main.my_trip_layout.view.*



class TripAdapter(private val allTrip: List<Trip>) : RecyclerView.Adapter<TripAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.my_trip_layout, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = allTrip.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val numOftrip = allTrip.get(position)
        holder?.view?.tripTitle?.text = allTrip[position].cityName
        holder?.view?.tripPho?.setImageResource(allTrip[position]?.photo)
        holder?.tripnum = numOftrip

    }
    fun add(UserTrip: List<UserTrip>) {
        this.notifyDataSetChanged();
    }

    class ViewHolder(val view: View, var tripnum: Trip?= null) : RecyclerView.ViewHolder(view) {
        init {

            view.setOnClickListener {
                val database = Room.databaseBuilder(view.context, UserTripDatabase::class.java, "userTrip_database").allowMainThreadQueries().build()
                database.userTripDao().insertUserTrip(UserTrip(
                    cityName = tripnum?.cityName,
                    description = tripnum?.description,
                    popularity = tripnum?.popularity,
                    photo = tripnum!!.photo,
                    latitude = tripnum!!.latitude,
                    longitude = tripnum!!.longitude
                ))
                (view.context as AddTrip) .finish()
            }

        }

    }
}




//    class ViewHolder(val view: View, var tripnum: Trip? = null) :
//        RecyclerView.ViewHolder(view) {
//        companion object {
//            //            val TID = "ID"
//            val TRIP_CITY = "CITY"
//            val CITY_PHOTO = "PHOTO"
//            val CITY_DESCRIPTION = "DESCRIPTION"
//        }
//
//        init {
//            view.setOnClickListener {
//                val intent = Intent(view.context, TripDetailView::class.java)
////                intent.putExtra(TID, tripnum?.tid)
//                intent.putExtra(TRIP_CITY, tripnum?.cityName)
//                intent.putExtra(CITY_PHOTO, tripnum?.photo)
//                intent.putExtra(CITY_DESCRIPTION, tripnum?.description)
//                view.context.startActivity(intent)
//            }
//        }
//}
//}