import React, { createContext, useState, useContext } from 'react';

const CartContext = createContext();

const CartProvider = ({ children }) => {
    const [cart, setCart] = useState([]);

    // In CartContext...
const clearCart = () => {
    setCart([]);
};

    const addToCart = (item) => {
        setCart((prevItems) => {
            // Check if item already exists in the cart
            const existingItem = prevItems.find(i => i.id === item.id);
            if (existingItem) {
                // If it exists, update the quantity
                return prevItems.map(i => 
                    i.id === item.id ? { ...i, quantity: i.quantity + item.quantity } : i
                );
            } else {
                // If it doesn't exist, add it to the cart
                return [...prevItems, item];
            }
        });
    };

    const removeFromCart = (itemId) => {
        setCart((prevItems) => prevItems.filter(item => item.id !== itemId));
    };

    const total = cart.reduce((acc, item) => acc + item.price * item.quantity, 0);

    const purchaseItems = () => {
        if (total > 100000) {
            // Display the modal and handle logic
        } else {
            // Continue with the purchase process
        }
    };
    
    return (
        <CartContext.Provider value={{ cart, addToCart, removeFromCart, total, purchaseItems,clearCart }}>
            {children}
        </CartContext.Provider>
    );
};

export { CartContext, CartProvider };
