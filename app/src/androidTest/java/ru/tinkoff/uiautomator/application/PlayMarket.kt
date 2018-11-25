package ru.tinkoff.uiautomator.application

import ru.tinkoff.uiautomator.util.byStringRes
import ru.tinkoff.uiautomator.util.byStringText
import ru.tinkoff.uiautomator.util.waitFindObject

//TODO (3.1 Tests) concrete page object
class PlayMarket : AbstractApplication("com.android.vending") {

    fun clickSearch() {
        byStringRes("com.android.vending:id/search_box_idle_text").waitFindObject().click()
    }

    fun typeToSearch(text: String) {
        byStringRes("com.android.vending:id/search_box_text_input").waitFindObject().text = text
    }

    //TODO (3.2 Tests) chained selector
    fun click(text: String) {
        byStringRes("com.android.vending:id/li_title")
            .text(text)
            .waitFindObject()
            .click()
    }

    fun clickText(text: String) {
        byStringText(text).waitFindObject().click()
    }

}