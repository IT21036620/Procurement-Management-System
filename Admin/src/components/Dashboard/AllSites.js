import React, { useState, useEffect } from 'react'
import { format } from 'date-fns'
import { Link } from 'react-router-dom'
import axios from 'axios'
import useAuth from '../../hooks/useAuth'
import * as XLSX from 'xlsx'

export default function AllSites() {
  const [suppliers, SetSuppliers] = useState([])
  const { auth } = useAuth()

  useEffect(() => {
    function getSuppliers() {
      axios
        .get('http://localhost:4000/site')
        .then((res) => {
          console.log(res.data.result)
          SetSuppliers(res.data.result)
        })
        .catch((err) => {
          alert(err.message)
        })
    }

    getSuppliers()
  }, [suppliers])

  const exportToExcel = () => {
    const ws = XLSX.utils.json_to_sheet(suppliers)
    const wb = XLSX.utils.book_new()
    XLSX.utils.book_append_sheet(wb, ws, 'Suppliers')
    XLSX.writeFile(wb, 'Suppliers.xlsx')
  }

  return (
    <div className="bg-white px-4 pt-3 pb-4 rounded-sm border border-gray-200 flex-1">
      <div className="flex justify-between items-center">
        <strong className="text-gray-700 font-medium">All Sites</strong>

        <button
          onClick={exportToExcel}
          className="bg-blue-500 text-white px-4 py-2 rounded "
        >
          Export
        </button>
      </div>

      <div className="border-x border-gray-200 rounded-sm mt-3">
        <table className="w-full text-gray-700">
          <thead>
            <tr>
              <th>ID</th>
              <th>Site Name</th>
              <th>Location</th>
              <th>Site Contact No</th>
              <th>Site Manager Name</th>
              <th>Site Manager Employee Code</th>
            </tr>
          </thead>
          <tbody>
            {suppliers.map((supplier) => (
              <tr key={supplier.id}>
                <td>{supplier.id}</td>
                <td>{supplier.siteName}</td>
                <td>{supplier.location}</td>
                <td>{supplier.siteContactNo}</td>
                <td>{supplier.siteManager.userName}</td>
                <td>{supplier.siteManager.employeeCode}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  )
}
