package com.soyjj.ubicatm.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.soyjj.ubicatm.Models.ATM
import com.soyjj.ubicatm.Models.BDFake
import com.soyjj.ubicatm.R
import kotlinx.android.synthetic.main.item_atm.view.*

class ATMadapter(val context: Context) :
    RecyclerView.Adapter<ATMadapter.ViewHolder>() {
    private var atmList : ArrayList<ATM> = BDFake.atms()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v : View = LayoutInflater.from(context).inflate(
            R.layout.item_atm,
            parent, false)
        Toast.makeText(this.context, "El banco onCreateViewHolder.. ${this.atmList!![0].banco}", Toast.LENGTH_LONG).show()
        return ATMadapter.ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return atmList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.bancoNombre.text = BDFake.consultarBanco(atmList.get(position).banco)!!.nombre
        holder.itemView.tipoATM.text = atmList.get(position).tipo
        holder.itemView.localidadNombre.text = BDFake.consultarLocalidad(atmList[position].localidad)!!.nombre
        holder.itemView.localidadLatitud.text = BDFake.consultarLocalidad(atmList[position].localidad)!!.latitud.toString()
        holder.itemView.localidadLongitud.text = BDFake.consultarLocalidad(atmList[position].localidad)!!.longitud.toString()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}