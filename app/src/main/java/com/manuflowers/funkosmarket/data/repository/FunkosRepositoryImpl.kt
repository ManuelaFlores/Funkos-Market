package com.manuflowers.funkosmarket.data.repository

import com.manuflowers.funkosmarket.data.local.DataFactory
import com.manuflowers.funkosmarket.data.model.FunkoEntity

class FunkosRepositoryImpl(
    private val dataFactory: DataFactory
) : FunkosRepository {
    override fun getFunkosList(): List<FunkoEntity> {
        return dataFactory.loadData()
    }
}