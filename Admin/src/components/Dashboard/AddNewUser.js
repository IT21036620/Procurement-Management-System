import React from 'react'
import { Link } from 'react-router-dom'

export default function AddNewUser() {
  return (
    <div className="bg-gray-100 h-screen flex justify-center items-center">
      <div className="bg-white p-8 w-96 rounded shadow-lg">
        <h2 className="text-2xl font-bold mb-6 text-center">
          Add New User Profile
        </h2>

        <div className="flex justify-center mb-4">
          <div className="w-24 h-24 bg-gray-300 rounded-full flex items-center justify-center">
            <span className="text-4xl text-white">👤</span>
          </div>
        </div>

        <div className="mb-4">
          <label className="block text-gray-700 mb-2">Employee Name</label>
          <div className="flex gap-4">
            <input
              type="text"
              placeholder="First Name"
              className="border rounded p-2 w-1/2"
            />
            <input
              type="text"
              placeholder="Last Name"
              className="border rounded p-2 w-1/2"
            />
          </div>
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 mb-2">User Name</label>
          <input
            type="text"
            placeholder="User Name"
            className="border rounded p-2 w-full"
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 mb-2">Password</label>
          <input
            type="password"
            placeholder="Password"
            className="border rounded p-2 w-full"
          />
        </div>
        <div className="mb-4">
          <label className="block text-gray-700 mb-2">User Role</label>
          <select className="border rounded p-2 w-full">
            <option>Site Manager</option>
          </select>
        </div>

        <div className="mb-6">
          <input type="checkbox" id="agreement" className="mr-2" />
          <label htmlFor="agreement" className="text-gray-700 text-sm">
            By Creating this account, you agree to our terms and have read and
            acknowledge the Privacy Statement.
          </label>
        </div>

        <button className="w-full py-2 bg-blue-600 text-white rounded-lg shadow-md hover:bg-blue-700">
          Add User
        </button>
      </div>
    </div>
  )
}
