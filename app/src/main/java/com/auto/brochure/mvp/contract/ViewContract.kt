package com.auto.brochure.mvp.contract

import com.auto.brochure.mvp.CarMake
import com.auto.brochure.mvp.MakeModel
import com.auto.brochure.mvp.ModelTrim
import com.auto.brochure.mvp.TrimDetails

/**
 * @author Harneev Sethi
 */
interface ViewContract {

    fun displayCarManufacturers(list: List<CarMake>)

    fun displayModelsOfBrand(manufacturerCode: String, list: List<MakeModel>)

    fun displayModelTrims(modelCode: Int, list: List<ModelTrim>)

    fun displayTrimDetails(trimCode: String, list: List<TrimDetails>)

    fun showError(errorMessage: String)
}