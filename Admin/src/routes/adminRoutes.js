import { Routes, Route } from 'react-router-dom'
import Layout from '../pages/Layout'
import Dashboard from '../components/Dashboard/Dashboard'
import SiteManagerProfileM from '../components/Dashboard/SiteManagerProfileM'
import Suppliers from '../components/Dashboard/AllSuppliers'
import Orders from '../components/Dashboard/Orders'
import OrderDetails from '../components/Dashboard/OrderDetails'
import AllProducts from '../components/Dashboard/AllProducts'
import AddNewUser from '../components/Dashboard/AddNewUser'
import RequireAuth from '../components/login/RequireAuth'
import ItemPerformance from '../components/Dashboard/ItemPerformance'
import SiteManagers from '../components/Dashboard/SiteManagers'
import AllSites from '../components/Dashboard/AllSites'

export default function adminRoutes() {
  return (
    <Routes>
      {/* <Route element={<RequireAuth allowedRole={'admin'} />}> */}
      <Route path="/" element={<Layout />}>
        <Route index element={<Dashboard />} />
        <Route path="siteManagerProfileM" element={<SiteManagerProfileM />} />
        <Route path="addNewUser" element={<AddNewUser />} />
        <Route path="AllProducts" element={<AllProducts />} />
        <Route path="suppliers" element={<Suppliers />} />
        <Route path="orders" element={<Orders />} />
        <Route path="orderDetails" element={<OrderDetails />} />
        <Route path="iperformance" element={<ItemPerformance />} />
        <Route path="siteManagers" element={<SiteManagers />} />
        <Route path="allSites" element={<AllSites />} />
      </Route>
      {/* </Route> */}
    </Routes>
  )
}
