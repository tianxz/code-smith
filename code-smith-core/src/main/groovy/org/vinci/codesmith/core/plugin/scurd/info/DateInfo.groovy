package org.vinci.codesmith.core.plugin.scurd.info

import jodd.datetime.JDateTime

/**
 * Created by XizeTian on 2016/12/19.
 */
class DateInfo {
    JDateTime now = new JDateTime()

    void setNow(JDateTime now) {
        this.now = now
    }

    String getNow() {
        return now.toString("YYYY-MM-DD hh:mm:ss")
    }
}
