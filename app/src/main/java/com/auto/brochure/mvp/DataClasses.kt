package com.auto.brochure.mvp

import com.google.gson.annotations.SerializedName

data class CarMake(
    @SerializedName("codigo") val id: String,
    @SerializedName("nome") val name: String
)

data class MakeModel(
    @SerializedName("codigo") val id: Int,
    @SerializedName("nome") val name: String
)

data class ModelTrim(
    @SerializedName("codigo") val id: String,
    @SerializedName("nome") val name: String
)

data class TrimDetails(
    @SerializedName("Valor") val price: String,
    @SerializedName("Marca") val brand: String,
    @SerializedName("Modelo") val model: String,
    @SerializedName("AnoModelo") val year: Int,
    @SerializedName("Combustivel") val fuelType: String,
    @SerializedName("CodigoFipe") val code: String,
    @SerializedName("TipoVeiculo") val vehicleType: Int,
    @SerializedName("SiglaCombustivel") val fuelAcronym: String
)