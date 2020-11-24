package hu.bme.aut.eo1lg5.pockettad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import hu.bme.aut.eo1lg5.pockettad.fragments.lists.IncomingRequirementListFragment
import hu.bme.aut.eo1lg5.pockettad.fragments.lists.IncomingToDoListFragment
import hu.bme.aut.eo1lg5.pockettad.fragments.lists.SubjectListFragment
import kotlinx.android.synthetic.main.activity_subject_list.*

class SubjectListActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_list)

        setupActionBarWithNavController(findNavController(R.id.mainFragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.mainFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}