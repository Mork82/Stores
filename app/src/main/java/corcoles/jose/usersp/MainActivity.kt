package corcoles.jose.usersp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import corcoles.jose.usersp.databinding.ActivityMainBinding
import java.text.ParsePosition

class MainActivity : AppCompatActivity(),OnClickListener {
    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter=UserAdapter(getUsers(), this)

        linearLayoutManager=LinearLayoutManager(this)

        binding.recylerView.apply {
            setHasFixedSize(true)
            layoutManager=linearLayoutManager
            adapter=userAdapter
        }
    }

    private fun getUsers():MutableList<User>{
        val user= mutableListOf<User>()

        val jose = User(1,"Jose","Corcoles","https://i.blogs.es/24bcec/the-batman-affleck/840_560.jpg")
        val miguel= User(2,"Miguel","Garcia","https://static-ms.elcorreo.com/wp-content/uploads/sites/4/2018/07/miguel-garcia.jpg")
        val vicky = User(3,"Victoria","Corcoles","https://media-exp1.licdn.com/dms/image/C5603AQHV-tSiUNOHXw/profile-displayphoto-shrink_200_200/0?e=1612396800&v=beta&t=QJfqjC6U-HW668G_CzUzxl0Z-ySstkMJV7aNthb-QTw")

        user.add(jose)
        user.add(miguel)
        user.add(vicky)
        user.add(jose)
        user.add(miguel)
        user.add(vicky)
        user.add(jose)
        user.add(miguel)
        user.add(vicky)
        user.add(jose)
        user.add(miguel)
        user.add(vicky)
        user.add(jose)
        user.add(miguel)
        user.add(vicky)

        return user
    }

    override fun onClick(user: User,position: Int) {
        Toast.makeText(this,"$position: ${user.getFullName()}" ,Toast.LENGTH_LONG).show()
    }
}