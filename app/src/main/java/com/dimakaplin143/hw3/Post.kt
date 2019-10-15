package com.dimakaplin143.hw3

import java.util.*

data class Post(
    val postDate: Calendar = GregorianCalendar(),
    val postName: String = "Time to wine",
    val postAuthor: String  = "Big brother",
    val likes: Int  = 0,
    val comments: Int = 1,
    val shares: Int = 0,
    val wasLiked: Boolean = false,
    val wasComment: Boolean = true,
    val wasShared: Boolean = false,
    val location: Location = Location(),
    val videoURL: String = "",
    val hasVideo: Boolean = videoURL !== "",
    val hasLocation: Boolean = location.address !== ""
) {
    fun getDateDiff(): String {
        val now: Calendar = GregorianCalendar()
        val diff: Double = (now.timeInMillis.toDouble() - this.postDate.timeInMillis.toDouble()) / 1000 * 60
        return when {
            diff < 1 -> "Меньше минуты назад"
            diff in 1.0..(1.5) -> "Минуту назад"
            diff in 1.5..5.0 -> "5 минут назад"
            diff in 5.0..10.0 -> "10 минут назад"
            diff in 10.0..15.0 -> "15 минут назад"
            diff in 15.0..20.0 -> "20 минут назад"
            diff in 20.0..30.0 -> "30 минут назад"
            diff in 30.0..40.0 -> "40 минут назад"
            diff in 40.0..50.0 -> "50 минут назад"
            diff in 50.0..60.0 -> "час назад"
            diff in 60.0..(24 * 60.0) -> "Несколько часов назад"
            diff > (24 * 60.00) -> "Более суток"
            else -> "Невероятно долго"
        }

    }

    fun like(): Post {
        var newLikes: Int = likes;
        if(!wasLiked) ++newLikes else --newLikes
        return this.copy( wasLiked = !wasLiked, likes = newLikes)
    }
    fun share(): Post {
        var newShares = shares
        if(!wasShared) ++newShares else --newShares
        return this.copy( wasShared = !wasShared, shares = newShares)

    }

    fun comment(): Post {
        var newComents = comments;
        if(!wasComment) ++newComents else --newComents
        return this.copy( wasComment = !wasComment, comments = newComents)

    }

}