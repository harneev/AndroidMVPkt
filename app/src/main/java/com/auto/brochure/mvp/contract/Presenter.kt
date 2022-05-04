package com.auto.brochure.mvp.contract

import kotlinx.coroutines.flow.collect

/**
 * @author Harneev Sethi
 */
class Presenter(val view: ViewContract, val model: ModelContract) {

    suspend fun getCarManufacturersList() =
        model.getCarManufacturers().collect {
            view.displayCarManufacturers(it)
        }
}