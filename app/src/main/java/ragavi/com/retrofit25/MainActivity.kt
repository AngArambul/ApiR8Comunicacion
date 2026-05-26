package ragavi.com.retrofit25

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnLoad: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Aquí inicializamos las vistas
        recyclerView = findViewById(R.id.recyclerViewWines)
        btnLoad = findViewById(R.id.btnLoad)
        // Configuramos el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        btnLoad.setOnClickListener {
            loadMonsters()
        }
    }
    // Aquí definimos la función loadMonsters
    private fun loadMonsters() {
        RetrofitClient.instance.getMonsters()
            .enqueue(object : Callback<List<Monster>> {

                override fun onResponse(
                    call: Call<List<Monster>>,
                    response: Response<List<Monster>>
                ) {
                    if (response.isSuccessful) {
                        val monsters = response.body() ?: emptyList()
                        // Usamos el nuevo adaptador
                        recyclerView.adapter = MonsterAdapter(monsters)
                    } else {
                        Toast.makeText(this@MainActivity, "Error del servidor: ${response.code()}", Toast.LENGTH_LONG).show()                    }
                }

                override fun onFailure(call: Call<List<Monster>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_LONG).show()
                }
            })
    }
}