package hu.bme.aut.eo1lg5.pockettad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

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