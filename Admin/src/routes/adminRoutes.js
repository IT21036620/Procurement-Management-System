import { Routes, Route } from 'react-router-dom'
import Layout from '../pages/Layout'
import Dashboard from '../components/Dashboard/Dashboard'
import SiteManagerProfileM from '../components/Dashboard/SiteManagerProfileM'
import Customers from '../components/Dashboard/AllCustomers'
import Orders from '../components/Dashboard/Orders'
import OrderDetails from '../components/Dashboard/OrderDetails'
import OrdersAdmin from '../components/Dashboard/OrdersAdmin'
import AddNewUser from '../components/Dashboard/AddNewUser'
import RequireAuth from '../components/login/RequireAuth'
import ItemPerformance from '../components/Dashboard/ItemPerformance'

export default function adminRoutes() {
  return (
    <Routes>
      {/* <Route element={<RequireAuth allowedRole={'admin'} />}> */}
      <Route path="/" element={<Layout />}>
        <Route index element={<Dashboard />} />
        <Route path="siteManagerProfileM" element={<SiteManagerProfileM />} />
        <Route path="addNewUser" element={<AddNewUser />} />
        <Route path="OrdersAdmin" element={<OrdersAdmin />} />
        <Route path="customers" element={<Customers />} />
        <Route path="orders" element={<Orders />} />
        <Route path="orderDetails" element={<OrderDetails />} />
        <Route path="iperformance" element={<ItemPerformance />} />
      </Route>
      {/* </Route> */}
    </Routes>
  )
}
