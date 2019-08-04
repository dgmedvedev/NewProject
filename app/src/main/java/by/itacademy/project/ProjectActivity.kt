package by.itacademy.project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.itacademy.project.adapter.Adapter

class ProjectActivity : Activity(), Adapter.onClickListener {

    private lateinit var recyclerView: RecyclerView
    private var adapter: Adapter? = null
    /*
        companion object {
            private const val ID_STUDENT = "ID_STUDENT"

            fun getIntent(context: Context, idStudent: Long): Intent {
                val intent = Intent(context, Dz6StudentListActivity::class.java)
                intent.putExtra(ID_STUDENT, idStudent)
                return intent
            }
        }
        */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.isNestedScrollingEnabled = false
        adapter = Adapter(Singleton.getListNotes(), this)
        recyclerView.adapter = adapter

        findViewById<ImageView>(R.id.addButton).setOnClickListener{
            val intent = Intent(this, NoteEditActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter?.updateList(Singleton.getListNotes())
    }
/*
    override fun onItemClick(item: Note) {
        val intent = Intent(this,NoteDetailsActivity::class.java)
        intent.putExtra("id", item.id)
        startActivity(intent)
    }
*/
    override fun onItemClick(item: Note) {
        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
        startActivity(NoteDetailsActivity.getIntent(this@ProjectActivity, item.id))
    }
}