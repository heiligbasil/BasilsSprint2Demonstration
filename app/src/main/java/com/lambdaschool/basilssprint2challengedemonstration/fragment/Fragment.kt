package com.lambdaschool.basilssprint2challengedemonstration.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lambdaschool.basilssprint2challengedemonstration.R

class Fragment : androidx.fragment.app.Fragment() {

    // FEATURE: Fragment #1 (XML)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment1, container, false)
    }
}

