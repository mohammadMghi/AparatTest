package com.mm.aparat.feature.main

import android.graphics.Paint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.mm.aparat.R
import com.mm.aparat.data.Mostviewedvideo
import com.mm.aparat.data.Video

class VideoAdapter : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {
    var onVideoClickListener : OnVideoClickListener? = null
    var number = 0
    var mostviewedvideo = ArrayList<Mostviewedvideo>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cover : SimpleDraweeView = itemView.findViewById(R.id.videoCoverIv)
        val title : TextView = itemView.findViewById(R.id.titleTv)
        val counter : TextView = itemView.findViewById(R.id.counterTv)
        fun bindVideo(mostviewedvideo: Mostviewedvideo) {

            cover.setImageURI(Uri.parse(mostviewedvideo.small_poster).toString())
            title.text = mostviewedvideo.title
            number += 1
            counter.text = number.toString()

            itemView.setOnClickListener {
                onVideoClickListener?.onVideoClick(mostviewedvideo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.vedio_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindVideo(mostviewedvideo[position])
    }

    override fun getItemCount(): Int = mostviewedvideo.size

    interface OnVideoClickListener {
        fun onVideoClick(mostviewedvideo: Mostviewedvideo)
    }
}