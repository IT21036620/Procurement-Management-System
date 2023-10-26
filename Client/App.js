import { Navigator } from './Navigation/Navigator';
import { CartProvider } from './Context/CartContext';
import { OrderProvider } from './Context/OrderContext';

export default function App() {
  return (
    <OrderProvider>
    <CartProvider>
    <Navigator/>
    </CartProvider>
    </OrderProvider>
  );
}

