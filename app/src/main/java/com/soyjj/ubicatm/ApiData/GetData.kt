package com.soyjj.ubicatm.ApiData

import com.soyjj.ubicatm.Models.ATM
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler

class GetData {
    var misATMs : List<ATM> = emptyList()

    private fun AtmsData() : List<ATM> {
        val resp = ApiService.instance().getATMs()
        resp.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler()).subscribe {
            misATMs = it
        }
        return misATMs
    }
}