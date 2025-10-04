package com.example.lab_week_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // ⬇️ Tambah swipe gesture
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly", "https://cdn2.thecatapi.com/images/7dj.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
                CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator", "https://cdn2.thecatapi.com/images/bar.jpg"),
                CatModel(Gender.Male, CatBreed.ExoticShorthair, "Tomo", "Playful and energetic", "https://cdn2.thecatapi.com/images/c9i.jpg"),
                CatModel(Gender.Female, CatBreed.AmericanCurl, "Udin", "Loves to cuddle", "https://cdn2.thecatapi.com/images/8ls.jpg"),
                CatModel(Gender.Unknown, CatBreed.BalineseJavanese, "Pasep", "Mysterious cat", "https://cdn2.thecatapi.com/images/4es.jpg"),
                CatModel(Gender.Male, CatBreed.ExoticShorthair, "Oscar", "Always hungry", "https://cdn2.thecatapi.com/images/9d5.jpg"),
                CatModel(Gender.Female, CatBreed.AmericanCurl, "Ipul", "Silent observer", "https://cdn2.thecatapi.com/images/btf.jpg"),
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Simba", "The king of the house", "https://cdn2.thecatapi.com/images/6qi.jpg"),
                CatModel(Gender.Unknown, CatBreed.ExoticShorthair, "Jono", "Sleeps all day", "https://cdn2.thecatapi.com/images/12f.jpg")
            )
        )

    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}


