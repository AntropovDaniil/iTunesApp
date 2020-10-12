package com.example.itunesapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.itunesapp.R
import com.example.itunesapp.model.AlbumModel
import com.example.itunesapp.presenter.AlbumListPresenter
import com.example.itunesapp.ui.adapter.AlbumAdapter
import com.example.itunesapp.view.AlbumListView
import kotlinx.android.synthetic.main.fragment_search_album.*
import kotlinx.android.synthetic.main.fragment_search_album.view.*
import org.jetbrains.annotations.NotNull

class SearchAlbumFragment : Fragment(), AlbumListView {

    lateinit var albumListAdapter: AlbumAdapter
    lateinit var albumListPresenter: AlbumListPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_search_album, container, false)
        albumListPresenter = AlbumListPresenter()
        albumListPresenter.setView(this)
        initRecyclerView(view)

        view.search_button.setOnClickListener { findAlbums() }

        return view
    }


    private fun initRecyclerView(@NotNull view: View){
        val recyclerView = view.album_rv
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        albumListAdapter = AlbumAdapter(context, albumListPresenter)
        recyclerView.adapter = albumListAdapter
    }

    private fun findAlbums(){
        if (searchTextView.text.toString().equals(null)){
            showError("Fill the text view")
        }
        else{
            albumListPresenter.searchAlbums(searchTextView.text.toString())
        }
    }

    override fun renderAlbums(albums: List<AlbumModel>) {
        albumListAdapter.setAlbums(albums)
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage,Toast.LENGTH_LONG).show()
    }

    override fun openAlbumDetails() {
        TODO("Not yet implemented")
    }


}