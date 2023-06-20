package com.pinaluri.TNote

import android.app.Application

class NoteApp : Application(){

    companion object {
        lateinit var ctx: Application
    }

    override fun onCreate() {
        ctx = this
        super.onCreate()
    }
}