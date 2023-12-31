import React, { useState, useEffect } from 'react'
import axios from 'axios'
import * as XLSX from 'xlsx'

export default function AllProducts() {
  const [products, SetProducts] = useState([])
  const [isModalOpen, setIsModalOpen] = useState(false)
  const [suppliers, setSuppliers] = useState([])
  const [newProduct, setNewProduct] = useState({
    name: '',
    description: '',
    price: '',
    supplier: '',
  })

  useEffect(() => {
    // Fetch products
    axios
      .get('http://localhost:4000/item')
      .then((res) => {
        SetProducts(res.data.result)
      })
      .catch((err) => {
        alert(err.message)
      })

    // Fetch suppliers
    axios
      .get('http://localhost:4000/item/supplier')
      .then((res) => {
        setSuppliers(res.data.result)
      })
      .catch((err) => {
        alert(err.message)
      })
  }, [])

  const addProduct = (product) => {
    axios
      .post('http://localhost:4000/item', product)
      .then(() => {
        getProducts()
      })
      .catch((err) => {
        alert(err.message)
      })
  }

  const handleChange = (e) => {
    const { name, value } = e.target
    setNewProduct((prev) => ({ ...prev, [name]: value }))
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    addProduct(newProduct)
    setIsModalOpen(false)
  }

  const exportToExcel = () => {
    const ws = XLSX.utils.json_to_sheet(products)
    const wb = XLSX.utils.book_new()
    XLSX.utils.book_append_sheet(wb, ws, 'Products')
    XLSX.writeFile(wb, 'Products.xlsx')
  }

  return (
    <div className="bg-white px-4 pt-3 pb-4 rounded-sm border border-gray-200 flex-1">
      {isModalOpen && (
        <div className="fixed inset-0 flex items-center justify-center z-50 bg-gray-800 bg-opacity-50">
          <div className="bg-white p-8 rounded-md shadow-xl w-1/3">
            <h2 className="text-2xl mb-4">Add New Product</h2>
            <form onSubmit={handleSubmit} className="space-y-4">
              <input
                name="name"
                placeholder="Product Name"
                onChange={handleChange}
                className="w-full p-2 border rounded"
              />
              <input
                name="description"
                placeholder="Product Description"
                onChange={handleChange}
                className="w-full p-2 border rounded"
              />
              <input
                name="price"
                placeholder="Unit Price"
                onChange={handleChange}
                className="w-full p-2 border rounded"
              />
              <div>
                <label htmlFor="supplierId" className="block mb-2">
                  Supplier ID
                </label>
                <select
                  id="supplierId"
                  name="supplierId"
                  value={newProduct.supplierId}
                  onChange={handleChange}
                  className="w-full p-2 border rounded"
                >
                  <option value="" disabled>
                    Select a supplier
                  </option>
                  {suppliers.map((supplier) => (
                    <option key={supplier.id} value={supplier.id}>
                      {supplier.id}
                    </option>
                  ))}
                </select>
              </div>
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
                  Close
                </button>
              </div>
            </form>
          </div>
        </div>
      )}

      <div className="flex justify-between items-center">
        <strong className="text-gray-700 font-medium">All Products</strong>

        <button
          onClick={() => setIsModalOpen(true)}
          className="bg-green-500 text-white px-4 py-2 rounded "
        >
          Add New Product
        </button>

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
              <th>Item Name</th>
              <th>Description</th>
              <th>Unit Price</th>
              <th>Supplier Name</th>
              <th>Supplier Contact No</th>
            </tr>
          </thead>
          <tbody>
            {products.map((product) => (
              <tr key={product.id}>
                <td>{product.id}</td>
                <td>{product.name}</td>
                <td>{product.description}</td>
                <td>Rs.{product.price}</td>
                <td>{product.supplier.supplierName}</td>
                <td>{product.supplier.contactNo}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  )
}
