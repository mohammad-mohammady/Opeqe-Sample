package mohammad.mohammadi.opeqesample.ui.home

import dagger.Module
import dagger.Provides
import mohammad.mohammadi.opeqesample.data.Local
import mohammad.mohammadi.opeqesample.data.Remote
import mohammad.mohammadi.opeqesample.ui.home.datasource.HomeDataSource
import mohammad.mohammadi.opeqesample.ui.home.datasource.local.HomeLocalDataSource
import mohammad.mohammadi.opeqesample.ui.home.datasource.remote.HomeRemoteDataSource

import javax.inject.Singleton

@Module
class HomeRepositoryModule {

    @Singleton
    @Provides
    @Local
    internal fun provideHomeLocalDataSource(): HomeDataSource {
        return HomeLocalDataSource()
    }

    @Singleton
    @Provides
    @Remote
    internal fun provideHomeRemoteDataSource(): HomeDataSource {
        return HomeRemoteDataSource()
    }

}
