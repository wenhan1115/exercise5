package com.example.exercise5



import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import com.example.exercise5.CountViewModel

class MainActivity : AppCompatActivity() {

    private var returnMe : String =""
    private var like : String = ""
    private var dislike : String = ""

    lateinit var countViewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java);

        var like = 0
        var dislike =0
        var increase = 0

        imageViewLike.setOnClickListener{
            countViewModel.like(1)
            like = countViewModel.returnLike()
            textViewLike.setText("" + like)
        }
        imageViewDislike.setOnClickListener{
            countViewModel.dislike(1)
            dislike = countViewModel.returnDislike()
            textViewDislike.setText("" + dislike)
        }
    }

    override fun onPause() {

        super.onPause()
        like = countViewModel.returnLike().toString()
        dislike = countViewModel.returnDislike().toString()

        var sharedPreferences = getSharedPreferences("com.example.exercise5", Context.MODE_PRIVATE)
        var saveLike = sharedPreferences.getString("like", like)?:return
        var saveDislike = sharedPreferences.getString("dislike", dislike)?:return

        with(sharedPreferences.edit()){
            putString("like", like)
            putString("dislike", dislike)
            apply()
        }
    }

    override fun onResume() {

        super.onResume()

        var sharedPreferences = getSharedPreferences("com.example.exercise5", Context.MODE_PRIVATE)
        var getLike = sharedPreferences.getString("like", like)
        var getDislike = sharedPreferences.getString("dislike", dislike)

        if(getLike.equals("") && getDislike.equals(""))
        {
            getLike = "0"
            getDislike = "0"
        }

        textViewLike.setText(getLike + "")
        textViewDislike.setText(getDislike + "")
        countViewModel.setLike(getLike.toString().toInt())
        countViewModel.setDislike(getDislike.toString().toInt())
    }















}