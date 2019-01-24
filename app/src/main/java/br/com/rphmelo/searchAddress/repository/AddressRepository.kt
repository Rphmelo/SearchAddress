package br.com.rphmelo.searchAddress.repository

import br.com.rphmelo.searchAddress.api.getAddressService
import br.com.rphmelo.searchAddress.model.Address
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddressRepository {
    fun buscar(
            zipCode: String,
            onComplete: (Address?) -> Unit,
            onError: (Throwable?) -> Unit
    ){
        getAddressService().search(zipCode).enqueue(
                object: Callback<Address> {
                    override fun onFailure(call: Call<Address>?, t: Throwable?) {
                        onError(t)
                    }

                    override fun onResponse(call: Call<Address>?, response: Response<Address>?) {
                        if(response?.isSuccessful == true){
                            onComplete(response.body())
                        } else {
                            onError(Throwable(response?.errorBody()?.string()))
                        }
                    }
                }
        )
    }
}