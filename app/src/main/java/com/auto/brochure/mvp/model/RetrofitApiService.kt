package com.auto.brochure.mvp.model

import com.auto.brochure.mvp.CarMake
import com.auto.brochure.mvp.MakeModel
import com.auto.brochure.mvp.ModelTrim
import com.auto.brochure.mvp.TrimDetails
import retrofit2.Response
import retrofit2.http.GET

/**
 * @link https://deividfortuna.github.io/fipe/
 * @author Harneev Sethi
 */
interface RetrofitApiService  {

    @GET("carros/marcas")
    suspend fun getCarManufacturers(): Response<List<CarMake>>

    @GET("api/json/est/now")
    suspend fun getModelsOfBrand(manufacturerCode: String): Response<List<MakeModel>>

    @GET("api/json/est/now")
    suspend fun getModelTrims(modelCode: Int): Response<List<ModelTrim>>

    @GET("api/json/est/now")
    suspend fun getTrimDetails(trimCode: String): Response<TrimDetails>
}