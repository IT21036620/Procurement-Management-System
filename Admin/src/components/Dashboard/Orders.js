import React, { useState, useEffect } from 'react'
import axios from 'axios'
import useAuth from '../../hooks/useAuth'
import * as XLSX from 'xlsx'

export default function Orders() {
  // const [orders, SetOrders] = useState([])

  // useEffect(() => {
  //   function getOrders() {
  //     axios
  //       .get('http://localhost:4000/api/v1/order')
  //       .then((res) => {
  //         SetOrders(res.data.orders)
  //       })
  //       .catch((err) => {
  //         alert(err.message)
  //       })
  //   }

  //   getOrders()
  // }, [])

  // const handleRemoveItem = (itemId) => {
  //   const confirmDelete = window.confirm(
  //     'Are you sure you want to remove this item?'
  //   )
  //   if (confirmDelete) {
  //     axios
  //       .delete(`http://localhost:4000/api/v1/items/${itemId}`)
  //       .then((res) => {
  //         console.log(res.data.message)
  //       })
  //       .catch((err) => {
  //         alert(err.message)
  //       })
  //   }
  // }

  // const exportToExcel = () => {
  //   const ws = XLSX.utils.json_to_sheet(items)
  //   const wb = XLSX.utils.book_new()
  //   XLSX.utils.book_append_sheet(wb, ws, 'Items')
  //   XLSX.writeFile(wb, 'items.xlsx')
  // }

  return (
    // <div className="bg-white px-4 pt-3 pb-4 rounded-sm border border-gray-200 flex-1">
    //   <div className="flex justify-between items-center">
    //     <strong className="text-gray-700 font-medium">All Orders</strong>

    //     <button
    //       onClick={exportToExcel}
    //       className="bg-blue-500 text-white px-4 py-2 rounded "
    //     >
    //       Export
    //     </button>
    //   </div>
    //   <div className="border-x border-gray-200 rounded-sm mt-3">
    //     <table className="w-full text-gray-700">
    //       <thead>
    //         <tr>
    //           <th>Order ID</th>
    //           <th>Customer ID</th>
    //           <th>Product Names</th>
    //           <th>Quantity</th>
    //           <th>Total Price</th>
    //         </tr>
    //       </thead>
    //       <tbody>
    //         {orders.map((order) => (
    //           <tr key={order._id}>
    //             <td>{order._id}</td>
    //             <td>{order.customer._id}</td>
    //             <td>
    //               {order.cartComplete.items
    //                 .map((item) => item.item.item_name)
    //                 .join(', ')}
    //             </td>
    //             <td>
    //               {order.cartComplete.items
    //                 .map((item) => item.quantity)
    //                 .join(', ')}
    //             </td>
    //             <td>{order.cartComplete.totalprice}</td>
    //           </tr>
    //         ))}
    //       </tbody>
    //     </table>
    //   </div>
    // </div>

    <section className="mt-10">
      <h2 className="font-medium text-lg mb-4">Orders</h2>
      <table className="w-full bg-white rounded-lg overflow-hidden">
        <thead>
          <tr className="text-left bg-gray-200">
            <th className="p-4">SITE NAME</th>
            <th>LOCATION</th>
            <th>START DATE</th>
            <th>CATEGORY</th>
            <th>STATUS</th>
            <th>ACTIONS</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td className="p-4">Highway Project</td>
            <td>Colombo</td>
            <td>2021/10/15</td>
            <td>Road Construction</td>
            <td>
              <span className="bg-red-500 text-white px-2 py-1 rounded-full text-xs">
                Urgent
              </span>
            </td>
            <td className="flex space-x-4">
              <button className="text-blue-500">View</button>
            </td>
          </tr>
        </tbody>
      </table>
    </section>
  )
}
