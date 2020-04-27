package com.example.rapisolverapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.rapisolverapp.Fragments.BuscarServicioFragment
import com.example.rapisolverapp.Models.ServiceDetail
import com.example.rapisolverapp.Models.User
import com.example.rapisolverapp.R
import com.example.rapisolverapp.Services.ServiceDetailService
import com.example.rapisolverapp.Services.UserService
import kotlinx.android.synthetic.main.activity_logueo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LogueoActivity : AppCompatActivity() {

    companion object {
        var listaUsuarios= ArrayList<User>()
        var listaServiceDeatil=ArrayList<ServiceDetail>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logueo)
        cargarUsuarios()
        cargarServicesDetails()
        btnIngresar.setOnClickListener {
            loguear()
        }
    }

    private fun cargarServicesDetails() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rapisolverprueba.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val serviceDeatilService: ServiceDetailService

        serviceDeatilService=retrofit.create(ServiceDetailService::class.java)

        val request=serviceDeatilService.getServiceDeatils("json")

        request.enqueue(object :Callback<ArrayList<ServiceDetail>>{
            override fun onFailure(call: Call<ArrayList<ServiceDetail>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<ArrayList<ServiceDetail>>,
                response: Response<ArrayList<ServiceDetail>>
            ) {
                if (response.isSuccessful) {

                    listaServiceDeatil =response.body()!!
                }
            }

        })
    }

    private fun cargarUsuarios() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rapisolverprueba.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val userService:UserService

        userService=retrofit.create(UserService::class.java)

        val request=userService.getUsers("json")

        request.enqueue(object : Callback<ArrayList<User>>{
            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<ArrayList<User>>,
                response: Response<ArrayList<User>>
            ) {
                if (response.isSuccessful) {

                    listaUsuarios=response.body()!!
                }
            }


        })
    }

    private fun loguear() {

        var con:Int=0
        for (user in listaUsuarios!!){
            if(user.userName==inputCorreo.text.toString() && user.userPassword==inputContraseña.text.toString() ){
                PantallaPrincipal.userId=user.usuarioId
                con=con+1

            }
        }





        //Toast.makeText(this@LogueoActivity, listaUsuarios!!.size.toString(),Toast.LENGTH_SHORT).show()

        if(con==1){

            val intent = Intent(this@LogueoActivity,PantallaPrincipal::class.java)
            startActivity(intent)
        }
        else{
            Toast.makeText(this@LogueoActivity,"Usuario o contraseña incorrecta",Toast.LENGTH_SHORT).show()
        }




    }
}