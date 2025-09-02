package com.depositoamerica.app
import android.app.Application
import com.depositoamerica.app.data.DatabaseSeeder
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DatabaseSeeder.seed(this)
    }
}