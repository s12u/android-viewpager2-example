package com.tistory.mybstory.android_viewpager2_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var pagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pagerAdapter = PagerAdapter()

        view_pager.apply {
            adapter = pagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    showSnackBar(position)
                }
            })
        }

        fab.setOnClickListener {
            pagerAdapter.addPage()
            view_pager.setCurrentItem(pagerAdapter.itemCount, true)
        }
    }

    fun showSnackBar(pageNum: Int) =
        Snackbar.make(container, "Page $pageNum ;-)", Snackbar.LENGTH_SHORT)
            .apply { setAction("CLOSE") { this.dismiss() } }
            .show()
}
