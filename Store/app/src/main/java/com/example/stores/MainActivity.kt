package com.example.stores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.stores.databinding.ActivityMainBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var mAdapter: StoreAdapter

    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

       /* mBinding.btnSave.setOnClickListener {
            val store = StoreEntity(name = mBinding.etName.text.toString().trim())
            Thread {
                StoreApplication.database.storeDao().addStore(store)
            }.start()

            mAdapter.add(store)
        }*/

        mBinding.fab.setOnClickListener {launchEditFragment () }
        setupRecyclerView()

    }

    private fun launchEditFragment() {
        val fragment=  EditStoreFragment()

        val fragmentManager = supportFragmentManager

        val fragmentTransaction= fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.containerMain, fragment)

        fragmentTransaction.commit()

        mBinding.fab.hide()
    }

    private fun setupRecyclerView() {
        mAdapter = StoreAdapter(mutableListOf(), this)
        mGridLayout = GridLayoutManager(this, 2)
        getStores()

        mBinding.recylerView.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = mAdapter
        }
    }

    private fun getStores() {
        doAsync {
            val stores = StoreApplication.database.storeDao().getAllStores()

            uiThread {
                mAdapter.setStores(stores)
            }

        }
    }
    /*
    * OnClickListener
    * */


    override fun onClick(storeEntity: StoreEntity) {

    }

    override fun onFavoriteStar(storeEntity: StoreEntity) {
        storeEntity.isFavorite= !storeEntity.isFavorite

        doAsync {
            StoreApplication.database.storeDao().updateStore(storeEntity)
            uiThread {
                mAdapter.update(storeEntity)
            }
        }
    }

    override fun onDeleteStore(storeEntity: StoreEntity) {
       doAsync {
           StoreApplication.database.storeDao().deleteStore(storeEntity)
           uiThread {
               mAdapter.delete(storeEntity)
           }
       }
    }
}