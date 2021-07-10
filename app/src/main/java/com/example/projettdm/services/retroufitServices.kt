package com.example.projettdm.services

import com.example.projettdm.constants.apiConstants
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
object retroufitServices {
    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    //Create Okhttp Client
    public val okHttp: OkHttpClient.Builder = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .readTimeout(5, TimeUnit.MINUTES)
        .writeTimeout(5, TimeUnit.MINUTES)


    var gson = GsonBuilder()
        .setLenient()
        .create()


    // Create Retrofit Builder
    public val builder : Retrofit.Builder = Retrofit.Builder()
        .client(okHttp.build())
        .baseUrl(apiConstants.URL_API)
        .addConverterFactory(GsonConverterFactory.create(gson))

    //create Retrofit Instance
    public val retrofit = builder.build()
}