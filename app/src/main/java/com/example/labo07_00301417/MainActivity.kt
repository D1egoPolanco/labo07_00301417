package com.example.labo07_00301417

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.labo07_00301417.Database.Githubrepo
import com.example.labo07_00301417.viewModels.GitHubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val ViewModel = ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)
        button.setOnClickListener {
            val name = edit.text.toString()
            if (name.isNotEmpty()&& name.isNotBlank()){
                ViewModel.insert(Githubrepo(name))
            }
        }
        ViewModel.getAll().observe(this, Observer { repos ->
            Log.d("Lista de repos", "                   ")
            for (repo in repos){
                Log.d("Listas de repos",repo.name)
            }

        })
    }
}
