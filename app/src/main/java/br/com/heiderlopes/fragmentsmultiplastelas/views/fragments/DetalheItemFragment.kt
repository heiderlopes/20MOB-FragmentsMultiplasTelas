package br.com.heiderlopes.fragmentsmultiplastelas.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import br.com.heiderlopes.fragmentsmultiplastelas.R
import br.com.heiderlopes.fragmentsmultiplastelas.models.Item

class DetalheItemFragment : Fragment() {

    private var item: Item? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getParcelable("item")
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(
            R.layout.fragment_detalhe_item,
            container, false)

        val tvTitle = view.findViewById<TextView>(R.id.tvTitulo)
        val tvBody = view.findViewById<TextView>(R.id.tvSubtitulo)

        tvTitle.text = item?.title
        tvBody.text = item?.body

        return view
    }

    companion object {
        fun newInstance(item: Item): DetalheItemFragment {
            val fragmentDemo = DetalheItemFragment()
            val args = Bundle()

            args.putParcelable("item", item)
            fragmentDemo.arguments = args

            return fragmentDemo
        }
    }
}