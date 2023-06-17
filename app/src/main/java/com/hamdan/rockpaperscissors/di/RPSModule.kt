package com.hamdan.rockpaperscissors.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

// In the case we need to provide to the view model add here
@InstallIn(ViewModelComponent::class)
@Module
object RPSModule
