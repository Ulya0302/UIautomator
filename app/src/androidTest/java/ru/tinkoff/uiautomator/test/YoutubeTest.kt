package ru.tinkoff.uiautomator.test

import org.junit.Test
import ru.tinkoff.uiautomator.application.YouTube

class YoutubeTest : AbstractApplicationTest<YouTube>(YouTube()) {

    @Test
    fun playVideoTest() {
        app.open()
        app.clickOnSearch();
        app.sendString("imagine dragons natural")
        app.clickOnVideoByNumber(1);
        app.stopOnTenSeconds()
        Thread.sleep(2000)
    }
}