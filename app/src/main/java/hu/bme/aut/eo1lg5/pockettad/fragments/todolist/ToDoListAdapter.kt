package hu.bme.aut.eo1lg5.pockettad.fragments.todolist

import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.model.Subject
import hu.bme.aut.eo1lg5.pockettad.database.model.ToDo
import hu.bme.aut.eo1lg5.pockettad.fragments.subjectlist.SubjectListAdapter

class ToDoListAdapter: RecyclerView.Adapter<ToDoListAdapter.ViewHolder>() {
    private var toDoList= emptyList<ToDo>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val itemName: TextView = view.findViewById(R.id.itemName)
        val parentLayout: RelativeLayout = view.findViewById(R.id.baseLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.todolist_listitem, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = toDoList[position]
        holder.itemName.text = currentItem.name.toString()

        holder.parentLayout.setOnClickListener(View.OnClickListener {
            Log.d(ContentValues.TAG, "Cilck on ${toDoList.get(position).toString()}")
            //TODO move to another activity
        })
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    fun setToDoList(toDo: List<ToDo>){
        toDoList = toDo
        notifyDataSetChanged()
    }
}