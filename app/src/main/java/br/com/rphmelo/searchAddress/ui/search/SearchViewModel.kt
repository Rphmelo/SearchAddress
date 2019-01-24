package br.com.rphmelo.searchAddress.ui.search

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.rphmelo.searchAddress.model.Address
import br.com.rphmelo.searchAddress.repository.AddressRepository

class SearchViewModel: ViewModel() {

    val addressRepository = AddressRepository()
    val address = MutableLiveData<Address>()
    val errorMessage = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun search(zipCode: String) {
        isLoading.value = true

        addressRepository.buscar(
                zipCode,
                onComplete = {
                    address.value = it
                    isLoading.value = false
                },
                onError = {
                    address.value = null
                    errorMessage.value = it?.message
                    isLoading.value = false
                }
        )
    }
}