package com.anwesh.uiprojects.linkedjumpballwithlineview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.jumpballlineview.JumpBallLineView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JumpBallLineView.create(this)
    }
}
