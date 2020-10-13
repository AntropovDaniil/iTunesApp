package com.example.itunesapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.itunesapp.R
import com.example.itunesapp.model.TrackModel
import com.example.itunesapp.presenter.AlbumDetailPresenter
import kotlinx.android.synthetic.main.track_item.view.*

class TrackListAdapter(val context: Context?,
                       val albumDetailPresenter: AlbumDetailPresenter):
    RecyclerView.Adapter<TrackListAdapter.TrackListViewHolder>() {

    private val trackList = ArrayList<TrackModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackListViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.track_item, parent, false)
        return TrackListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackListViewHolder, position: Int) {
        val track: TrackModel = trackList[position]
        holder.setTrackNumber(position+1)
        holder.setTrackName(track.trackName)
        val trackDuration = getTimeInMin(track.trackTimeMillis)
        holder.setDuration(trackDuration)
    }

    override fun getItemCount(): Int {
        return trackList.size
    }

    fun setTracks(tracks: List<TrackModel>){
        trackList.clear()
        trackList.addAll(tracks)
        notifyDataSetChanged()
    }

    private fun getTimeInMin(trackTime: String): String{
        val timeInMillis = trackTime.toLongOrNull()
        if (timeInMillis == null)
            return "0:00"
        else{
            val min = timeInMillis/1000/60
            val sec = timeInMillis/1000%60
            return if (sec>=10) "${timeInMillis/1000/60}:${timeInMillis/1000%60}"
            else "${timeInMillis/1000/60}:0${timeInMillis/1000%60}"
        }
    }

    inner class TrackListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun setTrackName(trackName: String) {
            itemView.track_name.text = trackName
            itemView.track_name.isSelected = true
        }

        fun setTrackNumber(trackNumber: Int) {
            itemView.track_number.text = trackNumber.toString()
        }

        fun setDuration(trackDuration: String) {
            itemView.track_duration.text = trackDuration
        }
    }
}