package mohammad.mohammadi.opeqesample.ui.home

import dagger.Binds
import dagger.Module
import dagger.Provides
import mohammad.mohammadi.opeqesample.data.Local
import mohammad.mohammadi.opeqesample.data.Remote
import mohammad.mohammadi.opeqesample.data.Repository
import mohammad.mohammadi.opeqesample.di.ActivityScoped
import mohammad.mohammadi.opeqesample.ui.home.datasource.HomeDataSource
import mohammad.mohammadi.opeqesample.ui.home.datasource.HomeRepository
import mohammad.mohammadi.opeqesample.ui.home.datasource.local.HomeLocalDataSource
import mohammad.mohammadi.opeqesample.ui.home.datasource.remote.HomeRemoteDataSource
import javax.inject.Singleton

/**
 * This is a Dagger module. We use this to pass in the View dependency to the
 * [HomePresenter].
 */
@Module
abstract class HomeModule {

    @ActivityScoped
    @Binds
    abstract fun homePresenter(presenter: HomePresenter): HomeContract.Presenter
}