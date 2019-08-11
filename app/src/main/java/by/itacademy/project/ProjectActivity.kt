package by.itacademy.project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.itacademy.project.adapter.Adapter
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class ProjectActivity : Activity(), Adapter.onClickListener {

    private lateinit var recyclerView: RecyclerView
    private var adapter: Adapter? = null
    private lateinit var adView: AdView

    private lateinit var prefsManager: AppPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)

        prefsManager = AppPrefManager(this)

        val listToJson = prefsManager.getUserText()
        val listFromJson = Singleton.listFromJson(listToJson)

        if (listToJson != "[]")
            Singleton.setListNotes(listFromJson)

        /**
        val noteList = NoteList()
        noteList.addNote(Note("1", "text 1", "header 1"))
        noteList.addNote(Note("2", "text 2", "header 2"))
        noteList.addNote(Note("3", "text 3", "header 3"))
        val noteListToJson: String = Gson().toJson(noteList)
        val noteListFromJson: NoteList = Gson().fromJson(noteListToJson, NoteList::class.java)

        println("noteListToJson: $noteListToJson")
        println("noteListFromJson: $noteListToJson")
        **/

        MobileAds.initialize(this)
        adView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.isNestedScrollingEnabled = false
        adapter = Adapter(Singleton.getListNotes(), this)
        recyclerView.adapter = adapter

        findViewById<ImageView>(R.id.addButton).setOnClickListener {
            val intent = Intent(this, NoteEditActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        prefsManager.saveUserText(Singleton.listToJson())
    }

    override fun onResume() {
        super.onResume()
        adapter?.updateList(Singleton.getListNotes())
    }

    override fun onItemClick(item: Note) {
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
        startActivity(NoteDetailsActivity.getIntent(this@ProjectActivity, item.id))
    }
}