package com.auto.brochure.mvp

import com.auto.brochure.mvp.contract.ModelContract
import com.auto.brochure.mvp.model.ModelImpl
import com.auto.brochure.mvp.model.RetrofitApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppDI {

    const val BASE_URL = "https://parallelum.com.br/fipe/api/v1/"

    val httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private fun providerRetrofitApiService(okHttpClient: OkHttpClient): RetrofitApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(RetrofitApiService::class.java)

    fun provideModel(): ModelContract = ModelImpl(
        providerRetrofitApiService(
            provideOkHttpClient(
                httpLoggingInterceptor
            )
        )
    )
}