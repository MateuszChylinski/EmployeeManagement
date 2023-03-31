package com.example.employeemanagement.DI

import android.content.Context
import androidx.room.Room
import com.example.employeemanagement.DAO.EmployeeDAO
import com.example.employeemanagement.Database.EmployeeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun createDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        EmployeeDatabase::class.java,
        "employee_database"
    ).build()

 @Singleton
    @Provides
    fun provideDAO(database: EmployeeDatabase): EmployeeDAO{
        return database.getDAO()
    }
}