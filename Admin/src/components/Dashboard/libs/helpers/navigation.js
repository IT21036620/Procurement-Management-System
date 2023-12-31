import {
  HiOutlineViewGrid,
  HiOutlineCube,
  HiOutlineShoppingCart,
  HiOutlineUsers,
  HiOutlineDocumentText,
  HiOutlineAnnotation,
  HiOutlineQuestionMarkCircle,
  HiOutlineCog,
} from 'react-icons/hi'

export const DASHBOARD_SIDEBAR_LINKS = [
  {
    key: 'dashboard',
    label: 'Dashboard',
    path: '/',
    icon: <HiOutlineViewGrid />,
  },
  {
    key: 'dashboard',
    label: 'Projects',
    path: '/admin',
    icon: <HiOutlineViewGrid />,
  },
  {
    key: 'products',
    label: 'Products',
    path: '/AllProducts',
    icon: <HiOutlineCube />,
  },
  {
    key: 'orders',
    label: 'Orders',
    path: '/orders',
    icon: <HiOutlineShoppingCart />,
  },
  {
    key: 'customers',
    label: 'Suppliers',
    path: '/suppliers',
    icon: <HiOutlineUsers />,
  },
  {
    key: 'transactions',
    label: 'Users',
    path: '/iperformance',
    icon: <HiOutlineDocumentText />,
  },
  // {
  //   key: 'messages',
  //   label: 'Messages',
  //   path: '/messages',
  //   icon: <HiOutlineAnnotation />,
  // },
]

export const DASHBOARD_SIDEBAR_BOTTOM_LINKS = [
  // {
  //   key: 'settings',
  //   label: 'Settings',
  //   path: '/settings',
  //   icon: <HiOutlineCog />,
  // },
  // {
  //   key: 'support',
  //   label: 'Help & Support',
  //   path: '/support',
  //   icon: <HiOutlineQuestionMarkCircle />,
  // },
]
