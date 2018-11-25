package ru.tinkoff.uiautomator.application

import android.content.Intent
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import ru.tinkoff.uiautomator.util.*

//TODO (2.7 Unitily) abstract page object
abstract class AbstractApplication(val packageName: String) {

    open fun open() {
        val intent = context.packageManager.getLaunchIntentForPackage(packageName).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        context.startActivity(intent)
        byPackage(packageName).waitHasObject()
    }

    fun clickAndroidOkButton() {
        byStringRes("android:id/button1").waitFindObject().click()
    }

    fun clickAndroidCancelButton() {
        byStringRes("android:id/button2").waitFindObject().click()
    }

    fun assertInstalled() {
        assertThat(
            "'$packageName' is not installed on target device",
            context.packageManager.getLaunchIntentForPackage(packageName),
            notNullValue()
        )
    }

    fun assertTextDisplayed(text: String) {
        assertThat(
            "Text '$text' was not displayed",
            byStringText(text).waitHasObject(),
            equalTo(true)
        )
    }

}