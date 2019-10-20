package com.anwesh.uiprojects.jumpballlineview

/**
 * Created by anweshmishra on 20/10/19.
 */
import android.view.View
import android.view.MotionEvent
import android.content.Context
import android.app.Activity
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color

val nodes : Int = 5
val scGap : Float = 0.01f
val strokeFactor : Float = 90f
val sizeFactor : Float = 2.9f
val delay : Long = 20
val foreColor : Int = Color.parseColor("#9FA8DA")
val backColor : Int = Color.parseColor("#BDBDBD")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.toDest(source : Float, dest : Float) : Float = source + (dest - source) * this
