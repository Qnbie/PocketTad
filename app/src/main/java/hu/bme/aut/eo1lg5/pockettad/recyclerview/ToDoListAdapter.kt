package hu.bme.aut.eo1lg5.pockettad.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.TextView
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.eo1lg5.pockettad.R
import hu.bme.aut.eo1lg5.pockettad.database.model.ToDo
import hu.bme.aut.eo1lg5.pockettad.database.viewmodel.ToDoViewModel
import hu.bme.aut.eo1lg5.pockettad.fragments.detail.RequirementDetailFragmentDirections
import hu.bme.aut.eo1lg5.pockettad.fragments.lists.IncomingToDoListFragmentDirections
import kotlinx.android.synthetic.main.todolist_listitem.view.*


class ToDoListAdapter: RecyclerView.Adapter<ToDoListAdapter.ViewHolder>() {
    private var toDoList= emptyList<ToDo>()
    private lateinit var todoViewModel: ToDoViewModel
    private var incoming  = false

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val deadLineText: TextView = view.findViewById(R.id.deadLineText)
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
        holder.deadLineText.text = currentItem.deadLine

        holder.itemView.todoListItem.setOnClickListener(View.OnClickListener {
            val action:NavDirections

            if(incoming) action = IncomingToDoListFragmentDirections.actionIncomingToDoListFragmentToToDoUpdateFragment(currentItem)
            else action = RequirementDetailFragmentDirections.actionRequirementDetailFragmentToToDoUpdateFragment(currentItem)

            holder.itemView.findNavController().navigate(action)
        })

        holder.switchDone.setOnCheckedChangeListener{ compoundButton: CompoundButton, b: Boolean ->
            val updatedItem = currentItem
            updatedItem.done = b
            todoViewModel.updateToDo(updatedItem)
        }

    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    fun setToDoList(
        toDo: List<ToDo>,
        todoViewModel: ToDoViewModel,
        incoming: Boolean
    ){
        this.todoViewModel = todoViewModel
        this.incoming = incoming
        toDoList = toDo
        notifyDataSetChanged()
    }
}