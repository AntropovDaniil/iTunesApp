package com.example.itunesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit_button.setOnClickListener {
            if (!searchTextView.text.toString().equals(null)){
                getData(searchTextView.text.toString())
            }
            else{
                resultTextView.setText("Fill the searchTextView")
            }
        }

    }

    private fun getData(searchTerm: String){
        /*val call: Call<Post> = ApiClient.getClient.getTracks(searchTerm)
        call.enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {

                if (!response.isSuccessful){
                    resultTextView.setText("Code ${response.code()}")
                }
                else{
                    var str = ""
                    val post: Post? = response.body()
                    val tracks = post?.resultModels
                    if (tracks != null) {
                        for (album in tracks) {
                            str += "${album.collectionName} - ${album.artistName}: ${album.primaryGenreName} \n\n"
                        }
                        resultTextView.setText(str)

                    }else resultTextView.setText("tracks = null");
                }


            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                resultTextView.setText("Failed")
            }
        })*/
    }
}