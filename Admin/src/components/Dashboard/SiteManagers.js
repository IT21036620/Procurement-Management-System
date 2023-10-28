import React, { useState, useEffect } from 'react'
import axios from 'axios'
import useAuth from '../../hooks/useAuth'
import * as XLSX from 'xlsx'

export default function SiteManagers() {
  const [siteManagers, setSiteManagers] = useState([])
  const [isModalOpen, setIsModalOpen] = useState(false)
  const [newManager, setNewManager] = useState({
    userName: '',
    employeeCode: '',
    email: '',
    contactNo: '',
    role: '',
  })
  const { auth } = useAuth()

  useEffect(() => {
    getSiteManagers()
  }, [])

  const getSiteManagers = () => {
    axios
      .get('http://localhost:4000/site/site-manager')
      .then((res) => {
        setSiteManagers(res.data.result)
      })
      .catch((err) => {
        alert(err.message)
      })
  }

  const handleChange = (e) => {
    const { name, value } = e.target
    setNewManager((prev) => ({ ...prev, [name]: value }))
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    axios
      .post('http://localhost:4000/site/site-manager', newManager)
      .then(() => {
        setIsModalOpen(false)
        getSiteManagers()
      })
      .catch((err) => {
        alert(err.message)
      })
  }

  const deleteManager = (id) => {
    if (window.confirm('Are you sure you want to delete this manager?')) {
      axios
        .delete(`http://localhost:4000/site/site-manager/${id}`)
        .then(() => {
          alert('Site Manager deleted successfully')
          getSiteManagers()
        })
        .catch((err) => {
          alert(err.message)
        })
    }
  }

  const exportToExcel = () => {
    const ws = XLSX.utils.json_to_sheet(siteManagers)
    const wb = XLSX.utils.book_new()
    XLSX.utils.book_append_sheet(wb, ws, 'SiteManagers')
    XLSX.writeFile(wb, 'SiteManagers.xlsx')
  }

  const renderModal = () => (
    <div className="fixed inset-0 flex items-center justify-center z-50 bg-gray-800 bg-opacity-50">
      <div className="bg-white p-8 rounded-md shadow-xl w-1/3">
        <h2 className="text-2xl mb-4">Add New Site Manager</h2>
        <form onSubmit={handleSubmit} className="space-y-4">
          <input
            name="userName"
            placeholder="Name"
            onChange={handleChange}
            className="w-full p-2 border rounded"
          />
          <input
            name="employeeCode"
            placeholder="Employee Code"
            onChange={handleChange}
            className="w-full p-2 border rounded"
          />
          <input
            name="email"
            placeholder="Email"
            onChange={handleChange}
            className="w-full p-2 border rounded"
          />
          <input
            name="contactNo"
            placeholder="Contact Number"
            onChange={handleChange}
            className="w-full p-2 border rounded"
          />
          <input
            name="role"
            placeholder="Role"
            onChange={handleChange}
            className="w-full p-2 border rounded"
          />
          <div className="flex justify-end space-x-2">
            <button
              type="submit"
              className="px-4 py-2 bg-green-500 text-white rounded"
            >
              Add
            </button>
            <button
              type="button"
              onClick={() => setIsModalOpen(false)}
              className="px-4 py-2 bg-red-500 text-white rounded"
            >
              Cancel
            </button>
          </div>
        </form>
      </div>
    </div>
  )

  return (
    <div className="bg-white px-4 pt-3 pb-4 rounded-sm border border-gray-200 flex-1">
      <div className="flex justify-between items-center">
        <strong className="text-gray-700 font-medium">All Site Managers</strong>
        <button
          onClick={() => setIsModalOpen(true)}
          className="bg-green-500 text-white px-4 py-2 rounded"
        >
          Add New Manager
        </button>
        <button
          onClick={exportToExcel}
          className="bg-blue-500 text-white px-4 py-2 rounded"
        >
          Export
        </button>
      </div>

      {isModalOpen && renderModal()}

      <div className="border-x border-gray-200 rounded-sm mt-3">
        <table className="w-full text-gray-700">
          <thead>
            <tr>
              <th>ID</th>
              <th>First Name</th>
              <th>Employee Code</th>
              <th>Email</th>
              <th>Contact Number</th>
              <th>Role</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {siteManagers.map((manager) => (
              <tr key={manager.id}>
                <td>{manager.id}</td>
                <td>{manager.userName}</td>
                <td>{manager.employeeCode}</td>
                <td>{manager.email}</td>
                <td>{manager.contactNo}</td>
                <td>{manager.role}</td>
                <td>
                  <button
                    onClick={() => deleteManager(manager.id)}
                    className="bg-red-500 text-white px-2 py-1 rounded"
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  )
}
