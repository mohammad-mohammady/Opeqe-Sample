package mohammad.mohammadi.opeqesample.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import mohammad.mohammadi.opeqesample.OpeqeApplication
import mohammad.mohammadi.opeqesample.ui.home.HomeModule
import mohammad.mohammadi.opeqesample.ui.home.datasource.HomeRepository

import javax.inject.Singleton

@Singleton
//@Component(modules = [TasksRepositoryModule::class, ApplicationModule::class, ActivityBindingModule::class, AndroidSupportInjectionModule::class])
@Component(modules = [ ApplicationModule::class, ActivityBindingModule::class, AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<OpeqeApplication> {

    //val homeRepository: HomeRepository

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}
