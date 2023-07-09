package com.mainal.moviedb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mainal.moviedb.model.tv
import com.mainal.moviedb.model.tvresponse
import com.mainal.moviedb.service.tvApiInterface
import com.mainal.moviedb.service.tvApiService
import kotlinx.android.synthetic.main.fragment_tv.rv_television
import kotlinx.android.synthetic.main.fragment_tv.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TVFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class tvFragment : Fragment() {
    private val tv = arrayListOf<tv>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_television.layoutManager = LinearLayoutManager(this.context)
        rv_television.setHasFixedSize(true)
        getTVData { tv : List<tv> ->
            rv_television.adapter = tvadapter(tv)
        }
        showRecyclerView()
    }

    private fun getTVData(callback: (List<tv>) -> Unit){
        val apiService = tvApiService.getInstance().create(tvApiInterface::class.java)
        apiService.getTVList().enqueue(object : Callback<tvresponse> {
            override fun onFailure(call: Call<tvresponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<tvresponse>, response: Response<tvresponse>) {
                return callback(response.body()!!.tv)
            }

        })
    }

    private fun showRecyclerView() {
        rv_television.layoutManager = LinearLayoutManager(this.context)
        rv_television.adapter = tvadapter(tv)
    }

}

private fun Any.enqueue(callback: Callback<tvresponse>) {
    TODO("Not yet implemented")
}

private fun Any.getTVList(): Any {
    TODO("Not yet implemented")
}

private fun Any.create(java: Class<tvApiInterface>): Any {
    TODO("Not yet implemented")
}
