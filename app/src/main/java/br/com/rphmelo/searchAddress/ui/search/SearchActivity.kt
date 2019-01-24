package br.com.rphmelo.searchAddress.ui.search

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.rphmelo.searchAddress.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        Picasso.get().load("https://png.pngtree.com/svg/20150619/ts_icon_geolocation_945487.png")
                .into(ivLogo)

        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

        btSearch.setOnClickListener {
            search()
        }
    }

    private fun search() {
        searchViewModel.search(etZipCode.text.toString())
        searchViewModel.address.observe(this, Observer {
            tvResult.text = it?.street
        })
        searchViewModel.errorMessage.observe(this, Observer {
            if(!it.equals("")) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
        searchViewModel.isLoading.observe(this, Observer {
            if(it == true){
              pbLoading.visibility = View.VISIBLE
            } else {
                pbLoading.visibility = View.INVISIBLE
            }
        })
    }
}
