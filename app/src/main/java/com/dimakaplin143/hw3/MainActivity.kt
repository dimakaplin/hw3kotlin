package com.dimakaplin143.hw3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var post = Post(location = Location(18.476223, -77.893890, "Vaneewa 195"), videoURL = "https://www.youtube.com/watch?v=et8xNAc2ic8")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        time.text = post.getDateDiff()
        checkingClickResult()
        initClickers()
        checkingVideo()
        if(post.hasLocation) img_location.visibility = View.VISIBLE else img_location.visibility = View.GONE


    }

    private fun checkingClickResult() {
        checkingShares()
        checkingComments()
        checkingLikes()
    }

    private fun checkingShares() {
        if(post.shares == 0) shares.alpha = (0).toFloat() else shares.alpha = (1).toFloat()
        if(post.wasShared) img_share.setImageResource(R.drawable.share_red) else img_share.setImageResource(R.drawable.share_grey)
        shares.text = post.shares.toString()
    }

    private fun checkingComments() {
        if(post.comments == 0) comments.alpha = (0).toFloat() else comments.alpha = (1).toFloat()
        if(post.wasComment) img_comment.setImageResource(R.drawable.comment_red) else img_comment.setImageResource(R.drawable.comment_grey)
        comments.text = post.comments.toString()
    }

    private fun checkingLikes() {
        if(post.likes == 0) likes.alpha = (0).toFloat() else likes.alpha = (1).toFloat()
        if(post.wasLiked) img_like.setImageResource(R.drawable.like_red) else img_like.setImageResource(R.drawable.like_grey)
        likes.text = post.likes.toString()
    }



    private fun initClickers() {
        img_share.setOnClickListener{
                post = post.share()
                checkingShares()
        }

        img_like.setOnClickListener{
                post = post.like()
                checkingLikes()
        }

        img_comment.setOnClickListener{
                post = post.comment()
                checkingComments()
        }

        img_location.setOnClickListener {
            showLocation(post.location.getUriString())
        }

        img_play.setOnClickListener {
            playVideo(post.videoURL)
        }

    }

    private fun showLocation(geoLocation: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(geoLocation)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun playVideo(videoURL: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(videoURL)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun checkingVideo() {
        if(post.hasVideo) {
            img_play.visibility = View.VISIBLE
        } else {
            img_play.visibility = View.GONE
        }
    }
}
