package com.example.jcp.siriusxmtest.data.remote.api

import com.example.jcp.siriusxmtest.BuildConfig
import com.example.jcp.siriusxmtest.data.entities.ApiResponse
import io.reactivex.Single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.Result
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by jacp on 5/23/2018.
 */
interface BooksService {

    //Todo change the
    @Headers("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3)")
    @GET("/books/v1/volumes")
    fun retrieveBooks(@Query("q")q:String?,
                      @Query("maxResults")maxResults:Int = 40,
                      @Query("startIndex") startIndex:Int = 0)
            : Single<ApiResponse>

    companion object Factory {

        fun createApiInterceptor(): Interceptor {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return interceptor
        }

        fun createOkHttp(interceptor: Interceptor): OkHttpClient {
            return OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
        }

        fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(BuildConfig.GOOGLE_BOOKS_BASE_URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        fun createApiService(retrofit: Retrofit): BooksService
                = retrofit.create(BooksService::class.java)
    }
}