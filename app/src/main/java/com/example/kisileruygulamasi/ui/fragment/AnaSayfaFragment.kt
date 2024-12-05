package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.FragmentAnaSayfaBinding
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter

class AnaSayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnaSayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnaSayfaBinding.inflate(inflater, container, false)

        binding.toolbarAnasayfa.title = "Kişiler"

        binding.rv.layoutManager = LinearLayoutManager(requireContext()) //Listelenmenin alt alta görünmesini sağlar

        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Tuba","1111")
        val k2 = Kisiler(2,"Maris","2222")
        val k3 = Kisiler(3,"Samet","3333")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)

        val kisilerAdapter = KisilerAdapter(requireContext(),kisilerListesi)
        binding.rv.adapter = kisilerAdapter //Listeyi görüntülemeyi sağlar

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis) //bağlantımız sayesinde KisiKayitFragmenta geçiş sağlandı
        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean { //harf girdikçe,harf sildikçe bize sonuç getiren fonksiyon
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean { //klavyedeki arama ikonuna basıldığı zaman sonuç getiren fonksiyon
                ara(query)
                return true

            }
        })
        return binding.root
    }

    fun ara(aramaKelimesi:String){
        Log.e("Kişi ara",aramaKelimesi)
    }

}