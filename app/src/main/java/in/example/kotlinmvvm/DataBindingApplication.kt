package `in`.example.kotlinmvvm

import `in`.example.kotlinmvvm.data.db.AppDataBase
import `in`.example.kotlinmvvm.data.network.ApiService
import `in`.example.kotlinmvvm.data.network.NetworkConnectionInterceptor
import `in`.example.kotlinmvvm.data.repositories.UserRepository
import `in`.example.kotlinmvvm.ui.auth.AuthViewModelFactory
import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

// this is a base class for our application
class DataBindingApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@DataBindingApplication))
        //creating all the instances
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { ApiService(instance()) }
        bind() from singleton { AppDataBase(instance()) }
        bind() from singleton { UserRepository(instance(),instance()) }
        bind() from provider  { AuthViewModelFactory(instance()) }
    }
}