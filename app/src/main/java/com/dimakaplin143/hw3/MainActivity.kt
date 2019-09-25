package com.dimakaplin143.hw3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val post = Post()
        time.text = post.getDateDiff()
        if(post.wasLiked) img_like.setImageResource(R.drawable.like_red)
        if(post.wasComment) img_comment.setImageResource(R.drawable.comment_red)
        if(post.wasShared) img_share.setImageResource(R.drawable.share_red)

        likes.text = post.likes.toString()
        comments.text = post.comments.toString()
        shares.text = post.shares.toString()

        if(post.likes == 0) likes.alpha = (0).toFloat()
        if(post.comments == 0) comments.alpha = (0).toFloat()
        if(post.shares == 0) shares.alpha = (0).toFloat()





    }
}
