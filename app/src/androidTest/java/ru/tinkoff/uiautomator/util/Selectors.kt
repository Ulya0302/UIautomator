@file:JvmName("Selectors")

package ru.tinkoff.uiautomator.util

import android.support.annotation.IdRes
import androidx.test.uiautomator.*
import java.util.concurrent.TimeUnit

private val timeout = TimeUnit.SECONDS.toMillis(5)

//TODO (2.4 Unitily) since we don't have access to targetContext, never be used
fun byRes(@IdRes resId: Int): BySelector = By.res(targetContext.resources.getResourceName(resId))

//TODO (2.5 Unitily) add some utility By selectors
fun byPackage(packageName: String): BySelector = By.pkg(packageName)

fun byStringRes(resString: String): BySelector = By.res(resString)

fun byStringText(text: String): BySelector = By.text(text)

fun byContentDesc(text: String): BySelector = By.desc(text)



//TODO (2.6 Unitily) and simple extension functions
fun BySelector.waitFindObject(): UiObject2 =
    getDevice().wait(Until.findObject(this), timeout)

fun BySelector.waitHasObject(): Boolean =
    getDevice().wait(Until.hasObject(this), timeout)

fun BySelector.waitFindObjects(): List<UiObject2> =
    getDevice().wait(Until.findObjects(this), timeout)

fun BySelector.WaitOneSecond():  Boolean =
    getDevice().wait(Until.hasObject(this), TimeUnit.SECONDS.toMillis(1))

