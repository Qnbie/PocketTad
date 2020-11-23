package hu.bme.aut.eo1lg5.pockettad.recyclerview

import android.content.ContentValues
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Switch
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.model.ToDo
import hu.bme.aut.eo1lg5.pockettad.fragments.detail.RequirementDetailFragmentDirections
import hu.bme.aut.eo1lg5.pockettad.fragments.detail.SubjectDetailFragmentDirections
import kotlinx.android.synthetic.main.todolist_listitem.view.*


class ToDoListAdapter: RecyclerView.Adapter<ToDoListAdapter.ViewHolder>() {
    private var toDoList= emptyList<ToDo>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val itemName: TextView = view.findViewById(R.id.itemName)
        val switchDone: Switch = view.findViewById(R.id.switchDone)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.todolist_listitem, parent, false)

        return ViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = toDoList[position]

        holder.itemName.text = currentItem.name
        holder.switchDone.setChecked(currentItem.done)

        holder.itemView.todoListItem.setOnClickListener(View.OnClickListener {
            val action = RequirementDetailFragmentDirections.actionRequirementDetailFragmentToToDoUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
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