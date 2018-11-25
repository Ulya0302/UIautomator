package ru.tinkoff.uiautomator.test

import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.uiautomator.application.PlayMarket
import ru.tinkoff.uiautomator.util.byStringRes
import ru.tinkoff.uiautomator.util.getDevice
import ru.tinkoff.uiautomator.util.waitFindObject

//TODO (3.4 Tests) run with is important
@RunWith(AndroidJUnit4::class)
class InstallYoutubeTest : AbstractApplicationTest<PlayMarket>(PlayMarket()) {

    //TODO (3.5 Tests)finally some tests
    @Test
    fun installYoutube() {
        app.open()
        app.clickSearch()
        app.typeToSearch("youtube")
        getDevice().pressEnter()
        app.click("YouTube")
        app.clickText("УСТАНОВИТЬ")
    }

}