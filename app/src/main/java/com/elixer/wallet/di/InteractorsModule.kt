package com.elixer.wallet.di


import com.elixer.wallet.cache.RecipeDao
import com.elixer.wallet.presentation.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object InteractorsModule {

    @ViewModelScoped
    @Provides
    fun provideRepository(recipeDao: RecipeDao) = Repository(recipeDao)

}











