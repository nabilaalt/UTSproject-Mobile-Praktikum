package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>
    private lateinit var fabAddFood: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menyiapkan data makanan
        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad),
            Food("Cappucino", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cappuchino),
            Food("Mie Goreng", "Mie goreng asli enak dari aceh", R.drawable.mie_goreng),
            Food("Nasi Goreng", "Nasi goreng asli enak dari indonesia", R.drawable.nasigoreng),
            Food("Cireng Isi", "Cireng asli bandung", R.drawable.cireng),
            Food("ChesseCake", "Kue isi keju lapis keju", R.drawable.cheesecake),
            Food("Kopi Hitam", "Kopi hitam asli", R.drawable.kopi_hitam),
            Food("Sparkling Tea", "Tea dengan air sparkling", R.drawable.sparkling_tea),
            Food("Donut", "Donut asli", R.drawable.donut)
        )

        // Inisialisasi adapter dan set ke RecyclerView
        adapter = FoodAdapter(foodList)
        recyclerView.adapter = adapter

        // Inisialisasi Floating Action Button
        fabAddFood = findViewById(R.id.fabAddFood) // Pastikan ID ini ada di XML

        // Menangani klik pada FAB
        fabAddFood.setOnClickListener {
            // Logika untuk menambah makanan, misalnya membuka activity baru
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }

        // Mengatur padding untuk sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
