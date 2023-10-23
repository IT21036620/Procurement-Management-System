import React from 'react'
import { Link } from 'react-router-dom'

export default function SiteManagerProfileM() {
  return (
    <div className="p-8 bg-gray-100 h-screen">
      <h1 className="text-2xl font-bold mb-6">
        Site Manager Profile Management
      </h1>

      <div className="mb-4 flex justify-between items-center">
        <div className="flex gap-4 items-center">
          <label htmlFor="entries" className="text-gray-600">
            Show
          </label>
          <select id="entries" className="border rounded p-2">
            <option value="10">10</option>
          </select>
          <span className="text-gray-600">entries</span>
        </div>
        <div className="relative">
          <input
            type="text"
            className="border rounded p-2"
            placeholder="Search..."
          />
        </div>
      </div>

      <table className="w-full bg-white rounded shadow-md border-collapse">
        <thead>
          <tr className="text-gray-600 border-b">
            <th className="p-4">ID</th>
            <th className="p-4">Category</th>
            <th className="p-4">Name</th>
            <th className="p-4">Date Started</th>
            <th className="p-4">Working Site</th>
            <th className="p-4">Current Orders Placed</th>
            <th className="p-4">Action</th>
          </tr>
        </thead>
        <tbody>
          {/* Sample row data */}
          <tr className="border-b hover:bg-gray-100">
            <td className="p-4">#20462</td>
            <td className="p-4">Construction</td>
            <td className="p-4">Matt Dickerson</td>
            <td className="p-4">13/05/2023</td>
            <td className="p-4">Colombo</td>
            <td className="p-4">Transfer Bank</td>
            <td className="p-4 flex gap-2 justify-center">
              {/* Add the actual icons or SVG paths for the actions */}
              <span className="text-indigo-500 cursor-pointer">🔗</span>
              <span className="text-red-500 cursor-pointer">🗑️</span>
            </td>
          </tr>
          {/* Repeat for other rows */}
        </tbody>
      </table>

      <div className="mt-6 flex justify-end">
        <button className="py-2 px-4 bg-indigo-500 text-white rounded-lg shadow-md hover:bg-indigo-600">
          Add New Site
        </button>
      </div>
    </div>
  )
}
