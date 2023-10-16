import React from 'react'
import { Routes, Route, BrowserRouter } from 'react-router-dom'
import AdminRoutes from './adminRoutes'
import LoginRoutes from './loginRoutes'

const IndexRoutes = () => {
  return (
    <div>
      <AdminRoutes />

      <LoginRoutes />

      {/* <ErrorRoute /> */}
    </div>
  )
}

export default IndexRoutes
