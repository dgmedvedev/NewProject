package by.itacademy.project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
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
    }

    override fun onItemClick(item: Note) {
        val intent = Intent(this,NoteDetailsActivity::class.java)
        intent.putExtra("id", item.id)
        startActivity(intent)
    }
}