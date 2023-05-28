package com.example.projectuts_alfitra.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectuts_alfitra.DetailMovieActivity
import com.example.projectuts_alfitra.Movie
import com.example.projectuts_alfitra.MovieAdapter
import com.example.projectuts_alfitra.R

class ExploreFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter : MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList : ArrayList<Movie>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var descriptions: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = context?.let {
            MovieAdapter(it, movieArrayList){
                val intent = Intent(context, DetailMovieActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }

    private fun dataInitialize() {
        movieArrayList = arrayListOf<Movie>()

        image = arrayOf(
            R.drawable.brunei,
            R.drawable.cambodia,
            R.drawable.indonesia,
            R.drawable.laos,
            R.drawable.malaysia,
            R.drawable.myanmar,
            R.drawable.pilipina,
            R.drawable.singapore,
            R.drawable.thailand,
            R.drawable.vietnam,


            )

        title = arrayOf(
            "Brunei Darussalam",
            "Cambodia",
            "Indonesia",
            "Laos",
            "Malaysia",
            "Myanmar",
            "Philipines",
            "Singapore",
            "Thailand",
            "Vietnam",



            )

        descriptions = arrayOf(
            "Brunei Darussalam atau Brunei adalah negara berdaulat di Asia Tenggara yang terletak di pantai utara pulau Kalimantan. Negara ini memiliki wilayah seluas 5.765 km² yang menempati pulau Kalimantan dengan garis pantai seluruhnya menyentuh Laut Tiongkok Selatan.",
            "Kerajaan Kamboja adalah sebuah negara berbentuk monarki konstitusional di Asia Tenggara. Negara ini merupakan penerus Kekaisaran Khmer yang pernah menguasai seluruh Semenanjung Indochina antara abad ke-11 dan 14.",
            "Indonesia, dikenal dengan nama resmi Republik Indonesia atau lebih lengkapnya Negara Kesatuan Republik Indonesia, adalah negara kepulauan di Asia Tenggara yang dilintasi garis khatulistiwa dan berada",
            "Laos, secara resmi Republik Demokratis Rakyat Laos, adalah sebuah negara yang terkurung daratan di Asia Tenggara, yang berbatasan dengan Myanmar dan Republik Rakyat Tiongkok di sebelah barat laut, Vietnam di timur, Kamboja di selatan, dan Thailand di sebelah barat.",
            "Malaysia adalah sebuah negara federal yang terdiri dari tiga belas negeri dan tiga wilayah federal di Asia Tenggara dengan luas 330.803 km persegi. Ibu kotanya adalah Kuala Lumpur, sedangkan Putrajaya menjadi pusat pemerintahan federal. Jumlah penduduk negara ini mencapai 32.730.000 jiwa pada tahun 2020.",
            "Republik Persatuan Myanmar adalah sebuah negara berdaulat di Asia Tenggara. Myanmar berbatasan dengan India dan Bangladesh di sebelah barat, Thailand dan Laos di sebelah timur dan Tiongkok di sebelah utara dan timur laut. Negara seluas 676.578 km² ini telah diperintah oleh pemerintahan militer sejak kudeta tahun 1988.",
            "Filipina, dengan nama resmi disebut sebagai Republik Filipina adalah sebuah negara kepulauan dan negara kesatuan yang bersistem presidensial dengan berbentuk republik konstitusional di Asia Tenggara, sebelah utara Indonesia, dan timur laut Sabah.",
            "Singapura adalah sebuah negara pulau dan negara kota di lepas ujung selatan Semenanjung Malaya, 137 kilometer di utara khatulistiwa di Asia Tenggara. Negara ini terpisah dari Malaysia oleh Selat Johor di utara, dan dari Kepulauan Riau, Indonesia oleh Selat Singapura di selatan.",
            "Thailand, secara resmi Kerajaan Thailand yang dibaca Rātcha-āṇāchạk Thai, Rāja-ādnyācạkra Thai; atau, Muang Thai, atau Mueang Thai, adalah sebuah negara di Asia Tenggara yang berbatasan dengan Laos dan Kamboja di timur, Malaysia dan Teluk Siam di selatan, dan Myanmar dan Laut Andaman di barat.",
            "Vietnam, lengkapnya bernama Republik Sosialis Vietnam adalah negara di Asia Tenggara Daratan. Vietnam berbatasan dengan Tiongkok di utara, Laos di barat laut, Kamboja di barat daya, dan dengan Laut Tiongkok Selatan di timur. Laut Tiongkok Selatan di Vietnam disebut Laut Timur.",
        )

        for (i in image.indices) {

            val movie = Movie(image[i],title[i], descriptions[i])
            movieArrayList.add(movie)
        }

    }

}