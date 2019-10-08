package com.dimakaplin143.hw3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val post = Post(location = Location(18.476223, -77.893890), videoURL = "https://www.youtube.com/watch?v=et8xNAc2ic8")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        time.text = post.getDateDiff()
        checkingClickResult()
        initClickers()
        checkingVideo()


    }

    private fun checkingClickResult() {
        if(post.likes == 0) likes.alpha = (0).toFloat() else likes.alpha = (1).toFloat()
        if(post.comments == 0) comments.alpha = (0).toFloat() else comments.alpha = (1).toFloat()
        if(post.shares == 0) shares.alpha = (0).toFloat() else shares.alpha = (1).toFloat()
        if(post.wasLiked) img_like.setImageResource(R.drawable.like_red) else img_like.setImageResource(R.drawable.like_grey)
        if(post.wasComment) img_comment.setImageResource(R.drawable.comment_red) else img_comment.setImageResource(R.drawable.comment_grey)
        if(post.wasShared) img_share.setImageResource(R.drawable.share_red) else img_share.setImageResource(R.drawable.share_grey)
        likes.text = post.likes.toString()
        comments.text = post.comments.toString()
        shares.text = post.shares.toString()
    }

    private fun checkingClickResult(type: String) {
        if(type === "share") {
            if(post.shares == 0) shares.alpha = (0).toFloat() else shares.alpha = (1).toFloat()
            if(post.wasShared) img_share.setImageResource(R.drawable.share_red) else img_share.setImageResource(R.drawable.share_grey)
            shares.text = post.shares.toString()
        }
        if(type === "comment") {
            if(post.comments == 0) comments.alpha = (0).toFloat() else comments.alpha = (1).toFloat()
            if(post.wasComment) img_comment.setImageResource(R.drawable.comment_red) else img_comment.setImageResource(R.drawable.comment_grey)
            comments.text = post.comments.toString()
        }
        if(type === "like") {
            if(post.likes == 0) likes.alpha = (0).toFloat() else likes.alpha = (1).toFloat()
            if(post.wasLiked) img_like.setImageResource(R.drawable.like_red) else img_like.setImageResource(R.drawable.like_grey)
            likes.text = post.likes.toString()
        }



    }

    private fun initClickers() {
        img_share.setOnClickListener{
            if(it is ImageButton) {
                post.share()
                checkingClickResult("share")
            }
        }

        img_like.setOnClickListener{
            if(it is ImageButton) {
                post.like()
                checkingClickResult("like")
            }
        }

        img_comment.setOnClickListener{
            if(it is ImageButton) {
                post.comment()
                checkingClickResult("comment")
            }
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
