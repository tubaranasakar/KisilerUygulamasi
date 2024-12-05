package com.example.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.CardTasarimBinding
import com.example.kisileruygulamasi.databinding.FragmentAnaSayfaBinding
import com.example.kisileruygulamasi.ui.fragment.AnaSayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext:Context,var kisilerListesi:List<Kisiler>) : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        // ViewBinding kurulumunun burada yapılması gerekir
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(binding)

    }
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        // Asıl önemli kısım burasıdır. Yapılacak tüm işlemler burada gerçekleştirilir.
        val kisi = kisilerListesi.get(position)
        val t = holder.tasarim

        t.textViewKisiAd.text = kisi.kisi_ad
        t.textViewKisiTel.text = kisi.kisi_tel

        t.cardViewSatir.setOnClickListener {
            // Seçilen kişinin detayına gitme işlemi burada gerçekleşir
            val gecis = AnaSayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewSil.setOnClickListener {
            // Seçilen kişinin silinme işlemi burada gösterilir
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi? ",Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    sil(kisi.kisi_id.toString())
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        //Kaç tane item olacak burada belirtilir
        return kisilerListesi.size
    }

    fun sil(kisi_Id:String){
        Log.e("Kişi Sil",kisi_Id.toString())
    }

}