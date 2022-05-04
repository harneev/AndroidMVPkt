package com.auto.brochure.mvp.contract

import com.auto.brochure.mvp.CarMake
import com.auto.brochure.mvp.MakeModel
import com.auto.brochure.mvp.ModelTrim
import com.auto.brochure.mvp.TrimDetails
import kotlinx.coroutines.flow.Flow

interface ModelContract {

    fun getCarManufacturers(): Flow<List<CarMake>>

    fun getModelsOfBrand(manufacturerCode: String): Flow<List<MakeModel>>

    fun getModelTrims(modelCode: Int): Flow<List<ModelTrim>>

    fun getTrimDetails(trimCode: String): Flow<TrimDetails>
}