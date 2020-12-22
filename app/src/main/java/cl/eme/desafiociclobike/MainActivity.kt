package cl.eme.desafiociclobike

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import cl.eme.desafiociclobike.databinding.ActivityMainBinding

/*
[X] 1. Crear el proyecto Android de cero, compatible con Kotlin.
[X] 2. Convertir las clases Java que vienen de recursos en el proyecto a clases Kotlin.
[X] 3. Crear las listas en base a las clases entregadas para comenzar el proyecto.
[] 4. Crear una interfaz gráfica que cumpla con los requerimientos.
[] 5. Hacer un buen uso del null safety mientras se desarrolla el proyecto.
[] 6. Crear el filtro especificado usando la sentencia when.
 */



class MainActivity : AppCompatActivity() {
    val cicloviaAdapter = CicloviaAdapter()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvLista.adapter = cicloviaAdapter
        binding.rvLista.layoutManager = LinearLayoutManager(this)
        binding.btFiltrar.setOnClickListener {
            Log.d(TAG, "onCreate: Haciendo click en filtrar")
            cicloviaAdapter.updateAdapterFilter()
        }
        binding.btLista.setOnClickListener {
            Log.d(TAG, "onCreate: Haciendo click en filtrar")
            cicloviaAdapter.updateAdapterNoFilter()
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}