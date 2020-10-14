package com.example.itunesapp.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.itunesapp.R
import com.example.itunesapp.activity.SearchAlbumActivity
import com.example.itunesapp.model.AlbumModel
import com.example.itunesapp.presenter.AlbumListPresenter
import com.example.itunesapp.ui.adapter.AlbumListAdapter
import com.example.itunesapp.view.AlbumListView
import kotlinx.android.synthetic.main.fragment_search_album.*
import kotlinx.android.synthetic.main.fragment_search_album.view.*
import org.jetbrains.annotations.NotNull

class SearchAlbumFragment : Fragment(), AlbumListView {

    lateinit var albumListListAdapter: AlbumListAdapter
    lateinit var albumListPresenter: AlbumListPresenter
    lateinit var searchAlbumActivity: SearchAlbumActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        searchAlbumActivity = context as SearchAlbumActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_search_album, container, false)
        albumListPresenter = AlbumListPresenter()
        albumListPresenter.setView(this)
        initRecyclerView(view)
        view.search_button.setOnClickListener { findAlbums() }
        //TODo change
        //initView(view)

        return view
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null){
            val searchText = (savedInstanceState.getString(SearchAlbumActivity.SAVED_PARAM_ALBUM_MODEL))
            if (searchText != null) {
                search_text_view.setText(searchText)
                findAlbums()
            }
        }
    }


    private fun initRecyclerView(@NotNull view: View){
        val recyclerView = view.album_rv
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        val onAlbumClickListener = getClickListener()
        albumListListAdapter = AlbumListAdapter(context, onAlbumClickListener)
        recyclerView.adapter = albumListListAdapter
    }

    private fun findAlbums(){
        if (search_text_view.text == null){
            showError("Fill the text view")
        }
        else{
            albumListPresenter.searchAlbums(search_text_view.text.toString())
        }
    }

    override fun renderAlbums(albums: List<AlbumModel>) {
        albumListListAdapter.setAlbums(albums)
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage,Toast.LENGTH_LONG).show()
    }

    private fun getClickListener(): AlbumListAdapter.OnAlbumClickListener{
        return object : AlbumListAdapter.OnAlbumClickListener{
            override fun onAlbumClick(album: AlbumModel) {
                searchAlbumActivity.navigateToAlbumDetails(album)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(SearchAlbumActivity.SAVED_PARAM_ALBUM_MODEL, search_text_view.text.toString())
        super.onSaveInstanceState(outState)
    }

    /*
    private fun initView(view: View){
        if (view.search_text_view.text != null){
            albumListPresenter.showTopAlbums()
        }
        else println("ITS NOT NULL")
    }*/


}