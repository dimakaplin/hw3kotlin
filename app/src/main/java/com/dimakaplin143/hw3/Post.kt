package com.dimakaplin143.hw3

import java.util.*

class Post(
    var postDate: Calendar = GregorianCalendar(),
    var postName: String = "Time to wine",
    var postAuthor: String  = "Big brother",
    var likes: Int  = 0,
    var comments: Int = 1,
    var shares: Int = 0,
    var wasLiked: Boolean = false,
    var wasComment: Boolean = true,
    var wasShared: Boolean = false,
    var location: Location = Location(),
    var videoURL: String = "",
    var hasVideo: Boolean = videoURL !== ""
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

    fun like(): Boolean {
        wasLiked = !wasLiked
        if(wasLiked) ++likes else --likes
        return wasLiked
    }
    fun share(): Boolean {
        wasShared = !wasShared
        if(wasShared) ++shares else --shares
        return wasLiked
    }
    fun comment(): Boolean {
        wasComment = !wasComment
        if(wasComment) ++comments else --comments
        return wasLiked
    }

}