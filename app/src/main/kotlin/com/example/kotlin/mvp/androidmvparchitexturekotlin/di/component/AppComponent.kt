package androidachitecturecomponent.example.di

import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.local.LocalDataSource
import com.example.kotlin.mvp.androidmvparchitexturekotlin.data.remote.RemoteDataSource
import dagger.Component
import javax.inject.Singleton


/**
 * Created by DOUIRI Ali on 16/03/2018.
 * my.alidouiri@gmail.com
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun roomDataSource(): LocalDataSource

    fun remoteDataSource(): RemoteDataSource

}