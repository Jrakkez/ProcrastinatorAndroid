package com.drakkun.procrastinator

import android.app.Application
import io.realm.Realm

/**
 * Created by Samantha on 8/14/2017.
 */

class ProcrastinatorApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}