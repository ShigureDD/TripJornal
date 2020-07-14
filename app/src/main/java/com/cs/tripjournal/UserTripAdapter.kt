package com.cs.tripjournal

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.my_trip_layout.view.*


class UserTripAdapter(private val allUserTrip: List<UserTrip>) : RecyclerView.Adapter<UserTripAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_trip_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = allUserTrip.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val numOftrip= allUserTrip.get(position)
        holder?.view?.tripTitle?.text = allUserTrip[position].cityName

     //   holder?.view?.tripPho?.setImageDrawable(holder?.view?.context?.getDrawable(allUserTrip[position].photo))
        holder?.view?.tripPho?.setImageResource(allUserTrip[position]?.photo)
        holder?.tripnum =  numOftrip
    }

    class ViewHolder(val view: View, var tripnum: UserTrip?= null) : RecyclerView.ViewHolder(view) {
        companion object{
            //            val TID = "ID"
            val TRIP_CITY = "CITY"
            val CITY_PHOTO = "PHOTO"
            val CITY_DESCRIPTION = "DESCRIPTION"
            val CITY_LATITUDE = "latitude"
            val CITY_LONGITUDE = "longitude"
        }
        init {
            view.setOnClickListener{
                val intent = Intent(view.context, TripDetailView::class.java)
//                intent.putExtra(TID, tripnum?.tid)
                intent.putExtra(TRIP_CITY,tripnum?.cityName)
                intent.putExtra(CITY_PHOTO,tripnum?.photo)
                intent.putExtra(CITY_DESCRIPTION, tripnum?.description)
                intent.putExtra(CITY_LATITUDE, tripnum?.latitude)
                intent.putExtra(CITY_LONGITUDE,tripnum?.longitude)
                view.context.startActivity(intent)
            }
        }
    }
}