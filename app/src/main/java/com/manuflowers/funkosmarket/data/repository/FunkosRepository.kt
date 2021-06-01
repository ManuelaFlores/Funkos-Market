package com.manuflowers.funkosmarket.data.repository

import com.manuflowers.funkosmarket.data.model.FunkoEntity

interface FunkosRepository {
    fun getFunkosList(): List<FunkoEntity>
}