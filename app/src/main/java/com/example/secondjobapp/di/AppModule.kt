package com.example.secondjobapp.di

import android.content.Context
import androidx.room.Room
import com.example.secondjobapp.db.JobsDatabase
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
    fun povideJobsDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,JobsDatabase::class.java,JOBS_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideJobDao(db : JobsDatabase) = db.getJobsDao()

}