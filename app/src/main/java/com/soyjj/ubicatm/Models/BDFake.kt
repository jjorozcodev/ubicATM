package com.soyjj.ubicatm.Models

import com.soyjj.ubicatm.R

class BDFake {
    companion object Get {

        val getBancos : ArrayList<Banco> = bancos()
        val getLocalidades : ArrayList<Localidad> = localidades()
        var getAtms : ArrayList<ATM> = atms()

        fun consultarBanco(idBanco : Int): Banco? {
            var b : Banco? = null

            getBancos.forEach{
                if(it.id==idBanco) {
                    b = it
                }
            }

            return b
        }

        fun consultarLocalidad(idLocalidad : Int): Localidad? {
            var l : Localidad? = null

            getLocalidades.forEach{
                if(it.id==idLocalidad){
                    l = it
                }
            }

            return l
        }

        fun bancos() : ArrayList<Banco>{
            var listBancos = ArrayList<Banco>()

            listBancos.add(Banco(1, "Bancentro", R.drawable.bancentro))
            listBancos.add(Banco(2, "BAC", R.drawable.bac))
            listBancos.add(Banco(3, "Banpro", R.drawable.banpro))

            return listBancos
        }

        fun localidades() : ArrayList<Localidad>{
            var listLocalidades = ArrayList<Localidad>()

            listLocalidades.add(Localidad(1,"Centro Comercial Managua", 12.117084, -86.248262))
            listLocalidades.add(Localidad(2,"Centro Comercial Metrocentro", 12.127825, -86.264779))
            listLocalidades.add(Localidad(3,"Galerías Santo Domingo", 12.103584, -86.248946))
            listLocalidades.add(Localidad(4,"Multicentro Las Américas", 12.139608, -86.229010))
            listLocalidades.add(Localidad(5,"Plaza Inter", 12.144748, -86.274031 ))

            return listLocalidades
        }

        fun atms() : ArrayList<ATM> {
            var listATMs = ArrayList<ATM>()

            listATMs.add(ATM(1, 1, 1, 4, "Cash"))
            listATMs.add(ATM(2, 1, 2, 3, "Cash"))
            listATMs.add(ATM(3, 2, 2, 2, "Cash"))
            listATMs.add(ATM(4, 3, 2, 1, "Cash"))
            listATMs.add(ATM(5, 3, 3, 1, "Full"))
            listATMs.add(ATM(6, 3, 4, 1, "Full"))
            listATMs.add(ATM(7, 2, 4, 1, "Cash"))
            listATMs.add(ATM(8, 2, 3, 2, "Cash"))
            listATMs.add(ATM(9, 2, 5, 1, "Full"))
            listATMs.add(ATM(10, 3, 5, 2, "Cash"))

            return listATMs
        }

    }
}