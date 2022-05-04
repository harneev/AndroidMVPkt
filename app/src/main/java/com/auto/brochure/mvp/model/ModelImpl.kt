package com.auto.brochure.mvp.model

import com.auto.brochure.mvp.CarMake
import com.auto.brochure.mvp.MakeModel
import com.auto.brochure.mvp.ModelTrim
import com.auto.brochure.mvp.TrimDetails
import com.auto.brochure.mvp.contract.ModelContract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ModelImpl(private val apiService: RetrofitApiService) : ModelContract {

    override fun getCarManufacturers(): Flow<List<CarMake>> = flow {
        apiService.getCarManufacturers().takeIf { it.isSuccessful }?.body()?.let {
            emit(it)
        }
    }

    override fun getModelsOfBrand(manufacturerCode: String): Flow<List<MakeModel>> {
        TODO("Not yet implemented")
    }

    override fun getModelTrims(modelCode: Int): Flow<List<ModelTrim>> {
        TODO("Not yet implemented")
    }

    override fun getTrimDetails(trimCode: String): Flow<TrimDetails> {
        TODO("Not yet implemented")
    }
}