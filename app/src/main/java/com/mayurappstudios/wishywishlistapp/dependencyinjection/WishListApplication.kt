package com.mayurappstudios.wishywishlistapp.dependencyinjection

import android.app.Application

class WishListApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)

    }
}