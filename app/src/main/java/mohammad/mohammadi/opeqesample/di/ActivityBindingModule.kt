package mohammad.mohammadi.opeqesample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mohammad.mohammadi.opeqesample.ui.home.HomeActivity
import mohammad.mohammadi.opeqesample.ui.home.HomeModule


@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun homeActivity(): HomeActivity

/*    @ActivityScoped
    @ContributesAndroidInjector(modules = [AddEditTaskModule::class])
    internal abstract fun addEditTaskActivity(): AddEditTaskActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [StatisticsModule::class])
    internal abstract fun statisticsActivity(): StatisticsActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [TaskDetailModule::class])
    internal abstract fun taskDetailActivity(): TaskDetailActivity*/
}
