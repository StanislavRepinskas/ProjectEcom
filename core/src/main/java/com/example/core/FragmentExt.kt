package com.example.core

import android.app.Application
import androidx.fragment.app.Fragment

fun Fragment.getApplication(): Application = requireActivity().application