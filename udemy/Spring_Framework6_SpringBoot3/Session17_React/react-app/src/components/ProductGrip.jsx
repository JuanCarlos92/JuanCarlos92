import { ProductDetails } from "./ProductDetails"

// Componente para mostrar la lista de productos en una tabla
export const ProductGrip = ({products}) => {
    return (
            <table>
                <thead>
                    <tr>
                        <th>name</th>
                        <th>description</th>
                        <th>price</th>
                    </tr>
                </thead>
                <tbody>
                    {products.map(product => {
                        return <ProductDetails product ={product}  key={product.name} />
                    })}
                </tbody>
            </table>
    )
}
