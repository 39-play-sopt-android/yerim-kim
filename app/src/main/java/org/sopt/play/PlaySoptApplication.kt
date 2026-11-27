package org.sopt.play

import android.app.Application
import org.sopt.play.di.AppContainer

class PlaySoptApplication : Application() {
    val container: AppContainer by lazy { AppContainer() }

    override fun onCreate() {
        super.onCreate()
    }
}
