package ru.tinkoff.uiautomator.test

import android.os.Build
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import ru.tinkoff.uiautomator.BuildConfig
import ru.tinkoff.uiautomator.application.AbstractApplication
import ru.tinkoff.uiautomator.util.*

//TODO (2.8 Unitily) some setUp
open class AbstractApplicationTest<T : AbstractApplication>(val app: T) {

    //TODO (3.3 Tests) simple jUnit style
    @Before
    fun assertPackageInstalled() {
        getDevice().pressHome()
        assertThat(getDevice().launcherPackageName, notNullValue())
        byPackage(getDevice().launcherPackageName).waitHasObject()
        app.assertInstalled()
    }

    @Before
    fun grandPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val applicationId = BuildConfig.APPLICATION_ID
            val state = android.Manifest.permission.READ_PHONE_STATE
            getDevice().executeShellCommand("pm grant $applicationId $state")
        }
    }
}