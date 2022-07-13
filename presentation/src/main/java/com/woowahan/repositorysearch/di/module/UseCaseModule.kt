package com.woowahan.repositorysearch.di.module

import com.woowahan.domain.authUseCase.GetGitHubAccessTokenUseCase
import com.woowahan.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Singleton
    @Provides
    @RetrofitModule.typeAuth
    fun provideGetGitHubAccessTokenUseCase(@RetrofitModule.typeAuth repository: AuthRepository): GetGitHubAccessTokenUseCase {
        return GetGitHubAccessTokenUseCase(repository)
    }
}