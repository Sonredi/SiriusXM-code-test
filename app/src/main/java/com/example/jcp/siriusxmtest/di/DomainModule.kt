package com.example.jcp.siriusxmtest.di

import com.example.jcp.siriusxmtest.data.local.LocalDataSource
import com.example.jcp.siriusxmtest.data.remote.RemoteDataSource
import com.example.jcp.siriusxmtest.data.remote.api.BooksService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by jacp on 5/23/2018.
 */
@Module
class DomainModule {
    @Singleton
    @Provides
    fun createLocalDataSource(): LocalDataSource {
        return LocalDataSource()
    }

    @Singleton
    @Provides
    fun createRemoteDataSource(booksService: BooksService): RemoteDataSource {
        return RemoteDataSource(booksService)
    }

    @Singleton
    @Provides
    fun createInterceptor(): Interceptor {
        return BooksService.Factory.createApiInterceptor()
    }

    @Singleton
    @Provides
    fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        return BooksService.Factory.createOkHttp(interceptor)
    }

    @Singleton
    @Provides
    fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return BooksService.Factory.createRetrofit(okHttpClient)
    }

    @Singleton
    @Provides
    fun createBooksService(retrofit: Retrofit): BooksService {
        return BooksService.Factory.createApiService(retrofit)
    }
}