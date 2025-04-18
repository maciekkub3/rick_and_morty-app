package com.example.rickandmorty.di.modules

import com.example.rickandmorty.data.network.RickAndMortyService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
class NetworkingModule {

    @Provides
    fun providesOkHttpClient(): OkHttpClient.Builder = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Provides
    fun providesRetrofit(
        moshi: Moshi,
        okHttpClient: OkHttpClient.Builder
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient.build())
            .build()
    }

    @Provides
    fun providesCharacterService(retrofit: Retrofit): RickAndMortyService {
        return retrofit.create(RickAndMortyService::class.java)
    }

}