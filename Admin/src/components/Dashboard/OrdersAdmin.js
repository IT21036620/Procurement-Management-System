import React, { useState, useEffect } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
import useAuth from '../../hooks/useAuth'
import * as XLSX from 'xlsx'

export default function OrdersAdmin() {
  const [items, SetItems] = useState([])
  const { auth } = useAuth()

  useEffect(() => {
    function getItems() {
      axios
        .get('http://localhost:4000/api/v1/items')
        .then((res) => {
          SetItems(res.data.items)
        })
        .catch((err) => {
          alert(err.message)
        })
    }

    getItems()
  }, [])

  const handleRemoveItem = (itemId) => {
    const confirmDelete = window.confirm(
      'Are you sure you want to remove this item?'
    )
    if (confirmDelete) {
      axios
        .delete(`http://localhost:4000/api/v1/items/${itemId}`)
        .then((res) => {
          console.log(res.data.message)
        })
        .catch((err) => {
          alert(err.message)
        })
    }
  }

  const exportToExcel = () => {
    const ws = XLSX.utils.json_to_sheet(items)
    const wb = XLSX.utils.book_new()
    XLSX.utils.book_append_sheet(wb, ws, 'Items')
    XLSX.writeFile(wb, 'items.xlsx')
  }

  return (
    <div className="p-10 bg-gray-100 min-h-screen">
      <header className="flex justify-between items-center">
        <h1 className="text-3xl font-semibold">Admin Dashboard</h1>
        <div className="flex items-center space-x-4">
          <div className="bg-white p-3 rounded-full">
            <img src="/path-to-bell-icon.svg" alt="Notifications" />
          </div>
          <div className="flex items-center space-x-2">
            <img
              src="/path-to-profile-picture.jpg"
              alt="Profile"
              className="w-8 h-8 rounded-full"
            />
            <span>My profile</span>
          </div>
        </div>
      </header>

      <section className="mt-8 grid grid-cols-1 lg:grid-cols-3 gap-6">
        <div className="bg-white p-6 rounded-lg">
          <h2 className="font-medium text-lg mb-4">Requests</h2>
          <div className="text-2xl mb-4">Total Requests - 10</div>
          <div className="text-gray-600">Next Project: Dec 1, 2023</div>
          <button className="mt-4 px-6 py-2 bg-black text-white rounded-lg">
            View
          </button>
        </div>
      </section>

      <section className="mt-10">
        <h2 className="font-medium text-lg mb-4">Recent orders</h2>
        <table className="w-full bg-white rounded-lg overflow-hidden">
          <thead>
            <tr className="text-left bg-gray-200">
              <th className="p-4">SITE NAME</th>
              <th>MANAGER</th>
              <th>STATUS</th>
              <th>ACTIONS</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td className="p-4">Highway Project</td>
              <td>Sudesh</td>
              <td>
                <span className="bg-red-500 text-white px-2 py-1 rounded-full text-xs">
                  Urgent
                </span>
              </td>
              <td className="flex space-x-4">
                <button className="text-blue-500">View</button>
                <button className="text-blue-500">Download Invoice</button>
              </td>
            </tr>
          </tbody>
        </table>
      </section>
    </div>
  )
}
