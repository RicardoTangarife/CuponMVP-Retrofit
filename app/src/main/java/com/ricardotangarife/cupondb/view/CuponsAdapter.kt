package com.ricardotangarife.cupondb.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ricardotangarife.cupondb.R
import com.ricardotangarife.cupondb.model.Offer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cupon_list_item.view.*

class CuponsAdapter(cuponsList: ArrayList<Offer>) :
    RecyclerView.Adapter<CuponsAdapter.CuponsViewHolder>() {

    private var cuponsList = ArrayList<Offer>()

    init {
        this.cuponsList = cuponsList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuponsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cupon_list_item, parent, false)
        return CuponsViewHolder(itemView)
    }

    override fun getItemCount(): Int = cuponsList.size

    override fun onBindViewHolder(holder: CuponsViewHolder, position: Int) {
        val cupon = cuponsList[position]
        holder.setCupon(cupon)
    }

    class CuponsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var cupon: Offer? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun setCupon(cupon: Offer) {
            this.cupon = cupon
            val URL_IMAGE_DEFECT = "https://img.icons8.com/dusk/64/000000/cutting-coupon.png"
            itemView.tv_title.text = cupon.title
            itemView.tv_store.text = cupon.store
            itemView.tv_end_date.text = cupon.endDate
            if(!cupon.imageUrl.isNullOrEmpty()){
                Picasso.get().load(cupon.imageUrl).into(itemView.iv_picture)
            }
            else{
                Picasso.get().load(URL_IMAGE_DEFECT).into(itemView.iv_picture)
            }

        }

        override fun onClick(v: View) {
            val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra("cupon", cupon)
                itemView.context.startActivity(intent)
        }
    }

}