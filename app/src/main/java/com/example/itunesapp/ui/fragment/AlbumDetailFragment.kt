package com.example.itunesapp.ui.fragment

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.SearchEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.itunesapp.R
import com.example.itunesapp.activity.SearchAlbumActivity
import com.example.itunesapp.model.AlbumModel
import com.example.itunesapp.model.TrackModel
import com.example.itunesapp.presenter.AlbumDetailPresenter
import com.example.itunesapp.ui.activity.AlbumDetailActivity
import com.example.itunesapp.ui.adapter.TrackListAdapter
import com.example.itunesapp.view.AlbumDetailView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_album_detail.*
import kotlinx.android.synthetic.main.fragment_album_detail.view.*

class AlbumDetailFragment : Fragment(), AlbumDetailView {

    lateinit var trackListAdapter: TrackListAdapter
    lateinit var albumDetailPresenter: AlbumDetailPresenter
    lateinit var albumDetailActivity: AlbumDetailActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        albumDetailActivity = context as AlbumDetailActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_album_detail, container, false)

        albumDetailPresenter = AlbumDetailPresenter()
        albumDetailPresenter.setView(this)

        val albumModel = arguments?.getParcelable<AlbumModel>(SearchAlbumActivity.INTENT_PARAM_ALBUM_MODEL)
        if (albumModel != null) {
            renderAlbumDetails(view, albumModel)
            albumDetailPresenter.searchTracks(albumModel.collectionId)
        } else showError("AlbumFindError")

        initRecyclerView(view)

        return view
    }

    override fun renderAlbumDetails(view: View, albumModel: AlbumModel){
        albumDetailPresenter.setAlbumDetails(view, albumModel)
    }

    override fun renderTracks(trackList: List<TrackModel>) {
        trackListAdapter.setTracks(trackList)
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
    }

    private fun initRecyclerView(view: View){
        val recyclerView = view.track_rv
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val onTrackClickListener = getClickListener()
        trackListAdapter = TrackListAdapter(context, onTrackClickListener)
        recyclerView.adapter = trackListAdapter
    }


    private fun getClickListener(): TrackListAdapter.OnTrackClickListener{
        return object : TrackListAdapter.OnTrackClickListener{
            override fun onTrackCLick(track: TrackModel) {
                albumDetailActivity.navigateToMediaPlayer(track)
            }
        }
    }




}