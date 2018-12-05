package com.rasanbazar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager

class LoginRegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)

        var vp_LoginRegister = findViewById(R.id.vp_LoginRegister) as ViewPager

        if (vp_LoginRegister != null) {
            val adapter = LRViewPagerAdapter(supportFragmentManager)
            vp_LoginRegister.adapter = adapter
        }
    }
}
