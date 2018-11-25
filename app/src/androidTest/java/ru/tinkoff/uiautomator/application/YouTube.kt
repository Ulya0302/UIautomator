package ru.tinkoff.uiautomator.application

import ru.tinkoff.uiautomator.util.*

class YouTube : AbstractApplication("com.google.android.youtube") {

    fun clickOnSearch() {
        byContentDesc("Введите запрос").waitFindObject().click()
    }

    fun sendString(text: String) {
        byStringRes("com.google.android.youtube:id/search_edit_text").waitFindObject().text = text
        getDevice().pressEnter()
    }

    fun clickOnVideoByNumber(number : Int) =
        byStringRes("com.google.android.youtube:id/title").waitFindObjects()[number-1].click()

    fun stopOnTenSeconds() {
        waitAd()
        Thread.sleep(2000)
        clickOnPlayer()
        val stringSeconds = byStringRes("com.google.android.youtube:id/time_bar_current_time")
            .waitFindObject().text
        val time = 10 - getSeconds(stringSeconds)
        Thread.sleep((time-1)*1000)
        clickOnPlayer()
        clickPause()
    }

    private fun getSeconds(time: String): Long {
        return time.substringAfter(":").toLong()
    }

    private fun waitAd() {
        while (byStringRes("com.google.android.youtube:id/ad_progress_text").waitOneSecond()) {}
    }

    private fun clickPause() {
        byStringRes("com.google.android.youtube:id/player_control_play_pause_replay_button")
            .waitFindObject()
            .click()
    }

    private fun clickOnPlayer() {
        byStringRes("com.google.android.youtube:id/player_view")
            .waitFindObject()
            .click()
    }
}
