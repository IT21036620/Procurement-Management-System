import React, { useState, useEffect } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
import useAuth from '../../hooks/useAuth'
import * as XLSX from 'xlsx'

export default function ItemPerformance() {
  return (
    <div className="p-8 bg-gray-100 h-screen">
      <h1 className="text-2xl font-bold mb-8">
        Highway Infrastructure - Manage Project
      </h1>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6 bg-white p-6 rounded-lg shadow-md">
        <div>
          <h2 className="font-medium text-lg mb-4">Site Description</h2>
          <p className="mb-6 text-gray-600">
            Lorem ipsum is simply dummy text of the printing and typesetting
            industry. Lorem ipsum is simply dummy text of the printing and
            typesetting industry. Lorem ipsum is simply dummy text of the
            printing and typesetting industry. Lorem ipsum is simply dummy text
            of the printing and typesetting industry. Lorem ipsum is simply
            dummy text of the printing and typesetting industry. Lorem ipsum is
            simply dummy text of the printing and typesetting industry. Lorem
            ipsum is simply dummy text of the printing and typesetting industry.
            Lorem ipsum is simply dummy text of the printing and typesetting
            industry. Lorem ipsum is simply dummy text of the printing and
            typesetting industry. Lorem ipsum is simply dummy text of the
            printing and typesetting industry. Lorem ipsum is simply dummy text
            of the printing and typesetting industry. Lorem ipsum is simply
            dummy text of the printing and typesetting industry.
          </p>

          <img
            src="path_to_image.jpg"
            alt="Site Image"
            className="rounded-lg mb-6"
          />
        </div>

        <div>
          <div className="bg-[#D3D3D3] p-6 rounded-lg w-full mb-4">
            <h3 className="font-medium text-lg mb-4">Current Task</h3>
            <p className="mb-4 text-gray-600">
              For fast-growth scaleups that want to grow by maximizing...
            </p>
            <div className="font-medium text-gray-600">
              Deadline Date: 2019/12/05
            </div>
          </div>
          <div className="mb-4 flex justify-between">
            <span className="font-medium text-gray-600">Site Location</span>
            <span>Colombo</span>
          </div>

          <div className="mb-4 flex justify-between">
            <span className="font-medium text-gray-600">Site Manager</span>
            <span>Sudesh</span>
          </div>

          <div className="mb-4 flex justify-between">
            <span className="font-medium text-gray-600">Start Date</span>
            <span>2019/10/05</span>
          </div>

          <div className="mb-4 flex justify-between">
            <span className="font-medium text-gray-600">Expected End Date</span>
            <span>2025/10/05</span>
          </div>

          <div className="mb-4 flex justify-between">
            <span className="font-medium text-gray-600">
              Total No of Employees
            </span>
            <span>20</span>
          </div>

          <div className="mb-4 flex justify-between">
            <span className="font-medium text-gray-600">
              Total No of Orders Place
            </span>
            <span>50</span>
          </div>

          <div className="mt-6 flex gap-4">
            <button className="py-2 px-4 bg-indigo-500 text-white rounded-lg">
              UPDATE SITE DETAILS
            </button>
            <button className="py-2 px-4 bg-indigo-500 text-white rounded-lg">
              Assign Employees
            </button>
          </div>
        </div>
      </div>
    </div>
  )
}
