package com.example.employeemanagement.DI

import com.example.employeemanagement.Repository.EmployeeRepository
import com.example.employeemanagement.Repository.RepositoryImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(
        repositoryImplementation: RepositoryImplementation
    ): EmployeeRepository
}