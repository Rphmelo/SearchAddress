package br.com.rphmelo.searchAddress.api

import br.com.rphmelo.searchAddress.model.Address
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressService {
    @GET("ws/{zipCode}/json")
    fun search(@Path("zipCode") zipCode: String): Call<Address>
}