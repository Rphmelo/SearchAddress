package br.com.rphmelo.searchAddress.model

import com.google.gson.annotations.SerializedName

data class Address(
        @SerializedName("cep") val zipCode: String,
        @SerializedName("logradouro") val street: String,
        @SerializedName("complemento") val complement: String,
        @SerializedName("bairro") val district: String,
        @SerializedName("localidade") val city: String,
        @SerializedName("uf") val uf: String
)