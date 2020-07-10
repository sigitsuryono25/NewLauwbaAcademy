package com.surelabs.request.newlauwbaacademy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.surelabs.request.newlauwbaacademy.R
import com.surelabs.request.newlauwbaacademy.model.kategori.DataItemKategori
import kotlinx.android.synthetic.main.item_adapter_kategori.view.*


class AdapterKategori(
    private val kategoriList: List<DataItemKategori?>?,
    private val click: (DataItemKategori?) -> Unit
) : RecyclerView.Adapter<AdapterKategori.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val namaKategori = itemView.namaKategori
        private val iconKategori = itemView.iconKategori

        fun onBindItem(itemKategori: DataItemKategori?) {
            namaKategori.text = itemKategori?.namaKategori
            loadSvg(iconKategori, itemKategori?.mobileIcon)

            itemView.setOnClickListener {
                click(itemKategori)
            }
        }

        private fun loadSvg(iconKategori: ImageView, iconOnAcademy: String?) {
            Glide.with(itemView.context!!).load(iconOnAcademy).into(iconKategori)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_adapter_kategori, parent, false)
        )
    }

    override fun getItemCount(): Int = kategoriList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindItem(kategoriList?.get(position))
    }

}