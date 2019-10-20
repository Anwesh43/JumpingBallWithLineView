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
fun Float.sinify() : Float = Math.sin(this * Math.PI / 180).toFloat()

fun Canvas.drawBallWithLine(sc : Float, h : Float, size : Float, paint : Paint) {
    val sc1 : Float = sc.divideScale(0, 3)
    val sc2 : Float = sc.divideScale(1, 3)
    val sc3 : Float = sc.divideScale(2, 3)
    val sf : Float = sc2.sinify()
    drawCircle(0f, sf.toDest(h - size, size), size, paint)
    drawLine(0f, sf.toDest(h - 2 * size, 0f), 0f, (sc1 - sc3).toDest(h - 2 * size, 0f), paint)
}

fun Canvas.drawJBLNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val size : Float = gap / sizeFactor
    paint.color = foreColor
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(gap * (i + 1), 0f)
    drawBallWithLine(scale, h, size, paint)
    restore()
}
