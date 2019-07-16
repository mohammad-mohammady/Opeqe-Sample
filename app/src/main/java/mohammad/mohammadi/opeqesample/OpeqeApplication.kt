package mohammad.mohammadi.opeqesample

import android.content.res.AssetManager
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import mohammad.mohammadi.opeqesample.di.DaggerAppComponent
import mohammad.mohammadi.opeqesample.util.Statics
import mohammad.mohammadi.opeqesample.util.Statics.jsonFile

class OpeqeApplication: DaggerApplication()
{
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}