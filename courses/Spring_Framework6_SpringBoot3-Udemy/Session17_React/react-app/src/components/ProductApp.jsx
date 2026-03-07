import { useEffect, useState } from 'react';
import { listProducts } from '../services/ProductService';
import { ProductGrip } from './ProductGrip';


// Componente principal de la aplicación
export const ProductApp = () => {
    const [products, setProducts] = useState([]);

    // useEffect para cargar los productos al montar el componente
    useEffect(() => {
        const result = listProducts();
        setProducts(result);
    }, []);
    // Renderizamos el componente
    return (
        <>
            <h1>Hola mundo react!</h1>
            <ProductGrip products ={products}/>
        </>
    );
}