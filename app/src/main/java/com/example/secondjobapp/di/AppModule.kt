package com.example.secondjobapp.di

import android.content.Context
import androidx.room.Room
import com.example.secondjobapp.db.JobsAndClientsDatabase
import com.example.secondjobapp.other.Constants.JOBS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Singleton
    @Provides
    fun provideJobsAndClientsDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app, JobsAndClientsDatabase::class.java, JOBS_DATABASE_NAME,
    ).build()

    @Singleton
    @Provides
    fun provideJobDao(db : JobsAndClientsDatabase) = db.getJobsDao()
    @Singleton
    @Provides
    fun provideClientsDao(db : JobsAndClientsDatabase) = db.getClientsDao()

}