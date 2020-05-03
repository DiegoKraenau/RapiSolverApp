package com.example.rapisolverapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.rapisolverapp.Fragments.BuscarProveedorFragment
import com.example.rapisolverapp.Fragments.BuscarServicioFragment
import com.example.rapisolverapp.Fragments.MiPerfilFragment
import com.example.rapisolverapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_pantalla_principal.*

class PantallaPrincipal : AppCompatActivity() {

    companion object {
        var userId:Int = 0
    }

    lateinit var miperfilFragment:MiPerfilFragment
    lateinit var buscarserviciosFragment:BuscarServicioFragment
    lateinit var buscarproveedorFragment:BuscarProveedorFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)

        val bottonNavigationView: BottomNavigationView= findViewById(R.id.btm_nav)

        miperfilFragment= MiPerfilFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout,miperfilFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        bottonNavigationView.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.MiPerfil->{
                    miperfilFragment= MiPerfilFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,miperfilFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.BuscarServicio->{
                    buscarserviciosFragment= BuscarServicioFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,buscarserviciosFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.BuscarProveedor->{
                    buscarproveedorFragment= BuscarProveedorFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,buscarproveedorFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
            }
            true
        }

        Toask()

    }

    private fun Toask() {
        Toast.makeText(this@PantallaPrincipal, LogueoActivity.toask,Toast.LENGTH_SHORT).show()
    }
}
