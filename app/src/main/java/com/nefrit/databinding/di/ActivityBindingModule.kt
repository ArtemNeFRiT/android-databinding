package com.nefrit.databinding.di

import com.nefrit.data.di.ActivityScoped
import com.nefrit.databinding.ui.LauncherActivity
import com.nefrit.databinding.ui.LauncherModule
import com.nefrit.databinding.ui.operation.OperationActivity
import com.nefrit.databinding.ui.operation.OperationModule
import com.nefrit.databinding.ui.operations.OperationsActivity
import com.nefrit.databinding.ui.operations.OperationsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * We want Dagger.Android to create a Subcomponent which has a parent Component of whichever module
 * ActivityBindingModule is on, in our case that will be [AppComponent]. You never
 * need to tell [AppComponent] that it is going to have all these subcomponents
 * nor do you need to tell these subcomponents that [AppComponent] exists.
 * We are also telling Dagger.Android that this generated SubComponent needs to include the
 * specified modules and be aware of a scope annotation [@ActivityScoped].
 * When Dagger.Android annotation processor runs it will create 2 subcomponents for us.
 */
@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [LauncherModule::class])
    internal abstract fun launcherActivity(): LauncherActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [OperationsModule::class])
    internal abstract fun operationsActivity(): OperationsActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [OperationModule::class])
    internal abstract fun operationActivity(): OperationActivity
}