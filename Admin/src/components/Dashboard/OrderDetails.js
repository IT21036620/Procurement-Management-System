import React, { useState, useEffect } from 'react'
import axios from 'axios'
import useAuth from '../../hooks/useAuth'
import * as XLSX from 'xlsx'

export default function OrderDetails() {
  const projects = [
    {
      name: 'ABC Silva Hardware',
      totalCost: '76,500.00',
      discount: '1,500.00',
      grossTotal: '75,000.00',
    },
    {
      name: 'Ranga Hardware',
      totalCost: '168,000.00',
      discount: '3,000.00',
      grossTotal: '165,000.00',
    },
    {
      name: 'Edirisingha Hardware',
      totalCost: '35,000.00',
      discount: '0.00',
      grossTotal: '35,000.00',
    },
  ]

  return (
    <div className="bg-gray-100 h-screen flex flex-col items-center mb-4">
      <h1 className="text-2xl font-bold mb-8">
        Highway Infrastructure Project
      </h1>
      {projects.map((project, index) => (
        <div
          key={index}
          className="bg-white p-6 mb-4 w-3/4 rounded shadow-md flex flex-col"
        >
          <h2 className="font-semibold text-xl mb-4">{project.name}</h2>

          <div className="flex justify-between">
            <span>Total Cost</span>
            <span>{project.totalCost}</span>
          </div>
          <div className="flex justify-between">
            <span>Discount</span>
            <span>{project.discount}</span>
          </div>
          <div className="flex justify-between  font-semibold">
            <span>Gross Total</span>
            <span>{project.grossTotal}</span>
          </div>
          <button className="bg-red-500 w-96 text-white py-2  rounded">
            VIEW GRN
          </button>
        </div>
      ))}

      <div className="bg-white p-6 w-3/4 rounded shadow-md flex justify-between mb-4">
        <span className="font-semibold text-xl">Total Cost</span>
        <span className="font-semibold text-xl">275,000.00</span>
      </div>

      <button className="bg-blue-600 text-white py-2 px-4 mb-4 rounded-lg">
        NOTIFY ADMIN FOR APPROVAL
      </button>
      <button className="bg-green-600 text-white py-2 px-4 mb-8 rounded-lg">
        APPROVE
      </button>
    </div>
  )
}
