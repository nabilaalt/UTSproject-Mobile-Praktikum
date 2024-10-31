package lat.pam.utsproject

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    private lateinit var tvFoodName: TextView
    private lateinit var tvServings: TextView
    private lateinit var tvOrdererName: TextView
    private lateinit var tvNotes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        // Menghubungkan variabel dengan view
        tvFoodName = findViewById(R.id.tvFoodName)
        tvServings = findViewById(R.id.tvServings)
        tvOrdererName = findViewById(R.id.tvOrdererName)
        tvNotes = findViewById(R.id.tvNotes)

        // Mengambil data dari Intent
        val foodName = intent.getStringExtra("food_name") ?: "No Food Name"
        val servings = intent.getStringExtra("servings") ?: "0 pax"
        val ordererName = intent.getStringExtra("orderer_name") ?: "Unknown"
        val notes = intent.getStringExtra("notes") ?: "No Additional Notes"

        // Menampilkan data ke TextView
        tvFoodName.text = "Food Name: $foodName"
        tvServings.text = "Number of Servings: $servings"
        tvOrdererName.text = "Ordering Name: $ordererName"
        tvNotes.text = "Additional Notes: $notes"

        // Set listener untuk tombol back to menu
        findViewById<Button>(R.id.backtoMenu).setOnClickListener {
            finish() // Kembali ke Activity sebelumnya
        }
    }
}
