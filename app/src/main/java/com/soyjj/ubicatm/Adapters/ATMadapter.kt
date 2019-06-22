package com.soyjj.ubicatm.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.soyjj.ubicatm.Models.ATM
import com.soyjj.ubicatm.Models.BDFake
import com.soyjj.ubicatm.Models.Banco
import com.soyjj.ubicatm.Models.Localidad
import com.soyjj.ubicatm.R
import kotlinx.android.synthetic.main.item_atm.view.*
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.net.Uri


class ATMadapter(val context: Context) :
    RecyclerView.Adapter<ATMadapter.ViewHolder>() {
    private var atmList : ArrayList<ATM> = BDFake.atms()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v : View = LayoutInflater.from(context).inflate(
            R.layout.item_atm,
            parent, false)
        return ATMadapter.ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return atmList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var b : Banco? = BDFake.consultarBanco(atmList[position].banco)
        var l : Localidad? = BDFake.consultarLocalidad(atmList[position].localidad)

        holder.itemView.bancoNombre.text = b!!.nombre
        holder.itemView.tipoATM.text = "TIPO: " + atmList[position].tipo
        holder.itemView.localidadNombre.text = l!!.nombre
        holder.itemView.cantidad.text = "CANT.: " + atmList[position].cantidad.toString()
        Glide.with(holder.itemView.context).load(b.logo).into(holder.itemView.logo)
        Glide.with(holder.itemView.context).load(R.drawable.ic_location).into(holder.itemView.ubicacion)
        holder.itemView.ubicacion.setOnClickListener{
            val str : String = "geo:" + l.latitud + "," + l.longitud
            Toast.makeText(holder.itemView.context, str, Toast.LENGTH_SHORT).show()
            val gmmIntentUri = Uri.parse(str)
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            holder.itemView.context.startActivity(mapIntent)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}