package com.example.coustomui

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mTabs = findViewById<TabLayout>(R.id.tab)
        val mIndicator = findViewById<View>(R.id.indicator)
        val mViewPager = findViewById<ViewPager2>(R.id.viewPager)


        val adapter = TabAdapter(arrayListOf("One", "Two"), supportFragmentManager, this.lifecycle)

        mViewPager.adapter = adapter

        TabLayoutMediator(mTabs, mViewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Jadval"
                1 -> tab.text = "Rejalarim"
            }
        }.attach()

        var indicatorWidth = 0

        mTabs.post {
            indicatorWidth = mTabs.width / mTabs.tabCount

            //Assign new width

            //Assign new width
            val indicatorParams = mIndicator.layoutParams as FrameLayout.LayoutParams
            indicatorParams.width = indicatorWidth
            mIndicator.layoutParams = indicatorParams
        }

        mViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                val params = mIndicator.layoutParams as FrameLayout.LayoutParams

                //Multiply positionOffset with indicatorWidth to get translation

                //Multiply positionOffset with indicatorWidth to get translation
                val translationOffset: Float = (positionOffset + position) * indicatorWidth
                params.leftMargin = translationOffset.toInt()
                mIndicator.layoutParams = params
            }

        })

    }
}