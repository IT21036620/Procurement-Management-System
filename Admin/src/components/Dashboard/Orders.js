import React, { useState, useEffect } from 'react'
import axios from 'axios'
import useAuth from '../../hooks/useAuth'
import * as XLSX from 'xlsx'

export default function Orders() {
  const [orders, setOrders] = useState([])

  useEffect(() => {
    fetchOrders()
  }, [])

  const fetchOrders = () => {
    axios
      .get('http://localhost:4000/order/requisition')
      .then((res) => {
        console.log(res.data.result)
        setOrders(res.data.result)
      })
      .catch((err) => {
        alert(err.message)
      })
  }

  const updateOrderStatus = (orderId, newStatus) => {
    axios
      .patch('http://localhost:4000/order/requisition', {
        id: 1,
        status: 'test',
      })
      .then(() => {
        // Update the order status in the state
        setOrders(
          orders.map((order) =>
            order.id === orderId ? { ...order, status: newStatus } : order
          )
        )
      })
      .catch((err) => {
        alert(err.message)
      })
  }

  return (
    <section className="mt-10">
      <h2 className="font-medium text-lg mb-4">Order Requests</h2>
      <table className="w-full bg-white rounded-lg overflow-hidden">
        <thead>
          <tr className="text-left bg-gray-200">
            <th className="p-4">ID</th>
            <th>DETAILS</th>
            <th>ORDER DATE & TIME</th>
            <th>reqOrdNo</th>
            <th>STATUS</th>
            <th>ACTIONS</th>
          </tr>
        </thead>
        <tbody>
          {orders.map((order) => (
            <tr key={order.id}>
              <td>{order.id}</td>
              <td>{order.details}</td>
              <td>{order.createdDate}</td>
              <td>{order.reqOrdNo}</td>
              <td>
                <span
                  className={`px-2 py-1 rounded-full text-xs ${
                    order.status === 'Accepted'
                      ? 'bg-green-500 text-white'
                      : order.status === 'Rejected'
                      ? 'bg-red-500 text-white'
                      : 'bg-yellow-500 text-white'
                  }`}
                >
                  {order.status}
                </span>
              </td>
              <td className="flex space-x-4">
                <button
                  className="text-green-500"
                  onClick={() => updateOrderStatus(order.id, 'Accepted')}
                >
                  Accept
                </button>
                <button
                  className="text-red-500"
                  onClick={() => updateOrderStatus(order.id, 'Rejected')}
                >
                  Reject
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </section>
  )
}
